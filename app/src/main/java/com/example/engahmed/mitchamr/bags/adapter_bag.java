package com.example.engahmed.mitchamr.bags;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.engahmed.mitchamr.R;
import com.example.engahmed.mitchamr.Souvenir.souvenir_dety;

import java.util.ArrayList;

/**
 * Created by Eng Ahmed on 30/05/2017.
 */

public class adapter_bag extends RecyclerView.Adapter<holder_bag> {

    Context c;
    ArrayList<bag_model> bag_models;


    public adapter_bag(Context c,ArrayList<bag_model> bag_models){

        this.c=c;
        this.bag_models=bag_models;

    }

    @Override
    public holder_bag onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(c).inflate(R.layout.model_bag,parent,false);



        return new holder_bag(v);
    }

    @Override
    public void onBindViewHolder(holder_bag holder, int position) {

        final bag_model b=bag_models.get(position);

        holder.name_bag.setText(bag_models.get(position).getName_());
        image_bag.downloadImage(c,bag_models.get(position).getImage(),holder.image_bag);
        holder.setItemClickLisner_bag(new ItemClickLisner_bag() {
            @Override
            public void onItemClick(int pos) {
                opendetalis_bag(b.getName_(),b.getImage(),b.getPhone(),b.getImg_place(),b.getLocation_bag(),b.getPlace_bag(),b.getFacebook_bag());
            }
        });

    }

    @Override
    public int getItemCount() {
        return bag_models.size();
    }





    private void  opendetalis_bag(String...detalis){
        Intent i=new Intent(c,bags_detyalis.class);
        i.putExtra("name_",detalis[0]);
        i.putExtra("image",detalis[1]);
        i.putExtra("phone",detalis[2]);
        i.putExtra("img_place",detalis[3]);
        i.putExtra("location_bag",detalis[4]);
        i.putExtra("place_bag",detalis[5]);
        i.putExtra("facebook_bag",detalis[6]);
        c.startActivity(i);
    }





















}
