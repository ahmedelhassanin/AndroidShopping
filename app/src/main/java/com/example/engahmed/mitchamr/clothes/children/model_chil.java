package com.example.engahmed.mitchamr.clothes.children;

/**
 * Created by Eng Ahmed on 02/06/2017.
 */

public class model_chil {

    private String market_namech;
    private String market_phonech;
    private String market_logoch;


    public model_chil() {

    }


    public model_chil(String market_namech, String market_phonech, String market_logoch) {
        this.market_namech = market_namech;
        this.market_phonech = market_phonech;
        this.market_logoch = market_logoch;
    }

    public void setMarket_namech(String market_namech) {
        this.market_namech = market_namech;
    }

    public String getMarket_namech() {
        return market_namech;
    }

    public String getMarket_phonech() {
        return market_phonech;
    }

    public void setMarket_phonech(String market_phonech) {
        this.market_phonech = market_phonech;
    }

    public void setMarket_logoch(String market_logoch) {
        this.market_logoch = market_logoch;
    }

    public String getMarket_logoch() {
        return market_logoch;
    }


}



