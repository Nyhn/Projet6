package com.oc.Climb.utils;

import com.oc.Climb.model.Topos;

import java.sql.Date;

public class ToposFormCheck {
    private boolean titleSize;
    private boolean titleEmpty;
    private boolean autorSize;
    private boolean autorEmpty;
    private boolean imageSize;
    private boolean descriptionSize;

    public ToposFormCheck() {
        this.titleSize = false;
        this.titleEmpty = false;
        this.autorSize = false;
        this.autorEmpty = false;
        this.imageSize = false;
        this.descriptionSize = false;
    }

    public void describe(){
        System.out.println(
                "        this.titleSize = "+ titleSize+ "\n" +
                "        this.titleEmpty = "+ titleEmpty+ "\n" +
                "        this.autorSize = "+ autorSize+ "\n" +
                "        this.autorEmpty = "+ autorEmpty+ "\n" +
                "        this.imageSize = "+ imageSize+ "\n" +
                "        this.descriptionSize = "+ descriptionSize);
    }

    public Topos evaluate(Topos topos){
        titleCheck(topos.getTitle());
        autorCheck(topos.getAutor());
        imageCheck(topos.getImage());
        descriptionCheck(topos.getDescription());
        return topos;
    }

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

    public void titleCheck(String title){
        if(title.length() == 0)
            titleEmpty = true;
        if(title.length() <= 3 || title.length() >= 500)
            titleSize = true;
    }

    public void autorCheck(String autor){
        if(autor.length() == 0)
            autorEmpty = true;
        if(autor.length() <= 3 || autor.length() >= 100)
            autorSize = true;
    }

    public void imageCheck(String image){
        if(image.length() >= 5000)
            imageSize = true;
    }

    public void descriptionCheck(String description){
        if(description.length() >= 5000)
            descriptionSize = true;
    }

    public Date dateCheck(Date date){
        java.util.Date dateRef = java.sql.Date.valueOf("0001-01-01");
        if(date.compareTo(dateRef) == 0){
            System.out.println("no date data ");
            return null;
        }
        return date;
    }

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
