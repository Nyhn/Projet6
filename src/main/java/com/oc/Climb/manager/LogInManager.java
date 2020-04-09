package com.oc.Climb.manager;

import com.oc.Climb.DAO.UserService;
import com.oc.Climb.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class LogInManager {

    @Autowired
    private UserService userService;
    public void checkLog(User user){
        System.out.println(user.getPassword());
//        User userCurrent = userService.findByPseudo(user.getPseudo());
//        if(userCurrent != null)
//            System.out.println("ok");
//        else
//            System.out.println("not ok");
    }
}
