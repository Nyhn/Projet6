package com.oc.Climb.controller;

import com.oc.Climb.DAO.*;
import com.oc.Climb.enums.Level;
import com.oc.Climb.enums.Role;
import com.oc.Climb.enums.State;
import com.oc.Climb.model.*;
import com.oc.Climb.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.*;
import java.util.Date;
import java.util.List;

@Controller
public class AppController {
    @Autowired
    private UserService userService;
    @Autowired
    private ToposService toposService;
    @Autowired
    private SiteService siteService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private EncryptPassword encryptPassword;
    @Autowired
    private UserFormCheck userFormCheck;
    @Autowired
    private ToposFormCheck toposFormCheck;
    @Autowired
    private SiteFormCheck siteFormCheck;

    @RequestMapping("/")
    public String viewHomepagePage(Model model, HttpServletRequest request) {
        User userCurrent = getUserSession(request);
        model.addAttribute("userCurrent", userCurrent);
        return "homepage";
    }

    @RequestMapping(value ="/addTopos", method = RequestMethod.GET)
    public String viewAddToposPage(Model model, HttpServletRequest request) {
        User userCurrent = getUserSession(request);
        model.addAttribute("userCurrent", userCurrent);
        if(userCurrent.getRole() == Role.NOT_CONNECTED)
            return "redirect:/logIn";
        Topos topos = new Topos();
        model.addAttribute("toposFormCheck",toposFormCheck);
        model.addAttribute("topos", topos);
        return "addTopos";
    }

    @RequestMapping(value = "/toposCheck", method = RequestMethod.POST)
    public String saveToposAndViewToposCheckPage(HttpServletRequest request, @ModelAttribute("topos") Topos topos, Model model) {
        User userCurrent = getUserSession(request);
        model.addAttribute("userCurrent", userCurrent);
        if(userCurrent.getRole() == Role.NOT_CONNECTED)
            return "redirect:/logIn";
        toposFormCheck.evaluate(topos);
        if (!toposFormCheck.validate()) {
            model.addAttribute("toposFormCheck",toposFormCheck);
            model.addAttribute("topos", topos);
            return "addTopos";
        }
        topos.setDate(toposFormCheck.dateCheck(topos.getDate()));
        topos.setUser(userCurrent);
        toposService.save(topos);
        return "redirect:/library";
    }

    @RequestMapping(value = "/editTopos/{id}")
    public ModelAndView showEditToposPage(HttpServletRequest request,@PathVariable(name = "id") Long id) {
        User userCurrent = getUserSession(request);
        ModelAndView modelAndView = new ModelAndView("editTopos");
        Topos topos = toposService.get(id);
        modelAndView.addObject("toposFormCheck", toposFormCheck);
        modelAndView.addObject("topos", topos);
        modelAndView.addObject("userCurrent",userCurrent);
        return modelAndView;
    }

    @RequestMapping(value = "/deleteTopos/{id}")
    public String showDeleteToposPage(@PathVariable(name = "id") Long id) {
        toposService.delete(id);
        return "redirect:/account";
    }

    @RequestMapping("/register")
    public String viewRegisterPage(Model model, HttpServletRequest request) {
        User userCurrent = getUserSession(request);
        model.addAttribute("userCurrent", userCurrent);
        if(userCurrent.getRole() == Role.NOT_CONNECTED) {
            model.addAttribute("userFormCheck",userFormCheck);
            return "register";
        }
        return "redirect:/account";
    }

    @RequestMapping(value = "/registerCheck", method = RequestMethod.POST)
    public String viewRegisterCheckPageAndSaveUser(Model model, HttpServletRequest request, @ModelAttribute("userCurrent") User userCurrent) {
        userCurrent.setRole(Role.USER);
        userFormCheck.evaluate(userCurrent,request,userService.findByPseudo(userCurrent.getPseudo()),userService.findBymail(userCurrent.getMail()));
        userCurrent.setPassword(encryptPassword.encrypt(userCurrent));
        model.addAttribute("userCurrent", userCurrent);
        if(!userFormCheck.validate()){
            model.addAttribute("userFormCheck",userFormCheck);
            return "register";
        }
        userService.save(userCurrent);
        HttpSession session = request.getSession();
        session.removeAttribute("userCurrent");
        session.setAttribute("userCurrent", userCurrent);
        return "redirect:/";
    }

