package com.example.engahmed.mitchamr.food.desert;

import android.content.Context;
import android.widget.ImageView;

import com.example.engahmed.mitchamr.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

/**
 * Created by eng ahmed on 22/07/2017.
 */

public class imagemenue_des {


    public static void downloadImage(Context c, String menue, ImageView img_menu)
    {
        if(menue != null && menue.length()>0)
        {
            Picasso.with(c).load(menue).skipMemoryCache() .placeholder(R.drawable.men).error(R.drawable.lll).into( img_menu);


        }else {
            Picasso.with(c).load(R.drawable.dd).into(img_menu);
        }
    }



}
