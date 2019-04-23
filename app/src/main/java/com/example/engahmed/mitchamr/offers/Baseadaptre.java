package com.example.engahmed.mitchamr.offers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.engahmed.mitchamr.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by eng ahmed on 10/8/2017.
 */

public class Baseadaptre extends BaseAdapter {

    Context c;
    ArrayList<moder_offer>moder_offers;
    DatabaseReference db;


    public Baseadaptre(Context c,ArrayList<moder_offer>moder_offers){

        this.c=c;
        this.moder_offers=moder_offers;

    }


    @Override
    public int getCount() {
        return moder_offers.size();
    }

    @Override
    public Object getItem(int position) {
        return moder_offers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if (convertView==null){
            convertView= LayoutInflater.from(c).inflate(R.layout.model_offer,parent,false);

        }

        ImageView imageView=(ImageView) convertView.findViewById(R.id.image1);
        TextView texttittle=(TextView)  convertView.findViewById(R.id.tittle1);
        TextView textdes=(TextView)  convertView.findViewById(R.id.des1);
        TextView textprice=(TextView) convertView.findViewById(R.id.price1);

        final moder_offer  s=(moder_offer) this.getItem(position);
        texttittle.setText(s.getTittle());
        textprice.setText(s.getPrice());
        textdes.setText(s.getDes());
        picas_offer.downloadImage(c,s.getImgurl(),imageView);
        return convertView;
    }
}
