package com.oc.Climb.utils;

import com.oc.Climb.model.Site;
import org.springframework.stereotype.Service;

/**
 * SiteFormCheck is a data verification class
 * retrieve from the add site form
 * <ul>
 *     <li>nameSize is a boolean which shows if the name size is invalid</li>
 *     <li>nameEmpty is a boolean which shows if the name field is empty</li>
 *     <li>placeSize is a boolean which shows if the place size is invalid</li>
 *     <li>placeEmpty is a boolean which shows if the place field is empty</li>
 *     <li>orientationSize is a boolean which shows if the orientation size is invalid</li>
 *     <li>rockSize is a boolean which shows if the rock size is invalid</li>
 *     <li>imageSize is a boolean which shows if the image size is invalid</li>
 *     <li>presentationSize is a boolean which shows if the presentation size is invalid</li>
 *     <li>sectorNegative is a boolean which shows if the number of sector is negative</li>
 * </ul>
 */
@Service
public class SiteFormCheck {
    private boolean nameSize;
    private boolean nameEmpty;
    private boolean placeSize;
    private boolean placeEmpty;
    private boolean orientationSize;
    private boolean rockSize;
    private boolean imageSize;
    private boolean presentationSize;
    private boolean sectorNegative;

    public SiteFormCheck() {
    }

    /**
     * This function initialize attributes
     * And evaluate all site attributes
     * @param site site is a site to evaluate
     */
    public void evaluate(Site site){
        init();
        nameCheck(site.getName());
        placeCheck(site.getPlace());
        orientationCheck(site.getOrientation());
        rockCheck(site.getRocktype());
        imageCheck(site.getPicture());
        presentationCheck(site.getPresentation());
        sectorCheck(site.getSector());
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
        if(placeEmpty)
            return false;
        if(placeSize)
            return false;
        if(orientationSize)
            return false;
        if(imageSize)
            return false;
        if(presentationSize)
            return false;
        if(rockSize)
            return false;
        if(sectorNegative)
            return false;
        return true;
    }

    /**
     * Function which print all attributes of SiteFormCheck
     * Use for debug
     */
    public void describe(){
        System.out.println(
                "        nameSize = "+ nameSize+"\n" +
                "        nameEmpty = "+ nameEmpty+"\n" +
                "        placeSize = "+ placeSize+"\n" +
                "        placeEmpty = "+ placeEmpty+"\n" +
                "        orientationSize = "+ orientationSize+"\n" +
                "        rockSize = "+ rockSize +"\n" +
                "        imageSize = "+ imageSize+"\n" +
                "        presentationSize = "+ presentationSize+"\n" +
                "        sectorNegative = "+ sectorNegative);
    }


    /**
     * Check the string name
     * If is not null and between 3 and 100 characters
     * @param name is a name of site
     */
    public void nameCheck(String name){
        if(name.length() == 0)
            nameEmpty = true;
        if(name.length() <= 3 || name.length() >= 100)
            nameSize = true;
    }

    /**
     * Check the string place
     * If is not null and between 3 and 100 characters
     * @param place is a place of site
     */
    public void placeCheck(String place){
        if(place.length() == 0)
            placeEmpty = true;
        if(place.length() <= 3 || place.length() >= 100)
            placeSize = true;
    }

    /**
     * Check the string orientation
     * If is less than 45 characters
     * @param orientation is a orientation of site
     */
    public void orientationCheck(String orientation){
        if(orientation.length() >= 45)
            orientationSize = true;
    }

    /**
     * Check the string rock
     * If is less than 45 characters
     * @param rock is a rockType of site
     */
    public void rockCheck(String rock){
        if(rock.length() >= 45)
            rockSize = true;
    }

    /**
     * Check the string image
     * If is not null and less than 5000 characters
     * @param image is a link of site picture
     */
    public void imageCheck(String image){
        if(image.length() >= 5000)
            imageSize = true;
    }

    /**
     * Check the string presentation
     * If is less than 3000 characters
     * @param presentation is a presentation of site
     */
    public void presentationCheck(String presentation){
        if(presentation.length() >= 3000)
            presentationSize = true;
    }

    /**
     * Check the number of sector
     * If is more than 0
     * @param sector is the number of sector in site
     */
    public void sectorCheck(int sector){
        System.out.println(sector);
        if(sector<=0)
            sectorNegative = true;
    }

    /**
     * init put all the fields to false ( no error detected )
     */
    public void init(){
        nameSize = false;
        nameEmpty = false;
        placeSize = false;
        placeEmpty = false;
        orientationSize = false;
        rockSize = false;
        imageSize = false;
        presentationSize = false;
        sectorNegative = false;
    }

    /*  GETTERS AND SETTERS */
    public boolean isNameSize() {
        return nameSize;
    }
    public boolean isNameEmpty() {
        return nameEmpty;
    }
    public boolean isPlaceSize() {
        return placeSize;
    }
    public boolean isPlaceEmpty() {
        return placeEmpty;
    }
    public boolean isOrientationSize() {
        return orientationSize;
    }
    public boolean isImageSize() {
        return imageSize;
    }
    public boolean isPresentationSize() {
        return presentationSize;
    }
    public boolean isRockSize() {
        return rockSize;
    }
    public boolean isSectorNegative() {
        return sectorNegative;
    }
}
