package com.example.engahmed.mitchamr.Souvenir;

/**
 * Created by Eng Ahmed on 03/06/2017.
 */

public class model_souvenir {

    private String name_sou;
    private String phone;
    private String  logo;
    private String place_sou;
    private String imaage_sou;
    private String urlfacebook;
    private String urllocation;
    public model_souvenir() {

    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName_sou(String name_sou) {
        this.name_sou = name_sou;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getLogo() {
        return logo;
    }

    public String getName_sou() {
        return name_sou;
    }

    public String getPhone() {
        return phone;
    }

    public String getImaage_sou() {
        return imaage_sou;
    }

    public String getPlace_sou() {
        return place_sou;
    }

    public void setImaage_sou(String imaage_sou) {
        this.imaage_sou = imaage_sou;
    }

    public void setPlace_sou(String place_sou) {
        this.place_sou = place_sou;
    }

    public String getUrlfacebook() {
        return urlfacebook;
    }

    public void setUrlfacebook(String urlfacebook) {
        this.urlfacebook = urlfacebook;
    }

    public String getUrllocation() {
        return urllocation;
    }

    public void setUrllocation(String urllocation) {
        this.urllocation = urllocation;
    }
}