    @RequestMapping(value = "/userCheck", method = RequestMethod.POST)
    public String verifUserAndSave(Model model,HttpServletRequest request, @ModelAttribute("userCurrent") User userCurrent) {
        userFormCheck.evaluateModif(userCurrent);
        model.addAttribute("userCurrent", userCurrent);
        if(userFormCheck.validate()){
            userService.save(userCurrent);
        }
        HttpSession session = request.getSession();
        session.removeAttribute("userCurrent");
        session.setAttribute("userCurrent", userCurrent);
        return "redirect:/account";
    }

    @RequestMapping(value = "/editUser/{id}")
    public ModelAndView showEditUserPage(HttpServletRequest request,@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("editUser");
        User userCurrent = getUserSession(request);
        modelAndView.addObject("userCurrent", userCurrent);
        modelAndView.addObject("userFormCheck",userFormCheck);
        User user = userService.get(id);
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping("/logIn")
    public String viewLogInPage(Model model, HttpServletRequest request) {
        User userCurrent = getUserSession(request);
        model.addAttribute("userCurrent", userCurrent);
        if (userCurrent.getRole() == Role.NOT_CONNECTED)
            return "logIn";
        return "redirect:/";
    }

    @RequestMapping(value = "/logInCheck", method = RequestMethod.POST)
    public String viewLogInCheckPage(HttpServletRequest request, Model model, @ModelAttribute("user") User user){
        HttpSession session = request.getSession();
        User userCurrent = (User) session.getAttribute("userCurrent");
        user.setPassword(encryptPassword.encrypt(user));
        if (userCurrent == null) {
            User userSearch = userService.findByPseudo(user.getPseudo());
            if(userSearch != null){
                if (user.getPassword().equals(userSearch.getPassword())) {
                    model.addAttribute("userCurrent", userSearch);
                    session.setAttribute("userCurrent", userSearch);
                    return "redirect:/";
                }
            }
            model.addAttribute("userCurrent", new User());
            model.addAttribute("message", " Connexion échoué ! réessayer !");
            return "logIn";
        }
        return "redirect:/";

    }

    @RequestMapping("/logOut")
    public String logoutAndViewHomepage( HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("userCurrent");
        return "redirect:/";
    }

    @RequestMapping("/catalog")
    public String viewCatalogPage(HttpServletRequest request,Model model) {
        User userCurrent = getUserSession(request);
        model.addAttribute("userCurrent", userCurrent);
        SearchSiteForm searchSiteForm = new SearchSiteForm();
        List<Site> siteList = siteService.listAll();
        model.addAttribute("siteList", siteList);
        model.addAttribute("search", searchSiteForm);
        return "catalog";
    }

    @RequestMapping("/catalogSearch")
    public String viewCatalogSearchPage(HttpServletRequest request,Model model,@ModelAttribute("search") SearchSiteForm searchSiteForm) {
        User userCurrent = getUserSession(request);
        List<Site> siteList;
        if(searchSiteForm.getPlace() != ""){
            if(searchSiteForm.getOfficial()){
                if(searchSiteForm.getNbSectors()!= -1){
                    if(searchSiteForm.getNbSectors()>=8) {
                        if (searchSiteForm.getLevel() != Level.NOT_SELECTED) {
                            siteList = siteService.findSiteBySearchPlaceAndSectorSuppAndLevelAndOfficial(searchSiteForm.getPlace(), searchSiteForm.getLevel());
                        }else
                            siteList = siteService.findSiteBySearchPlaceAndSectorSuppAndOfficial(searchSiteForm.getPlace());
                    }
                    else{
                        if (searchSiteForm.getLevel() != Level.NOT_SELECTED)
                            siteList = siteService.findSiteBySearchPlaceAndSectorAndLevelAndOfficial(searchSiteForm.getPlace(),searchSiteForm.getNbSectors(),searchSiteForm.getLevel());
                        else
                            siteList = siteService.findSiteBySearchPlaceAndSectorAndOfficial(searchSiteForm.getPlace(),searchSiteForm.getNbSectors());
                    }
                }
                else {
                    if (searchSiteForm.getLevel() != Level.NOT_SELECTED)
                            siteList = siteService.findSiteBySearchPlaceAndLevelAndOfficial(searchSiteForm.getPlace(),searchSiteForm.getLevel());
                    else
                            siteList = siteService.findSiteBySearchPlaceAndOfficial(searchSiteForm.getPlace());
                }
            }
            else {
                if(searchSiteForm.getNbSectors()!= -1){
                    if(searchSiteForm.getNbSectors()>=8) {
                        if (searchSiteForm.getLevel() != null)
                            siteList = siteService.findSiteBySearchPlaceAndSectorSuppAndLevel(searchSiteForm.getPlace(),searchSiteForm.getLevel());
                        else
                            siteList = siteService.findSiteBySearchPlaceAndSectorSupp(searchSiteForm.getPlace());
                    }
                    else{
                        if (searchSiteForm.getLevel() != Level.NOT_SELECTED)
                            siteList = siteService.findSiteBySearchPlaceAndSectorAndLevel(searchSiteForm.getPlace(),searchSiteForm.getNbSectors(),searchSiteForm.getLevel());
                        else
                            siteList = siteService.findSiteBySearchPlaceAndSector(searchSiteForm.getPlace(),searchSiteForm.getNbSectors());
                    }
                }
                else {
                    if (searchSiteForm.getLevel() != Level.NOT_SELECTED)
                        siteList = siteService.findSiteBySearchPlaceAndLevel(searchSiteForm.getPlace(),searchSiteForm.getLevel());
                    else
                        siteList = siteService.findSiteBySearchPlace(searchSiteForm.getPlace());
                    }
                }
        }
        else {
            if(searchSiteForm.getOfficial()){
                if(searchSiteForm.getNbSectors()!= -1){
                    if(searchSiteForm.getNbSectors()>=8) {
                        if (searchSiteForm.getLevel() != Level.NOT_SELECTED)
                            siteList = siteService.findSiteBySearchSectorSuppAndLevelAndOfficial(searchSiteForm.getLevel());
                        else
                            siteList = siteService.findSiteBySearchSectorSuppAndOfficial();
                    }
                    else{
                        if (searchSiteForm.getLevel() != Level.NOT_SELECTED)
                            siteList = siteService.findSiteBySearchSectorAndLevelAndOfficial(searchSiteForm.getNbSectors(),searchSiteForm.getLevel());
                        else
                            siteList = siteService.findSiteBySearchSectorAndOfficial(searchSiteForm.getNbSectors());
                    }
                }
                else {
                    if (searchSiteForm.getLevel() != Level.NOT_SELECTED)
                        siteList = siteService.findSiteBySearchLevelAndOfficial(searchSiteForm.getLevel());
                    else
                        siteList = siteService.findSiteBySearchOfficial();
                }
            }
            else {
                if(searchSiteForm.getNbSectors()!= -1){
                    if(searchSiteForm.getNbSectors()>=8) {
                        if (searchSiteForm.getLevel() != Level.NOT_SELECTED)
                            siteList = siteService.findSiteBySearchSectorSuppAndLevel(searchSiteForm.getLevel());
                        else
                            siteList = siteService.findSiteBySearchSectorSupp();
                    }
                    else{
                        if (searchSiteForm.getLevel() != Level.NOT_SELECTED)
                            siteList = siteService.findSiteBySearchSectorAndLevel(searchSiteForm.getNbSectors(),searchSiteForm.getLevel());
                        else
                            siteList = siteService.findSiteBySearchSector(searchSiteForm.getNbSectors());
                    }
                }
                else {
                    if (searchSiteForm.getLevel() != Level.NOT_SELECTED)
                        siteList = siteService.findSiteBySearchLevel(searchSiteForm.getLevel());
                    else
                        return "redirect:/catalog";
                }
            }
        }
        model.addAttribute("userCurrent", userCurrent);
        model.addAttribute("siteList",siteList);
        model.addAttribute("search",searchSiteForm);
        searchSiteForm.init();
        return "catalog";
    }

    @RequestMapping("/library")
    public String viewLibrairyPage(HttpServletRequest request,Model model) {
        User userCurrent = getUserSession(request);
        model.addAttribute("userCurrent", userCurrent);
        SearchToposForm searchToposForm = new SearchToposForm();
        List<Topos> toposList;
        if(userCurrent.getRole() == Role.NOT_CONNECTED)
            toposList = toposService.findToposByAvalaible();
        else
            toposList = toposService.getAllToposWithOutToposUserAndAvailable(userCurrent);
        model.addAttribute("toposList", toposList);
        model.addAttribute("search", searchToposForm);
        return "library";
    }

    @RequestMapping(value = "/librarySearch")
    public String viewLibrarySearchPage(HttpServletRequest request,Model model,@ModelAttribute("searchForm") SearchToposForm searchToposForm) {
        User userCurrent = getUserSession(request);
        model.addAttribute("userCurrent", userCurrent);
        List<Topos> toposListWithSearch = toposService.findToposBySearch(searchToposForm.getTitleOrAutor());
        if(searchToposForm.getTitleOrAutor() != "")
            model.addAttribute("toposList", toposListWithSearch);
        else
            return "redirect:/library";
        model.addAttribute("search", searchToposForm);
        searchToposForm.init();
        return "library";
    }


    @RequestMapping("/addSite")
    public String viewAddSitePage(Model model, HttpServletRequest request) {
        User userCurrent = getUserSession(request);
        model.addAttribute("userCurrent", userCurrent);
        if(userCurrent.getRole() == Role.NOT_CONNECTED)
            return "redirect:/logIn";
        Site site = new Site();
        model.addAttribute("site", site);
        model.addAttribute("siteFormCheck",siteFormCheck);
        return "addSite";
    }

    @RequestMapping(value = "/siteCheck", method = RequestMethod.POST)
    public String saveSiteAndViewSiteCheckPage(HttpServletRequest request, @ModelAttribute("site") Site site, Model model) {
        User userCurrent = getUserSession(request);
        if(userCurrent.getRole() == Role.NOT_CONNECTED)
            return "redirect:/LogIn";
        siteFormCheck.evaluate(site);
        model.addAttribute("userCurrent",userCurrent);
        if(!siteFormCheck.validate()){
            model.addAttribute("siteFormCheck",siteFormCheck);
            model.addAttribute("site",site);
            return "addSite";
        }
        siteService.save(site);
        return "redirect:/catalog";
    }

    @RequestMapping("/account")
    public String viewAccountPage(Model model, HttpServletRequest request) {
        User userCurrent = getUserSession(request);
        model.addAttribute("userCurrent", userCurrent);
        if(userCurrent.getRole() == Role.NOT_CONNECTED)
            return "redirect:/logIn";
        List<Topos> toposList = toposService.findToposByUser(userCurrent);
        List<Booking> bookingList = bookingService.findByUserBookingRequired(userCurrent);
        List<Booking> historical = bookingService.findByUserBooking(userCurrent);
        List<Booking> acceptList = bookingService.getCoordonateUserBookingByBookingAccepted(userCurrent);
        List<Booking> requestAcceptList = bookingService.getCoordonateUserToposByBookingAccepted(userCurrent);
        model.addAttribute("toposList", toposList);
        model.addAttribute("bookingList", bookingList);
        model.addAttribute("historical", historical);
        model.addAttribute("acceptList",acceptList);
        model.addAttribute("requestAcceptList",requestAcceptList);
        return "account";
    }

    @RequestMapping("/user")
    public String viewUserPage(Model model, HttpServletRequest request) {
        User userCurrent = getUserSession(request);
        model.addAttribute("userCurrent", userCurrent);
        if(userCurrent.getRole() == Role.NOT_CONNECTED)
            return "redirect:/logIn";
        List<User> userList = userService.listAll();
        model.addAttribute("userList",userList);
        return "user";
    }

    @RequestMapping(value = "/saveComment/{id}", method = RequestMethod.POST)
    public String saveComment(HttpServletRequest request,@ModelAttribute("comment") Comment comment, @PathVariable(name = "id") Long id,Model model) {
        if(comment.getText().length()>2000)
            return "redirect:/climbingSite/"+id;
        else{
            comment.setId(null);
            comment.setSite(siteService.get(id));
            User userCurrent = getUserSession(request);
            comment.setUser(userCurrent);
            commentService.save(comment);
        }
        return "redirect:/climbingSite/{id}";
    }

    @RequestMapping(value = "/climbingSite/{id}")
    public ModelAndView showClimbingSitePage(HttpServletRequest request,@PathVariable(name = "id") Long id) {
        User userCurrent = getUserSession(request);
        ModelAndView modelAndView = new ModelAndView("climbingSite");
        Site siteSelect = siteService.get(id);
        modelAndView.addObject("site", siteSelect);
        modelAndView.addObject("userCurrent",userCurrent);
        List<Comment> commentList = commentService.getBySite(siteSelect);
        modelAndView.addObject("commentList", commentList);
        modelAndView.addObject("comment", new Comment());
        return modelAndView;
    }

    @RequestMapping(value = "/climbingTopos/{id}")
    public ModelAndView showClimbingToposPage(HttpServletRequest request,@PathVariable(name = "id") Long id) {
        User userCurrent = getUserSession(request);
        ModelAndView modelAndView = new ModelAndView("climbingTopos");
        Topos toposSelect = toposService.get(id);
        modelAndView.addObject("topos", toposSelect);
        modelAndView.addObject("userCurrent", userCurrent);
        return modelAndView;
    }

    @RequestMapping(value = "/editComment/{id}")
    public ModelAndView showEditCommentPage(HttpServletRequest request,@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("editComment");
        User userCurrent = getUserSession(request);
        Comment comment = commentService.get(id);
        modelAndView.addObject("comment", comment);
        modelAndView.addObject("userCurrent", userCurrent);
        return modelAndView;
    }

    @RequestMapping(value = "/modifComment/{id}", method = RequestMethod.POST)
    public String modifComment(@ModelAttribute("comment") Comment comment) {
        commentService.save(comment);
        Long idSite = comment.getSite().getId();
        return "redirect:/climbingSite/" + idSite;
    }

    @RequestMapping(value = "/deleteComment/{id}")
    public String showDeleteCommentPage(@PathVariable(name = "id") Long id) {
        Long idSite = commentService.get(id).getSite().getId();
        commentService.delete(id);
        return "redirect:/climbingSite/" + idSite;
    }

    @RequestMapping(value = "/putOfficial/{id}", method = RequestMethod.GET)
    public String putOfficial(@PathVariable(name = "id") Long id) {
        Site site = siteService.get(id);
        site.setOfficial(true);
        siteService.save(site);
        return "redirect:/climbingSite/{id}";
    }

    @RequestMapping(value = "/booking/{id}", method = RequestMethod.GET)
    public String createBooking(Model model,HttpServletRequest request,@PathVariable(name = "id") Long id) {
        User userCurrent = getUserSession(request);
        model.addAttribute("userCurrent", userCurrent);
        Topos topos = toposService.get(id);
        Booking booking = new Booking();
        booking.setState(State.REQUIRED);
        booking.setTopos(topos);
        booking.setUser(userCurrent);
        booking.setDate(new Date());
        bookingService.save(booking);
        return "redirect:/climbingTopos/{id}";
    }

    @RequestMapping(value = "/unputOfficial/{id}", method = RequestMethod.GET)
    public String unputOfficial(@PathVariable(name = "id") Long id) {
        Site site = siteService.get(id);
        site.setOfficial(false);
        siteService.save(site);
        return "redirect:/climbingSite/{id}";
    }

    @RequestMapping(value = "/putMember/{id}", method = RequestMethod.GET)
    public String putMember(@PathVariable(name = "id") Long id) {
        User user= userService.get(id);
        user.setRole(Role.MEMBER);
        userService.save(user);
        return "redirect:/user";
    }

    @RequestMapping(value = "/acceptBooking/{id}", method = RequestMethod.GET)
    public String acceptBooking(@PathVariable(name = "id") Long id) {
        Booking booking= bookingService.get(id);
        booking.getTopos().setAvailable(false);
        booking.setState(State.ACCEPTED);
        bookingService.save(booking);
        return "redirect:/account";
    }

    @RequestMapping(value = "/refusedBooking/{id}", method = RequestMethod.GET)
    public String refusedBooking(@PathVariable(name = "id") Long id) {
        Booking booking= bookingService.get(id);
        booking.setState(State.REFUSE);
        bookingService.save(booking);
        return "redirect:/account";
    }

    public User getUserSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("userCurrent");
        if(user == null)
            user = new User();
        return user;
    }
}
