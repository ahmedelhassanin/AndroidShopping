package com.example.engahmed.mitchamr.bags;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Eng Ahmed on 30/05/2017.
 */



@IgnoreExtraProperties

public class bag_model {

    private String name_;
    private String image;
    private String  phone;
    private String  img_place;
    private String location_bag;
    private String  place_bag;
    private String  facebook_bag;
    public bag_model(){

    }

    public String getName_(){
        return name_;
    }

    public void setName_(String name_){
        this.name_=name_;
    }

    public String getImage(){
        return image;
    }

    public void setImage(String image){
        this.image=image;

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getFacebook_bag() {
        return facebook_bag;
    }

    public String getImg_place() {
        return img_place;
    }

    public String getLocation_bag() {
        return location_bag;
    }

    public String getPlace_bag() {
        return place_bag;
    }


    public void setFacebook_bag(String facebook_bag) {
        this.facebook_bag = facebook_bag;
    }

    public void setImg_place(String img_place) {
        this.img_place = img_place;
    }

    public void setLocation_bag(String location_bag) {
        this.location_bag = location_bag;
    }

    public void setPlace_bag(String place_bag) {
        this.place_bag = place_bag;
    }
}
