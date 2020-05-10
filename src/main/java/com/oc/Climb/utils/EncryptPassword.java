package com.oc.Climb.utils;

import com.oc.Climb.model.User;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class EncryptPassword {
    public String encrypt(User user){
        String hash = user.getPassword()+"6a[iY7d%5G"+user.getPseudo()+"3~4Dk/";
        byte[] hashToByte = hash.getBytes();
        String passwordEncrypted = DigestUtils.md5DigestAsHex(hashToByte);
        return passwordEncrypted;
    }
}
