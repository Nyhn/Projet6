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
    public void init() {
        this.titleOrAutor = "";
    }
    /* ----- GETTER AND SETTER ----- */

    public String getTitleOrAutor() {
        return titleOrAutor;
    }
    public void setTitleOrAutor(String titleOrAutor) {
        this.titleOrAutor = titleOrAutor;
    }
}
