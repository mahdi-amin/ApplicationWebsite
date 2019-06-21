package com.example.pakkat;

public class ModelHome {

    private String Title;
    private String Loc;
    private String Date;
    private String price;
    private String Pic;

    //Constructor null
    public ModelHome() {

    }

    //Constructor
    public ModelHome(String title, String loc, String date, String price, String pic) {
        Title = title;
        Loc = loc;
        Date = date;
        this.price = price;
        Pic = pic;
    }

    //getter and setter

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getLoc() {
        return Loc;
    }

    public void setLoc(String loc) {
        Loc = loc;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPic() {
        return Pic;
    }

    public void setPic(String pic) {
        Pic = pic;
    }
}
