package com.example.engahmed.mitchamr.clothes.woman;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.engahmed.mitchamr.R;

import java.util.ArrayList;

/**
 * Created by Eng Ahmed on 02/06/2017.
 */

public class adapter_woman extends RecyclerView.Adapter<holder_woman> {
    Context c;
    ArrayList<woman_model> woman_models;



    public adapter_woman(Context c,ArrayList<woman_model> woman_models){
        this.c=c;
        this.woman_models=woman_models;
    }



    @Override
    public holder_woman onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(R.layout.model_woman,parent,false);


        return new holder_woman(v);
    }

    @Override
    public void onBindViewHolder(holder_woman holder, int position) {
        holder.textViewname.setText(woman_models.get(position).getNamew());
        picass_woman.downloadImage(c,woman_models.get(position).getImagew(),holder.imgwoman);

    }

    @Override
    public int getItemCount() {
        return woman_models.size();
    }
}
