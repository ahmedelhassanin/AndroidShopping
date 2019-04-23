package com.example.engahmed.mitchamr.clothes.man;

/**
 * Created by Eng Ahmed on 31/05/2017.
 */

public class model_man {

    private String market_namem;
    private String market_phonem;
    private String market_logom;


    public model_man(){

    }


    public model_man(String market_namem,String market_phonem,String market_logom){
        this.market_namem=market_namem;
        this.market_phonem=market_phonem;
        this.market_logom=market_logom;
    }


    public String getMarket_namem() {
        return market_namem;
    }

    public void setMarket_namem(String market_namem) {
        this.market_namem = market_namem;
    }

    public String getMarket_phonem() {
        return market_phonem;
    }

    public void setMarket_phonem(String market_phonem) {
        this.market_phonem = market_phonem;
    }

    public String getMarket_logom() {
        return market_logom;
    }

    public void setMarket_logom(String market_logom) {
        this.market_logom = market_logom;
    }
}
