package com.oc.Climb.utils;

import com.oc.Climb.model.Site;
import org.springframework.stereotype.Service;

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


    public void nameCheck(String name){
        if(name.length() == 0)
            nameEmpty = true;
        if(name.length() <= 3 || name.length() >= 100)
            nameSize = true;
    }

    public void placeCheck(String place){
        if(place.length() == 0)
            placeEmpty = true;
        if(place.length() <= 3 || place.length() >= 100)
            placeSize = true;
    }

    public void orientationCheck(String orientation){
        if(orientation.length() >= 45)
            orientationSize = true;
    }

    public void rockCheck(String rock){
        if(rock.length() >= 45)
            rockSize = true;
    }

    public void imageCheck(String image){
        if(image.length() >= 5000)
            imageSize = true;
    }

    public void presentationCheck(String presentation){
        if(presentation.length() >= 3000)
            presentationSize = true;
    }

    public void sectorCheck(int sector){
        System.out.println(sector);
        if(sector<=0)
            sectorNegative = true;
    }

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
