package com.oc.Climb.utils;

import com.oc.Climb.enums.Level;

public class SearchSiteForm {
    private String place;
    private Boolean official;
    private int nbSectors;
    private Level level;

    public void init() {
        this.place = "";
        this.official = false;
        this.nbSectors = -1;
        this.level = Level.NOT_SELECTED;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Boolean getOfficial() {
        return official;
    }

    public void setOfficial(Boolean official) {
        this.official = official;
    }

    public int getNbSectors() {
        return nbSectors;
    }

    public void setNbSectors(int nbSectors) {
        this.nbSectors = nbSectors;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
