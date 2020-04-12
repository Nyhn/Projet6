package com.oc.Climb.manager;

import com.oc.Climb.enums.Role;
import com.oc.Climb.model.User;

public class LogInManager {

    public Role checkLog(User user){

        if(user == null)
            return Role.NOT_CONNECTED;
        else if(user.getRole().equals(Role.USER))
            return Role.USER;
        else if(user.getRole().equals(Role.MEMBER))
            return Role.MEMBER;
        else if(user.getRole().equals(Role.ADMINISTRATOR))
            return Role.ADMINISTRATOR;
        else
            return Role.NOT_CONNECTED;
    }
}
