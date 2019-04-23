package com.example.engahmed.mitchamr.food;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.engahmed.mitchamr.R;

import java.util.ArrayList;

/**
 * Created by Eng Ahmed on 17/01/2017.
 */

public class MYAdapter extends RecyclerView.Adapter<MYHolder> {

    Context c;
    ArrayList<menumodel> resturants;




   public MYAdapter(Context c, ArrayList<menumodel> resturants){
        this.c=c;
        this.resturants=resturants;


    }


    public MYHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(c).inflate(R.layout.model,parent,false);



        return new MYHolder(v);


    }

    @Override
    public void onBindViewHolder(MYHolder holder, int position) {

        final menumodel m=resturants.get(position);


        holder.nametext.setText(resturants.get(position).getName());
        picassclient.downloadImage(c,resturants.get(position).getUrl(),holder.img);





        holder.setItemClickLisner(new ItemClickLisner() {
           @Override
           public void onItemClick(int pos) {
           opendetalis(m.getName(),m.getUrl(),m.getPhone(),m.getPlace(),m.getMenue(),m.getUrlLocation_res());
             // openlocation(m.getLate(),m.getLang());

         }
       });




   }

   // @Override
    public int getItemCount() {
        return resturants.size();
    }

     private void  opendetalis(String ...detalis) {

         Intent i = new Intent(c, resturant_dety.class);
         i.putExtra("name", detalis[0]);
         i.putExtra("url", detalis[1]);
         i.putExtra("phone", detalis[2]);
         i.putExtra("place",detalis[3]);
         i.putExtra("menue",detalis[4]);
         i.putExtra("urlLocation_res",detalis[5]);


         c.startActivity(i);

     }



    }







