package com.example.pakkat;

public class ModelHome {

    private String Title;
    private String Loc;
    private String Date;
    private String price;
    private String img1;
    private String img2;
    private String img3;
    private String img4;
    private String Category;
    private String description;
    private String phone;
    private String link;

    //Constructor null
    public ModelHome() {

    }

    //Constructor
    public ModelHome(String title, String loc, String date, String price, String img1, String img2, String img3, String img4, String category, String description, String phone, String link) {
        this.Title = title;
        this.Loc = loc;
        this.Date = date;
        this.price = price;
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
        this.img4 = img4;
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

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
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

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public String getImg4() {
        return img4;
    }

    public void setImg4(String img4) {
        this.img4 = img4;
    }
}
