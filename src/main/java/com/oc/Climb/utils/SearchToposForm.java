package com.oc.Climb.utils;

public class SearchToposForm {
    private String titleOrAutor;

    public SearchToposForm() {
        init();
    }

    public void init() {
        this.titleOrAutor = "";
    }
    public String getTitleOrAutor() {
        return titleOrAutor;
    }
}
