package com.example.engahmed.mitchamr.food.cafes;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.engahmed.mitchamr.R;
import com.example.engahmed.mitchamr.food.resturant_dety;


import java.util.ArrayList;

/**
 * Created by Eng Ahmed on 19/05/2017.
 */

public class adaptercafe extends RecyclerView.Adapter<holdercafe> {

    Context c;
    ArrayList<cafe_model> cafes;


    public adaptercafe(Context c, ArrayList<cafe_model> cafes){
        this.c=c;
        this.cafes=cafes;



    }

    @Override
    public holdercafe onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(R.layout.model_cafe,parent,false);

      return new holdercafe(v);
    }

    @Override
    public void onBindViewHolder(holdercafe holder, int position) {

    final cafe_model cc=cafes.get(position);

       holder.textView.setText(cafes.get(position).getName_cafe());
        picasscafe.downloadImage(c,cafes.get(position).getUrl_cafe(),holder.imageView);


        holder.setItemclickcafe(new itemclickcafe() {
            @Override
            public void onItemClick(int poss) {
                opendetaliscafe(cc.getName_cafe(),cc.getUrl_cafe(),cc.getPhone_cafe(),cc.getPlace_cafe(),cc.getMenue_cafe(),cc.getLocation_cafe());
            }
        });

    }



    private void  opendetaliscafe(String ...detalis) {

        Intent i = new Intent(c, cafe_det.class);
        i.putExtra("name_cafe", detalis[0]);
        i.putExtra("url_cafe", detalis[1]);
        i.putExtra("phone_cafe", detalis[2]);
        i.putExtra("place_cafe",detalis[3]);
        i.putExtra("menue_cafe",detalis[4]);
        i.putExtra("location_cafe",detalis[5]);


        c.startActivity(i);

    }




    @Override
    public int getItemCount() {
        return cafes.size();
    }

}
