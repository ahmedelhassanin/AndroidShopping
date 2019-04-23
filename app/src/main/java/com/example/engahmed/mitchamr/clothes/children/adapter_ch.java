package com.example.engahmed.mitchamr.clothes.children;

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

public class adapter_ch extends RecyclerView.Adapter<holder_ch> {

    Context c;
    ArrayList<model_chil> model_chils=new ArrayList<>();


    public adapter_ch(Context c,ArrayList<model_chil> model_chils){
        this.c=c;
        this.model_chils=model_chils;
    }




    @Override
    public holder_ch onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(R.layout.model_chil,parent,false);

        return new holder_ch(v);
    }

    @Override
    public void onBindViewHolder(holder_ch holder, int position) {
        holder.name_chi.setText(model_chils.get(position).getMarket_namech());
        picassclient.downloadImage(c,model_chils.get(position).getMarket_logoch(),holder.img_chi);

    }

    @Override
    public int getItemCount() {
        return model_chils.size();
    }
}
