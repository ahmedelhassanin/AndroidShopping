package com.example.engahmed.mitchamr.food.desert;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.engahmed.mitchamr.R;
import com.example.engahmed.mitchamr.food.menumodel;
import com.example.engahmed.mitchamr.food.resturant_dety;

import java.util.ArrayList;

/**
 * Created by Eng Ahmed on 16/03/2017.
 */

public class adaptersweets extends RecyclerView.Adapter<holdersweets> {


    Context c;
    ArrayList<desert_model> sweetss;


    public adaptersweets(Context c, ArrayList<desert_model> sweetss){
        this.c=c;
        this.sweetss=sweetss;


    }

    @Override
    public holdersweets onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(c).inflate(R.layout.model_sweet,parent,false);

        return new holdersweets(v);
    }

    @Override
    public void onBindViewHolder(holdersweets holder, int position) {


        final desert_model d=sweetss.get(position);

        holder.namesweets.setText(sweetss.get(position).getName_sweet());
        picassdesert.downloadImage(c,sweetss.get(position).getUrl_sweet(),holder.imgsweets);
        holder.setItemclicksweet(new itemclicksweet() {
            @Override
            public void onItemClick(int pos) {
                opendetalis_des(d.getName_sweet(),d.getUrl_sweet(),d.getPhone_sweet(),d.getPlace_sweet(),d.getMenue_sweet(),d.getLocation_sweet());
            }
        });


    }

    @Override
    public int getItemCount() {
        return sweetss.size();
    }






    private void  opendetalis_des(String ...detalis) {

        Intent i = new Intent(c, desert_det.class);
        i.putExtra("name_sweet", detalis[0]);
        i.putExtra("url_sweet", detalis[1]);
        i.putExtra("phone_sweet", detalis[2]);
        i.putExtra("place_sweet",detalis[3]);
        i.putExtra("menue_sweet",detalis[4]);
        i.putExtra("location_sweet",detalis[5]);


        c.startActivity(i);

    }














}
