package com.oc.Climb.utils;

import com.oc.Climb.model.User;

import javax.servlet.http.HttpServletRequest;
import java.security.PublicKey;

public class UserFormCheck {
    private boolean nameSize;
    private boolean nameEmpty;
    private boolean firstnameSize;
    private boolean firstnameEmpty;
    private boolean addressSize;
    private boolean addressEmpty;
    private boolean zipSize;
    private boolean zipEmpty;
    private boolean mailSize;
    private boolean mailExisting;
    private boolean mailDifferent;
    private boolean mailEmpty;
    private boolean mailCheckSize;
    private boolean mailCheckEmpty;
    private boolean phoneSize;
    private boolean phoneEmpty;
    private boolean pseudoSize;
    private boolean pseudoEmpty;
    private boolean pseudoExisting;
    private boolean passwordSize;
    private boolean passwordEmpty;
    private boolean passwordDifferent;
    private boolean passwordCheckSize;
    private boolean passwordCheckEmpty;

    public void evaluate(User user, HttpServletRequest request){

    }
    public void nameCheck(String name){
        if(name.length() == 0)
            nameEmpty = true;
        if(name.length() <= 3 || name.length() >= 100)
            nameSize = true;
    }

    public void firstnameCheck(String firstname){
        if(firstname.length() == 0)
            firstnameEmpty = true;
        if(firstname.length() <= 3 || firstname.length() >= 100)
            firstnameSize = true;
    }

    public void addressCheck(String address){
        if(address.length() == 0)
            addressEmpty = true;
        if(address.length() <= 3 || address.length() >= 500)
            addressSize = true;
    }

    public void zipCheck(String zip){
        if(zip.length() == 0)
            zipEmpty = true;
        if(zip.length() != 5)
            zipSize = true;
    }

    public boolean isNameSize() {
        return nameSize;
    }
    public boolean isNameEmpty() {
        return nameEmpty;
    }
    public boolean isFirstnameSize() {
        return firstnameSize;
    }
    public boolean isFirstnameEmpty() {
        return firstnameEmpty;
    }
    public boolean isAddressSize() {
        return addressSize;
    }
    public boolean isAddressEmpty() {
        return addressEmpty;
    }
    public boolean isZipSize() {
        return zipSize;
    }
    public boolean isZipEmpty() {
        return zipEmpty;
    }
    public boolean isMailSize() {
        return mailSize;
    }
    public boolean isMailExisting() {
        return mailExisting;
    }
    public boolean isMailDifferent() {
        return mailDifferent;
    }
    public boolean isMailEmpty() {
        return mailEmpty;
    }
    public boolean isMailCheckSize() {
        return mailCheckSize;
    }
    public boolean isMailCheckEmpty() {
        return mailCheckEmpty;
    }
    public boolean isPhoneSize() {
        return phoneSize;
    }
    public boolean isPhoneEmpty() {
        return phoneEmpty;
    }
    public boolean isPseudoSize() {
        return pseudoSize;
    }
    public boolean isPseudoEmpty() {
        return pseudoEmpty;
    }
    public boolean isPseudoExisting() {
        return pseudoExisting;
    }
    public boolean isPasswordSize() {
        return passwordSize;
    }
    public boolean isPasswordEmpty() {
        return passwordEmpty;
    }
    public boolean isPasswordDifferent() {
        return passwordDifferent;
    }
    public boolean isPasswordCheckSize() {
        return passwordCheckSize;
    }
    public boolean isPasswordCheckEmpty() {
        return passwordCheckEmpty;
    }
}
