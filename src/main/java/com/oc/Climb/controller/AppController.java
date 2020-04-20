package com.oc.Climb.controller;

import com.oc.Climb.DAO.CommentService;
import com.oc.Climb.DAO.SiteService;
import com.oc.Climb.DAO.ToposService;
import com.oc.Climb.DAO.UserService;
import com.oc.Climb.enums.Role;
import com.oc.Climb.manager.LogInManager;
import com.oc.Climb.model.Comment;
import com.oc.Climb.model.Site;
import com.oc.Climb.model.Topos;
import com.oc.Climb.model.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.*;
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
    /* page général */

    @RequestMapping("/")
    public String viewHomepagePage(Model model, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Long idCurrent = (Long) session.getAttribute("idCurrent");
        User userCurrent = null;
        if (idCurrent != null)
            userCurrent = userService.get(idCurrent);

        LogInManager logInManager = new LogInManager();
        model.addAttribute("role", logInManager.checkLog(userCurrent));
        List<Site> siteList = siteService.listAll();
        model.addAttribute("highlightSite", siteList);
        System.out.println(logInManager.checkLog(userCurrent));
        return "homepage";
    }
    /* page qui manipule topos */

    @RequestMapping("/addTopos")
    public String viewAddToposPage(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long idCurrent = (Long) session.getAttribute("idCurrent");
        if (idCurrent != null) {
            Topos topos = new Topos();
            model.addAttribute("topos", topos);
            return "addTopos";
        }
        return "redirect:/logIn";
    }

    @RequestMapping(value = "/toposCheck", method = RequestMethod.POST)
    public String saveToposAndViewToposCheckPage(HttpServletRequest request, @ModelAttribute("topos") Topos topos, Model model) {

        HttpSession session = request.getSession();
        User userCurrent = userService.get((Long) session.getAttribute("idCurrent"));
        if (userCurrent != null) {
            topos.setUser(userCurrent);
            toposService.save(topos);
            List<Topos> toposList = toposService.findToposByUser(userCurrent);
            model.addAttribute("listTopos", toposList);
        }
        return "toposCheck";
    }

    @RequestMapping(value = "/editTopos/{id}")
    public ModelAndView showEditToposPage(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("editTopos");

        Topos topos = toposService.get(id);
        modelAndView.addObject("topos", topos);

        return modelAndView;
    }

    @RequestMapping(value = "/deleteTopos/{id}")
    public String showDeleteToposPage(@PathVariable(name = "id") Long id) {
        toposService.delete(id);

        return "redirect:/account";
    }

    /* page qui manipule User */

    @RequestMapping("/register")
    public String viewRegisterPage(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long idCurrent = (Long) session.getAttribute("idCurrent");
        if (idCurrent == null) {
            User user = new User();
            model.addAttribute("user", user);
            return "register";
        }
        return "redirect:/";/* Compte -> a changer */
    }


    @RequestMapping(value = "/registerCheck", method = RequestMethod.POST)
    public String viewRegisterCheckPageAndSaveUser(Model model, HttpServletRequest request, @ModelAttribute("user") User userCurrent) {
        userCurrent.setRole(Role.USER);
        userService.save(userCurrent);
        model.addAttribute("userCurrent", userCurrent);
        List<User> userList = userService.listAll();
        model.addAttribute("listUsers", userList);
        HttpSession session = request.getSession();
        session.setAttribute("idCurrent", userCurrent.getId());

        return "registerCheck";
    }

    @RequestMapping(value = "/editUser/{id}")
    public ModelAndView showEditUserPage(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("editUser");

        User user = userService.get(id);
        modelAndView.addObject("user", user);

        return modelAndView;
    }

    @RequestMapping("/logIn")
    public String viewCatalogPage(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long idCurrent = (Long) session.getAttribute("idCurrent");
        if (idCurrent == null) {
            User user = new User();
            model.addAttribute("user", user);
            return "logIn";
        }
        return "redirect:/";
    }


    @RequestMapping(value = "/logInCheck", method = RequestMethod.POST)
    public String viewLogInCheckPage(HttpServletResponse response, HttpServletRequest request, Model model, @ModelAttribute("user") User user) {
        HttpSession session = request.getSession();
        Long idCurrent = (Long) session.getAttribute("idCurrent");
        if (idCurrent == null) {
            User userSearch = userService.findByPseudo(user.getPseudo());
            String message = "";
            if (user.getPassword().equals(userSearch.getPassword())) {
                if (userSearch != null) {
                    model.addAttribute("userSearch", userSearch);
                    session.setAttribute("idCurrent", userSearch.getId());
                    return "logInCheck";
                }
            }
            message = " Connexion échoué ! réessayer !";
            model.addAttribute("message", message);
            return "redirect:/logIn";
        }
        return "redirect:/";

    }

    @RequestMapping("/logOut")
    public String logoutAndViewHomepage(HttpServletResponse response, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("idCurrent");
        return "redirect:/";
    }
    /* page à gérer BDD */


    @RequestMapping("/catalog")
    public String viewCatalogPage(Model model) {
        List<Site> siteList = siteService.listAll();
        model.addAttribute("siteList", siteList);
        return "catalog";
    }

    @RequestMapping("/librairy")
    public String viewLibrairyPage(Model model) {
        List<Topos> toposList = toposService.findToposByAvalaible();
        model.addAttribute("toposList", toposList);
        return "librairy";
    }


    @RequestMapping("/addSite")
    public String viewAddSitePage(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long idCurrent = (Long) session.getAttribute("idCurrent");
        if (idCurrent != null) {
            Site site = new Site();
            model.addAttribute("site", site);
            return "addSite";
        }
        return "redirect:/logIn";
    }

    @RequestMapping(value = "/siteCheck", method = RequestMethod.POST)
    public String saveSiteAndViewSiteCheckPage(HttpServletRequest request, @ModelAttribute("site") Site site, Model model) {

        HttpSession session = request.getSession();
        User userCurrent = userService.get((Long) session.getAttribute("idCurrent"));
        if (userCurrent != null) {
            siteService.save(site);
        }
        model.addAttribute("site", site);
        List<Site> siteList = siteService.listAll();
        model.addAttribute("siteList", siteList);

        return "siteCheck";
    }

    @RequestMapping("/account")
    public String viewAccountPage(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User userCurrent = userService.get((Long) session.getAttribute("idCurrent"));
        if (userCurrent != null) {
            model.addAttribute("userCurrent", userCurrent);
            List<Topos> toposList = toposService.findToposByUser(userCurrent);
            model.addAttribute("toposList", toposList);
            return "account";
        }
        return "redirect:/logIn";
    }

    @RequestMapping(value = "/saveComment/{id}", method = RequestMethod.POST)
    public String saveComment(HttpServletRequest request, @ModelAttribute("comment") Comment comment, @PathVariable(name = "id") Long id) {
        comment.setId(null);
        comment.setSite(siteService.get(id));
        HttpSession session = request.getSession();
        User userCurrent = userService.get((Long) session.getAttribute("idCurrent"));
        comment.setUser(userCurrent);
        commentService.save(comment);
        return "redirect:/climbingSite/{id}";
    }

    @RequestMapping(value = "/climbingSite/{id}")
    public ModelAndView showClimbingSitePage(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("climbingSite");
        Site siteSelect = siteService.get(id);
        modelAndView.addObject("site", siteSelect);
        List<Comment> commentList = commentService.getBySite(siteSelect);
        modelAndView.addObject("commentList", commentList);
        Comment comment = new Comment();
        modelAndView.addObject("comment", comment);

        return modelAndView;
    }

    @RequestMapping(value = "/climbingTopos/{id}")
    public ModelAndView showClimbingToposPage(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("climbingTopos");
        Topos toposSelect = toposService.get(id);
        modelAndView.addObject("topos", toposSelect);

        return modelAndView;
    }

    @RequestMapping(value = "/editComment/{id}")
    public ModelAndView showEditCommentPage(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("editComment");

        Comment comment = commentService.get(id);
        modelAndView.addObject("comment", comment);

        return modelAndView;
    }

    @RequestMapping(value = "/modifComment/{id}", method = RequestMethod.POST)
    public String modifComment(HttpServletRequest request, @ModelAttribute("comment") Comment comment, @PathVariable(name = "id") Long id) {
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
    public String booking(HttpServletRequest request,@PathVariable(name = "id") Long id) {
        HttpSession session = request.getSession();
        User userCurrent = userService.get((Long) session.getAttribute("idCurrent"));
        Topos topos = toposService.get(id);
        topos.setUserBooking(userCurrent);
        topos.setAvailable(false);
        toposService.save(topos);
        return "redirect:/climbingTopos/{id}";
    }

    @RequestMapping(value = "/unputOfficial/{id}", method = RequestMethod.GET)
    public String unputOfficial(@PathVariable(name = "id") Long id) {
        Site site = siteService.get(id);
        site.setOfficial(false);
        siteService.save(site);
        return "redirect:/climbingSite/{id}";
    }

}
