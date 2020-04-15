package com.oc.Climb.controller;

import com.oc.Climb.DAO.SiteService;
import com.oc.Climb.DAO.ToposService;
import com.oc.Climb.DAO.UserService;
import com.oc.Climb.enums.Role;
import com.oc.Climb.manager.LogInManager;
import com.oc.Climb.model.Site;
import com.oc.Climb.model.Topos;
import com.oc.Climb.model.User;
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
/* page général */

    @RequestMapping("/")
    public String viewHomepagePage(Model model, HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        Long idCurrent = (Long) session.getAttribute("idCurrent");
        User userCurrent=null;
        if(idCurrent != null)
            userCurrent = userService.get(idCurrent);

        LogInManager logInManager = new LogInManager();
        model.addAttribute("role", logInManager.checkLog(userCurrent));
        List<Site> siteList = siteService.listAll();
        model.addAttribute("highlightSite",siteList);
        System.out.println(logInManager.checkLog(userCurrent));
        return "homepage";
    }
/* page qui manipule topos */

    @RequestMapping("/addTopos")
    public String viewAddToposPage(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        Long idCurrent = (Long) session.getAttribute("idCurrent");
        if(idCurrent != null) {
            Topos topos = new Topos();
            model.addAttribute("topos", topos);
            return "addTopos";
        }
        return "redirect:/logIn";
    }

    @RequestMapping(value = "/toposCheck",method = RequestMethod.POST)
    public String saveToposAndViewToposCheckPage( HttpServletRequest request,@ModelAttribute("topos") Topos topos,Model model){

        HttpSession session = request.getSession();
        User userCurrent = userService.get((Long)session.getAttribute("idCurrent"));
        if(userCurrent != null) {
            topos.setUser(userCurrent);
            toposService.save(topos);
            List<Topos> toposList = toposService.findToposByUser(userCurrent);
            model.addAttribute("listTopos", toposList);
        }
        return "toposCheck";
    }

    @RequestMapping(value = "/editTopos/{id}")
    public ModelAndView showEditToposPage(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("editTopos");

        Topos topos = toposService.get(id);
        modelAndView.addObject("topos",topos);

        return modelAndView;
    }
    @RequestMapping(value = "/deleteTopos/{id}")
    public String showDeleteToposPage(@PathVariable(name = "id") Long id){
        toposService.delete(id);

        return "redirect:/account";
    }

/* page qui manipule User */

    @RequestMapping("/register")
    public String viewRegisterPage(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        Long idCurrent = (Long) session.getAttribute("idCurrent");
        if(idCurrent == null) {
            User user = new User();
            model.addAttribute("user",user);
            return "register";
        }
        return "redirect:/";/* Compte -> a changer */
    }


    @RequestMapping(value = "/registerCheck",method = RequestMethod.POST)
    public String viewRegisterCheckPageAndSaveUser(Model model,HttpServletRequest request,@ModelAttribute("user") User userCurrent){
        userCurrent.setRole(Role.USER);
        userService.save(userCurrent);
        model.addAttribute("userCurrent",userCurrent);
        List<User> userList = userService.listAll();
        model.addAttribute("listUsers",userList);
        HttpSession session = request.getSession();
        session.setAttribute("idCurrent",userCurrent.getId());

        return "registerCheck";
    }

    @RequestMapping(value = "/editUser/{id}")
    public ModelAndView showEditUserPage(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("editUser");

        User user = userService.get(id);
        modelAndView.addObject("user",user);

        return modelAndView;
    }

    @RequestMapping("/logIn")
    public String viewCatalogPage(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        Long idCurrent = (Long) session.getAttribute("idCurrent");
        if(idCurrent == null) {
            User user = new User();
            model.addAttribute("user", user);
            return "logIn";
        }
        return "redirect:/";
    }


    @RequestMapping(value = "/logInCheck",method = RequestMethod.POST)
    public String viewLogInCheckPage(HttpServletResponse response,HttpServletRequest request,Model model, @ModelAttribute("user") User user){
        HttpSession session = request.getSession();
        Long idCurrent = (Long) session.getAttribute("idCurrent");
        if(idCurrent == null) {
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
    public String logoutAndViewHomepage(HttpServletResponse response, HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("idCurrent");
        return "redirect:/";
    }
/* page à gérer BDD */


    @RequestMapping("/catalog")
    public String viewLogInPage(Model model){
        List<Site> siteList = siteService.listAll();
        model.addAttribute("siteList",siteList);
        return "catalog";
    }


    @RequestMapping("/climbingSite")
    public String viewClimbingSitePage(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "climbingSite";
    }

    @RequestMapping("/addSite")
    public String viewAddSitePage(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        Long idCurrent = (Long) session.getAttribute("idCurrent");
        if(idCurrent != null) {
            Site site = new Site();
            model.addAttribute("site", site);
            return "addSite";
        }
        return "redirect:/logIn";
    }

    @RequestMapping(value = "/siteCheck",method = RequestMethod.POST)
    public String saveSiteAndViewSiteCheckPage( HttpServletRequest request,@ModelAttribute("site") Site site,Model model){

        HttpSession session = request.getSession();
        User userCurrent = userService.get((Long)session.getAttribute("idCurrent"));
        if(userCurrent != null) {
            siteService.save(site);
        }
        model.addAttribute("site",site);
        List<Site> siteList = siteService.listAll();
        model.addAttribute("siteList",siteList);

        return "siteCheck";
    }

    @RequestMapping("/account")
    public String viewAccountPage(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        User userCurrent = userService.get((Long)session.getAttribute("idCurrent"));
        if(userCurrent != null) {
            model.addAttribute("userCurrent",userCurrent);
            List<Topos> toposList = toposService.findToposByUser(userCurrent);
            model.addAttribute("toposList",toposList);
            return "account";
        }
        return "redirect:/logIn";
    }

    @RequestMapping(value = "/climbingSite/{id}")
    public String showClimbingSitePage(@PathVariable(name = "id") Long id,Model model){
        Site siteSelect = siteService.get(id);
        model.addAttribute("site",siteSelect);

        return "climbingSite/{id}";
    }
}
