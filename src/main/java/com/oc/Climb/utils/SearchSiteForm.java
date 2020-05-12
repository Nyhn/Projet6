package com.oc.Climb.utils;

import com.oc.Climb.enums.Level;

/**
 * Utils : SearchSiteForm
 * this class permit to record the data of search
 * <p>
 *     SearchSiteForm is characterized by
 *     <ul>
 *         <li>Place is a location of research</li>
 *         <li>Official is boolean of research</li>
 *         <li>nbSectors is a number a sector of research</li>
 *         <li>level is level of research</li>
 *     </ul>
 * </p>
 */
public class SearchSiteForm {
    private String place;
    private Boolean official;
    private int nbSectors;
    /**
     * Enum Level : DEBUTANT,AVANCE, INTERMEDIAIRE,EXPERT,NOT_SELECTED
     */
    private Level level;

    public SearchSiteForm() {
        init();
    }

    /**
     * init data
     */
    public void init() {
        this.place = "";
        this.official = false;
        this.nbSectors = -1;
        this.level = Level.NOT_SELECTED;
    }

    /* ----- GETTER AND SETTER ----- */
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
