package com.example.engahmed.mitchamr.bags;

import android.content.Context;
import android.security.NetworkSecurityPolicy;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.estimote.sdk.repackaged.okhttp_v2_2_0.com.squareup.okhttp.internal.Network;
import com.example.engahmed.mitchamr.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Eng Ahmed on 30/05/2017.
 */

public class image_bag {



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
