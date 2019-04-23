package com.example.engahmed.mitchamr.Souvenir;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.engahmed.mitchamr.R;

import java.util.ArrayList;

/**
 * Created by Eng Ahmed on 03/06/2017.
 */

public class adapter_souv extends RecyclerView.Adapter<holder> {

    Context c;
    ArrayList<model_souvenir> model_souvenirs;

    public adapter_souv(Context c,ArrayList<model_souvenir> model_souvenirs){
        this.c=c;
        this.model_souvenirs=model_souvenirs;
    }



    @Override
    public holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(R.layout.model_souvenir,parent,false);

        return new holder(v);
    }

    @Override
    public void onBindViewHolder(holder holder, int position) {
          final model_souvenir m=model_souvenirs.get(position);

        holder.name.setText(model_souvenirs.get(position).getName_sou());
        picassclient.downloadImage(c,model_souvenirs.get(position).getLogo(),holder.img);
         holder.setItemClickLisner(new ItemClickLisner() {
            @Override
            public void onItemClick(int pos) {
                opendetalis(m.getName_sou(),m.getLogo(),m.getPhone(),m.getPlace_sou(),m.getImaage_sou(),m.getUrlfacebook(),m.getUrllocation() );
            }
         });

    }

    @Override
    public int getItemCount() {
        return model_souvenirs.size();
    }



      private void  opendetalis(String...detalis){
          Intent i=new Intent(c,souvenir_dety.class);
          i.putExtra("name_sou",detalis[0]);
         i.putExtra("logo",detalis[1]);
          i.putExtra("phone",detalis[2]);
          i.putExtra("place_sou",detalis[3]);
          i.putExtra("imaage_sou",detalis[4]);
          i.putExtra("urlfacebook",detalis[5]);
          i.putExtra("urllocation",detalis[6]);
          c.startActivity(i);
    }

}
