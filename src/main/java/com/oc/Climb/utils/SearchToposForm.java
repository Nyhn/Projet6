package com.oc.Climb.utils;

/**
 * Utils : SearchToposForm
 * this class permit to record the data of search
 * <p>
 *     SearchToposForm is characterized by
 *     <ul>
 *         <li>titleOrAutor is a string of research</li>
 *     </ul>
 * </p>
 */
public class SearchToposForm {
    private String titleOrAutor;

    public SearchToposForm() {
        init();
    }

    /* ----- GETTER AND SETTER ----- */
    public void init() {
        this.titleOrAutor = "";
    }
    public String getTitleOrAutor() {
        return titleOrAutor;
    }
}
