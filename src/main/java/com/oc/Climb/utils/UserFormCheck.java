package com.oc.Climb.utils;

import com.oc.Climb.model.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
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
    private boolean mailCheckEmpty;
    private boolean phoneSize;
    private boolean phoneEmpty;
    private boolean pseudoSize;
    private boolean pseudoEmpty;
    private boolean pseudoExisting;
    private boolean passwordSize;
    private boolean passwordEmpty;
    private boolean passwordDifferent;
    private boolean passwordCheckEmpty;

    public UserFormCheck() {
        init();
    }

    public void init(){
        this.nameSize = false;
        this.nameEmpty = false;
        this.firstnameSize = false;
        this.firstnameEmpty = false;
        this.addressSize = false;
        this.addressEmpty = false;
        this.zipSize = false;
        this.zipEmpty = false;
        this.mailSize = false;
        this.mailExisting = false;
        this.mailDifferent = false;
        this.mailEmpty = false;
        this.mailCheckEmpty = false;
        this.phoneSize = false;
        this.phoneEmpty = false;
        this.pseudoSize = false;
        this.pseudoEmpty = false;
        this.pseudoExisting = false;
        this.passwordSize = false;
        this.passwordEmpty = false;
        this.passwordDifferent = false;
        this.passwordCheckEmpty = false;
    }

    public void evaluate(User user, HttpServletRequest request, User userPseudoSearch, User userMailSearch){
        init();
        nameCheck(user.getName());
        firstnameCheck(user.getFirstname());
        addressCheck(user.getAddress());
        zipCheck(Integer.toString(user.getZip()));
        if(userMailSearch != null)
            mailExisting = true;
        else
            mailCheck(user.getMail(), request.getParameter("mail2"));
        phoneCheck(Integer.toString(user.getPhone()));
        if(userPseudoSearch != null)
            pseudoExisting = true;
        else
            pseudoCheck(user.getPseudo());
        passwordCheck(user.getPassword(),request.getParameter("password2"));
    }

    public boolean validate(){
        if(nameSize)
            return false;
        if(nameEmpty)
            return false;
        if(firstnameSize)
            return false;
        if(firstnameEmpty)
            return false;
        if(addressSize)
            return false;
        if(addressEmpty)
            return false;
        if(zipSize)
            return false;
        if(zipEmpty)
            return false;
        if(mailSize)
            return false;
        if(mailEmpty)
            return false;
        if(mailExisting)
            return false;
        if(mailDifferent)
            return false;
        if(mailCheckEmpty)
            return false;
        if(phoneSize)
            return false;
        if(phoneEmpty)
            return false;
        if(pseudoSize)
            return false;
        if(pseudoEmpty)
            return false;
        if(pseudoExisting)
            return false;
        if(passwordSize)
            return false;
        if(passwordEmpty)
            return false;
        if(passwordDifferent)
            return false;
        if(passwordCheckEmpty)
            return false;
        return true;
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
        if(zip.length() != 5 && zip.length() != 4)
            zipSize = true;
    }

    public void mailCheck(String mail, String mailConfirm){
        if(mail.length() == 0)
            mailEmpty = true;
        if(mail.length() <= 3 || mail.length() >= 100)
            mailSize = true;
        if(mailConfirm.length() == 0)
            mailCheckEmpty = true;
        if(!mail.equals(mailConfirm))
            mailDifferent = true;
    }

    public void phoneCheck(String phone){
        if(phone.length() == 0)
            phoneEmpty = true;
        if(phone.length() != 9)
            phoneSize = true;
    }

    public void pseudoCheck(String pseudo){
        if(pseudo.length() == 0)
            pseudoEmpty = true;
        if(pseudo.length() <= 3 || pseudo.length() >= 100)
            pseudoSize = true;
    }

    public void passwordCheck(String password, String passwordConfirm){
        if(password.length() == 0)
            passwordEmpty = true;
        if(password.length() <= 3 || password.length() >= 100)
            passwordSize = true;
        if(passwordConfirm.length() == 0)
            passwordCheckEmpty = true;
        if(!password.equals(passwordConfirm))
            passwordDifferent = true;
    }

    public void describe(){
        System.out.println(
                "        nameSize = " +nameSize+"\n" +
                "        nameEmpty = " +nameEmpty+"\n" +
                "        firstnameSize = " +firstnameSize+"\n" +
                "        firstnameEmpty = " +firstnameEmpty+"\n" +
                "        addressSize = " +addressSize+"\n" +
                "        addressEmpty = " +addressEmpty+"\n" +
                "        zipSize = " +zipSize+"\n" +
                "        zipEmpty = " +zipEmpty+"\n" +
                "        mailSize = " +mailSize+"\n" +
                "        mailExisting = " +mailExisting+"\n" +
                "        mailDifferent = " +mailDifferent+"\n" +
                "        mailEmpty = " +mailEmpty+"\n" +
                "        mailCheckEmpty = " +mailCheckEmpty+"\n" +
                "        phoneSize = " +phoneSize+"\n" +
                "        phoneEmpty = " +phoneEmpty+"\n" +
                "        pseudoSize = " +pseudoSize+"\n" +
                "        pseudoEmpty = " +pseudoEmpty+"\n" +
                "        pseudoExisting = " +pseudoExisting+"\n" +
                "        passwordSize = " +passwordSize+"\n" +
                "        passwordEmpty = " +passwordEmpty+"\n" +
                "        passwordDifferent = " +passwordDifferent+"\n" +
                "        passwordCheckEmpty = " +passwordCheckEmpty);
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
    public boolean isPasswordCheckEmpty() {
        return passwordCheckEmpty;
    }
}
