package com.oc.Climb.utils;

import com.oc.Climb.model.User;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * This class is used to encrypt a string using user data
 */
@Service
public class EncryptPassword {
    /**
     * Encrypt a password by concatenating the password
     * with the nickname with additional characters
     * @param user user is the user to encrypt
     * @return passwordEncrypted
     */
    public String encrypt(User user){
        String hash = user.getPassword()+"6a[iY7d%5G"+user.getPseudo()+"3~4Dk/";
        byte[] hashToByte = hash.getBytes();
        String passwordEncrypted = DigestUtils.md5DigestAsHex(hashToByte);
        return passwordEncrypted;
    }
}
