package com.oc.Climb.utils;

import com.oc.Climb.model.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * UserFormCheck is a data verification class
 * retrieve from the add User form
 * <ul>
 *     <li>nameSize is a boolean which shows if the name size is invalid</li>
 *     <li>nameEmpty is a boolean which shows if the name field is empty</li>
 *     <li>firstnameSize is a boolean which shows if the firstname size is invalid</li>
 *     <li>firstnameEmpty is a boolean which shows if the firstname field is empty</li>
 *     <li>addressSize is a boolean which shows if the address size is invalid</li>
 *     <li>addressEmpty is a boolean which shows if the address field is empty</li>
 *     <li>zipSize is a boolean which shows if the zip size is invalid</li>
 *     <li>zipEmpty is a boolean which shows if the zip field is empty</li>
 *     <li>mailSize is a boolean which shows if the mail size is invalid</li>
 *     <li>mailEmpty is a boolean which shows if the mail field is empty</li>
 *     <li>mailExisting is a boolean which shows if the mail existing in Database</li>
 *     <li>mailDifferent is a boolean which shows if the 2 field of mail is different</li>
 *     <li>mailCheckEmpty is a boolean which shows if the mailCheck field is empty</li>
 *     <li>phoneSize is a boolean which shows if the phone size is invalid</li>
 *     <li>phoneEmpty is a boolean which shows if the phone field is empty</li>
 *     <li>pseudoSize is a boolean which shows if the pseudo size is invalid</li>
 *     <li>pseudoEmpty is a boolean which shows if the pseudo field is empty</li>
 *     <li>pseudoExisting is a boolean which shows if the pseudo existing in Database</li>
 *     <li>passwordSize is a boolean which shows if the password size is invalid</li>
 *     <li>passwordEmpty is a boolean which shows if the password field is empty</li>
 *     <li>passwordDifferent is a boolean which shows if the 2 field of password is different</li>
 *     <li>passwordCheckEmpty is a boolean which shows if the passwordCheck field is empty</li>
 * </ul>
 */
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

    /**
     * init put all the fields to false ( no error detected )
     */
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

    /**
     * This function initialize attributes
     * And evaluate all user attributes
     * @param user  is a user to evaluate
     * @param request request of form to collect mailCheck and passwordCheck
     * @param userMailSearch is a User research in database by mail
     * @param userPseudoSearch is a User research in database by pseudo
     */
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

    /**
     * Validate return false if one of boolean is true else return true
     * @return Boolean of acceptance
     */
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
    /**
     * Check the string name
     * If is not null and between 3 and 100 characters
     * @param name is a name of user
     */
    public void nameCheck(String name){
        if(name.length() == 0)
            nameEmpty = true;
        if(name.length() <= 3 || name.length() >= 100)
            nameSize = true;
    }

    /**
     * Check the string firstname
     * If is not null and between 3 and 100 characters
     * @param firstname is a firstname of user
     */
    public void firstnameCheck(String firstname){
        if(firstname.length() == 0)
            firstnameEmpty = true;
        if(firstname.length() <= 3 || firstname.length() >= 100)
            firstnameSize = true;
    }

    /**
     * Check the string address
     * If is not null and between 3 and 500 characters
     * @param address is a address of user
     */
    public void addressCheck(String address){
        if(address.length() == 0)
            addressEmpty = true;
        if(address.length() <= 3 || address.length() >= 500)
            addressSize = true;
    }

    /**
     * Check the string zip
     * If is not null and between 4 and 5 characters
     * @param zip is a zip of user
     */
    public void zipCheck(String zip){
        if(zip.length() == 0)
            zipEmpty = true;
        if(zip.length() != 5 && zip.length() != 4)
            zipSize = true;
    }

    /**
     * Check the string mail and compare with mailconfirm
     * If is not null and between 3 and 100 characters
     * @param mail is a mail of user
     * @param mailConfirm is a mailcheck by request
     */
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

    /**
     * Check the string phone
     * If is not null and different of 9 characters
     * @param phone is a phone of user
     */
    public void phoneCheck(String phone){
        if(phone.length() == 0)
            phoneEmpty = true;
        if(phone.length() != 9)
            phoneSize = true;
    }

    /**
     * Check the string pseudo
     * If is not null and between 3 and 100 characters
     * @param pseudo is a pseudo of user
     */
    public void pseudoCheck(String pseudo){
        if(pseudo.length() == 0)
            pseudoEmpty = true;
        if(pseudo.length() <= 3 || pseudo.length() >= 100)
            pseudoSize = true;
    }

    /**
     * Check the string password and compare with passwordconfirm
     * If is not null and between 3 and 100 characters
     * @param password is a password of user
     * @param passwordConfirm is a passwordcheck by request
     */
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

    /**
     * Function which print all attributes of userFormCheck
     * Use for debug
     */
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

    /* GETTERS AND SETTERS */
    
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

    public void evaluateModif(User user) {
        init();
        nameCheck(user.getName());
        firstnameCheck(user.getFirstname());
        addressCheck(user.getAddress());
        zipCheck(Integer.toString(user.getZip()));
        phoneCheck(Integer.toString(user.getPhone()));
    }
}
