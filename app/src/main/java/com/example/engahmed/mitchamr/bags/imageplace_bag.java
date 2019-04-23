package com.example.engahmed.mitchamr.bags;

import android.content.Context;
import android.widget.ImageView;

import com.example.engahmed.mitchamr.R;
import com.squareup.picasso.Picasso;

/**
 * Created by eng ahmed on 02/08/2017.
 */

public class imageplace_bag {



    public static void downloadImage(Context c, String url, ImageView img)
    {
        if(url != null && url.length()>0)
        {
            //  Picasso.with(c).load(url).placeholder(R.drawable.bag).error(R.drawable.lll).into(img);
            Picasso.with(c).load(url).skipMemoryCache().resize(100,100).placeholder(R.drawable.bag).error(R.drawable.bag).into(img);



        }else {
            Picasso.with(c).load(R.drawable.bag).into(img);
        }
    }









}
