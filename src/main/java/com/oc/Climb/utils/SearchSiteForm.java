package com.oc.Climb.utils;

import com.oc.Climb.enums.Level;

public class SearchSiteForm {
    private String place;
    private Boolean official;
    private int nbSectors;
    private Level level;

    public SearchSiteForm() {
        init();
    }

    public void init() {
        this.place = "";
        this.official = false;
        this.nbSectors = -1;
        this.level = Level.NOT_SELECTED;
    }

    public String getPlace() {
        return place;
    }
    public Boolean getOfficial() {
        return official;
    }
    public int getNbSectors() {
        return nbSectors;
    }
    public Level getLevel() {
        return level;
    }
}
