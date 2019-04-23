package com.example.engahmed.mitchamr.shoes;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.engahmed.mitchamr.R;

import java.util.ArrayList;

/**
 * Created by eng ahmed on 05/07/2017.
 */

public class adapter_sh extends RecyclerView.Adapter<holder_sh> {


    Context c;
    ArrayList<model_sh> model_shes;


    public adapter_sh(Context c,ArrayList<model_sh> model_shes){
        this.c=c;
        this.model_shes=model_shes;

    }


    @Override
    public holder_sh onCreateViewHolder(ViewGroup parent, int viewType) {



        View v= LayoutInflater.from(c).inflate(R.layout.model_sh,parent,false);



        return new holder_sh(v);
    }

    @Override
    public void onBindViewHolder(holder_sh holder, int position) {

        final model_sh m=model_shes.get(position);
        holder.name_sh.setText(model_shes.get(position).getName_sh());
        picass_sh.downloadImage(c,model_shes.get(position).getImage_sh(),holder.img_sh);

        holder.setItemClickLisner(new ItemClickLisner() {
            @Override
            public void onItemClick(int pos) {
                opendetyalis(m.getName_sh(),m.getImage_sh(),m.getPhone_sh(),m.getPlac_sh(),m.getUrlfacebook_sh(),m.getUrllocation_sh(),m.getImgsh());
            }
        });

    }

    @Override
    public int getItemCount() {
        return model_shes.size();
    }


    public void opendetyalis(String...deta){
        Intent i=new Intent(c,shoess_dety.class);
        i.putExtra("name_sh",deta[0]);
        i.putExtra("image_sh",deta[1]);
        i.putExtra("phone_sh",deta[2]);
        i.putExtra("plac_sh",deta[3]);
        i.putExtra("urlfacebook_sh",deta[4]);
        i.putExtra("urllocation_sh",deta[5]);
        i.putExtra("imgsh",deta[6]);
        c.startActivity(i);


    }



}
