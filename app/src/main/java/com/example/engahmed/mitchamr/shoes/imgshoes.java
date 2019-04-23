package com.example.engahmed.mitchamr.shoes;

import android.content.Context;
import android.widget.ImageView;

import com.example.engahmed.mitchamr.R;
import com.squareup.picasso.Picasso;

/**
 * Created by eng ahmed on 27/07/2017.
 */

public class imgshoes {



    public static void downloadImage(Context c, String url, ImageView imgcafe)
    {
        if(url != null && url.length()>0)
        {
            Picasso.with(c).load(url).skipMemoryCache().resize(220,220).placeholder(R.drawable.lll).error(R.drawable.fgggg).into(imgcafe);

        }else {
            Picasso.with(c).load(R.drawable.lll).into(imgcafe);
        }
    }










}
