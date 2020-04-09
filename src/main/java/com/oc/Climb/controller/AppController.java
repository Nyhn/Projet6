package com.oc.Climb.controller;

import com.oc.Climb.DAO.ToposService;
import com.oc.Climb.DAO.UserService;
import com.oc.Climb.manager.LogInManager;
import com.oc.Climb.model.Topos;
import com.oc.Climb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Controller
public class AppController {
    @Autowired
    private UserService userService;

    @Autowired
    private ToposService toposService;
/* page général */

    @RequestMapping("/")
    public String viewHomepagePage(Model model, HttpServletRequest request, HttpServletResponse response, @CookieValue(value="id",defaultValue = "-1") String id){
        if(id == "-1")
            System.out.println("000000");
        else
            model.addAttribute("id",id);
        return "homepage";
    }
/* page qui manipule topos */

    @RequestMapping("/addTopos")
    public String viewAddToposPage(Model model){
        Topos topos = new Topos();
        model.addAttribute("topos",topos);
        return "addTopos";
    }

    @RequestMapping(value = "/toposCheck",method = RequestMethod.POST)
    public String saveToposAndViewToposCheckPage(@ModelAttribute("topos") Topos topos,/*@CookieValue(value="id",defaultValue = "-1") String id,*/Model model){
        /*User userCurrent = userService.get(Long.parseLong(id));
        if(userCurrent != null) {*/
            //topos.setUser(userCurrent);
            toposService.save(topos);
        /*}*/
        List<Topos> toposList = toposService.listAll();
        model.addAttribute("listTopos",toposList);

        return "toposCheck";
    }

/* page qui manipule User */

    @RequestMapping("/register")
    public String viewRegisterPage(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "register";
    }


    @RequestMapping(value = "/registerCheck",method = RequestMethod.POST)
    public String viewRegisterCheckPageAndSaveUser(Model model, @ModelAttribute("user") User userCurrent){
        userService.save(userCurrent);
        model.addAttribute("userCurrent",userCurrent);
        List<User> userList = userService.listAll();
        model.addAttribute("listUsers",userList);

        return "registerCheck";
    }

    @RequestMapping("/logIn")
    public String viewCatalogPage(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "logIn";
    }


    @RequestMapping(value = "/logInCheck",method = RequestMethod.POST)
    public String viewLogInCheckPage(HttpServletResponse response,Model model, @ModelAttribute("user") User user){
        User userSearch = userService.findByPseudo(user.getPseudo());
        String message = "";
        if(user.getPassword().equals(userSearch.getPassword())) {
            if (userSearch != null) {
                model.addAttribute("userSearch", userSearch);
                Cookie cookie = new Cookie("id", Long.toString(userSearch.getId()));
                cookie.setMaxAge(24 * 60 * 60);
                response.addCookie(cookie);
                return "logInCheck";
            }
        }
        message = " Connexion échoué ! réessayer !";
        model.addAttribute("message",message);
        return "redirect:/logIn";

    }
    @RequestMapping("/logOut")
    public String logoutAndViewHomepage(HttpServletResponse response){
        Cookie cookie = new Cookie("id", "-1");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }
/* page à gérer BDD */


    @RequestMapping("/catalog")
    public String viewLogInPage(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "catalog";
    }


    @RequestMapping("/climbingSite")
    public String viewClimbingSitePage(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "climbingSite";
    }





}
