package com.example.engahmed.mitchamr.food;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

import com.example.engahmed.mitchamr.R;

import java.io.InputStream;

/**
 * Created by eng ahmed on 21/07/2017.
 */

public class menues  extends DialogFragment  {

    ImageView menues;

     Context c;
   String menue,menutw;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootview = inflater.inflate(R.layout.rest_menu, container, false);
        menues=(ImageView)rootview.findViewById(R.id.imageView_me);


        Intent i=this.getActivity().getIntent();
         menue =i.getExtras().getString("menue");

        picassmenus.downloadImage(c,menue,menues);






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


