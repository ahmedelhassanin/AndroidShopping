package com.example.engahmed.mitchamr.food.cafes;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.engahmed.mitchamr.R;
import com.example.engahmed.mitchamr.food.desert.imagemenue_des;

/**
 * Created by eng ahmed on 23/07/2017.
 */

public class cafe_menue extends DialogFragment {


     ImageView menue;
      Context c;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootview = inflater.inflate(R.layout.cafe_menue, container, false);
        menue=(ImageView)rootview.findViewById(R.id.imageView_cafe);

        Intent i=this.getActivity().getIntent();
        String menuecafe =i.getExtras().getString("menue_cafe");

        menuecafes.downloadImage(c,menuecafe,menue);




        return rootview;


    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
        }
    }
}