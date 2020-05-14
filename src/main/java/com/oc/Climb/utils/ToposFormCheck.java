package com.oc.Climb.utils;

import com.oc.Climb.model.Topos;
import org.springframework.stereotype.Service;

import java.sql.Date;

/**
 * ToposFormCheck is a data verification class
 * retrieve from the add topos form
 * <ul>
 *     <li>titleSize is a boolean which shows if the title size is invalid</li>
 *     <li>titleEmpty is a boolean which shows if the title field is empty</li>
 *     <li>autorSize is a boolean which shows if the autor size is invalid</li>
 *     <li>autorEmpty is a boolean which shows if the autor field is empty</li>
 *     <li>imageSize is a boolean which shows if the image size is invalid</li>
 *     <li>descriptionSize is a boolean which shows if the description size is invalid</li>
 * </ul>
 */
@Service
public class ToposFormCheck {
    private boolean titleSize;
    private boolean titleEmpty;
    private boolean autorSize;
    private boolean autorEmpty;
    private boolean imageSize;
    private boolean descriptionSize;

    public ToposFormCheck() {
        init();
    }

    /**
     * init put all the fields to false ( no error detected )
     */
    public void init(){
        this.titleSize = false;
        this.titleEmpty = false;
        this.autorSize = false;
        this.autorEmpty = false;
        this.imageSize = false;
        this.descriptionSize = false;
    }

    /**
     * Function which print all attributes of ToposFormCheck
     * Use for debug
     */
    public void describe(){
        System.out.println(
                "        this.titleSize = "+ titleSize+ "\n" +
                "        this.titleEmpty = "+ titleEmpty+ "\n" +
                "        this.autorSize = "+ autorSize+ "\n" +
                "        this.autorEmpty = "+ autorEmpty+ "\n" +
                "        this.imageSize = "+ imageSize+ "\n" +
                "        this.descriptionSize = "+ descriptionSize);
    }

    /**
     * This function initialize attributes
     * And evaluate all topos attributes
     * @param topos topos is a topos to evaluate
     */
    public Topos evaluate(Topos topos){
        init();
        titleCheck(topos.getTitle());
        autorCheck(topos.getAutor());
        imageCheck(topos.getImage());
        descriptionCheck(topos.getDescription());
        return topos;
    }

    /**
     * Validate return false if one of boolean is true else return true
     * @return Boolean of acceptance
     */
    public boolean validate(){
        if(titleSize)
            return false;
        if(titleEmpty)
            return false;
        if(autorSize)
            return false;
        if(autorEmpty)
            return false;
        if(imageSize)
            return false;
        if(descriptionSize)
            return false;
        return true;
    }

    /**
     * Check the string title
     * If is not null and between 3 and 500 characters
     * @param title is a title of topos
     */
    public void titleCheck(String title){
        if(title.length() == 0)
            titleEmpty = true;
        if(title.length() <= 3 || title.length() >= 500)
            titleSize = true;
    }

    /**
     * Check the string autor
     * If is not null and between 3 and 100 characters
     * @param autor is a autor of topos
     */
    public void autorCheck(String autor){
        if(autor.length() == 0)
            autorEmpty = true;
        if(autor.length() <= 3 || autor.length() >= 100)
            autorSize = true;
    }

    /**
     * Check the string image
     * If is less than 5000 characters
     * @param image is a link of picture topos
     */
    public void imageCheck(String image){
        if(image.length() >= 5000)
            imageSize = true;
    }

    /**
     * Check the string description
     * If is less than 5000 characters
     * @param description is a description of topos
     */
    public void descriptionCheck(String description){
        if(description.length() >= 5000)
            descriptionSize = true;
    }

    /**
     * Check the date
     * If date = 0001-01-01 then no date add and return null
     * @param date date of topos
     * @return null if no data add or the initial date
     */
    public Date dateCheck(Date date){
        java.util.Date dateRef = java.sql.Date.valueOf("0001-01-01");
        if(date.compareTo(dateRef) == 0){
            System.out.println("no date data ");
            return null;
        }
        return date;
    }

    /* GETTERS AND SETTERS */
    public boolean isTitleSize() {
        return titleSize;
    }
    public boolean isTitleEmpty() {
        return titleEmpty;
    }
    public boolean isAutorSize() {
        return autorSize;
    }
    public boolean isAutorEmpty() {
        return autorEmpty;
    }
    public boolean isImageSize() {
        return imageSize;
    }
    public boolean isDescriptionSize() {
        return descriptionSize;
    }
}
