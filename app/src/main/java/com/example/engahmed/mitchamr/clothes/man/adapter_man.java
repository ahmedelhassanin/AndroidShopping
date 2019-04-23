package com.example.engahmed.mitchamr.clothes.man;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.engahmed.mitchamr.R;

import java.util.ArrayList;

/**
 * Created by Eng Ahmed on 31/05/2017.
 */

public class adapter_man extends RecyclerView.Adapter<holder_man> {

    Context c;
    ArrayList<model_man> model_mens;


    public adapter_man(Context c,ArrayList<model_man> model_men){
        this.c=c;
        this.model_mens=model_men;
    }


    @Override
    public holder_man onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(c).inflate(R.layout.model_man,parent,false);


        return new holder_man(v);
    }

    @Override
    public void onBindViewHolder(holder_man holder, int position) {

        holder.market_name.setText(model_mens.get(position).getMarket_namem());
        picassclient.downloadImage(c,model_mens.get(position).getMarket_logom(),holder.imagelogo);

    }

    @Override
    public int getItemCount() {
        return model_mens.size();
    }



}
