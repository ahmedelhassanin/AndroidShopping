package com.example.engahmed.mitchamr.clothes.woman;

import android.content.Context;
import android.widget.ImageView;

import com.example.engahmed.mitchamr.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Eng Ahmed on 02/06/2017.
 */

public class picass_woman {

    public static void downloadImage(Context c, String url, ImageView img)
    {
        if(url != null && url.length()>0)
        {
            Picasso.with(c).load(url).skipMemoryCache().resize(100,100).placeholder(R.drawable.woman).resize(400,400).into(img);

        }else {
            Picasso.with(c).load(R.drawable.woman).into(img);
        }
    }




}
