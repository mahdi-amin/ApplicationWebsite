package com.example.pakkat;

public class ModelCategory {

    private String Title;

    //Constructor null
    public ModelCategory() {

    }

    //Constructor
    public ModelCategory(String title) {
        Title = title;
    }

    //getter and setter
    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

}