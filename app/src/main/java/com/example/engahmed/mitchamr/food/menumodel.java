package com.example.engahmed.mitchamr.food;

/**
 * Created by Eng Ahmed on 16/03/2017.
 */

     public class menumodel {

    private String name;
    private String url;
    private String phone;
    private String menue;
    private String urlLocation_res;
    private String place;

    public menumodel()
    {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone=phone;
    }

    public String getMenue() {
        return menue;
    }

    public void setMenue(String menue) {
        this.menue = menue;
    }



    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getUrlLocation_res() {
        return urlLocation_res;
    }

    public void setUrlLocation_res(String urlLocation_res) {
        this.urlLocation_res = urlLocation_res;
    }
}
