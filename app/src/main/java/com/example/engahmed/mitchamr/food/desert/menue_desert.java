package com.example.engahmed.mitchamr.food.desert;


import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.engahmed.mitchamr.R;
import com.example.engahmed.mitchamr.food.picassmenus;

/**
 * Created by eng ahmed on 22/07/2017.
 */

public class menue_desert extends DialogFragment {

    ImageView menues;
    Context c;
    String menued;



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootview = inflater.inflate(R.layout.menue_desert, container, false);
        menues=(ImageView)rootview.findViewById(R.id.imageView_de);

        Intent i=this.getActivity().getIntent();
        menued =i.getExtras().getString("menue_sweet");

        imagemenue_des.downloadImage(c,menued,menues);



        return rootview;
    }





}
