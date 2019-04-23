package com.example.engahmed.mitchamr.clothes.woman;

/**
 * Created by Eng Ahmed on 02/06/2017.
 */

public class woman_model {

    private String namew;
    private String imagew;
    private String phonew;


    public woman_model(){

    }


    public woman_model(String namew,String imagew,String phonew){
        this.namew=namew;
        this.imagew=imagew;
        this.phonew=phonew;
    }


    public String getNamew() {
        return namew;
    }

    public String getImagew() {
        return imagew;
    }

    public String getPhonew() {
        return phonew;
    }

    public void setNamew(String namew) {
        this.namew = namew;
    }

    public void setImagew(String imagew) {
        this.imagew = imagew;
    }

    public void setPhonew(String phonew) {
        this.phonew = phonew;
    }
}
