package com.example.pakkat;

public class ModelHome {

    private String Title;
    private String Loc;
    private String Date;
    private String price;
    private String[] img;
    private String Category;
    private String description;
    private String phone;
    private String link;

    //Constructor null
    public ModelHome() {

    }

    //Constructor
    public ModelHome(String title, String loc, String date, String price, String[] img, String category, String description, String phone, String link) {
        this.Title = title;
        this.Loc = loc;
        this.Date = date;
        this.price = price;
        this.img = img;
        this.Category = category;
        this.description = description;
        this.phone = phone;
        this.link = link;
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

    public String[] getImg() {
        return img;
    }

    public void setImg(String[] img) {
        this.img = img;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public void setDescription(String description) {
        description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
