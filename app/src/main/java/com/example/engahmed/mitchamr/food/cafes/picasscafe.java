package com.example.engahmed.mitchamr.food.cafes;

import android.content.Context;
import android.widget.ImageView;

import com.example.engahmed.mitchamr.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Eng Ahmed on 11/03/2017.
 */

public class picasscafe {

    public static void downloadImage(Context c, String url, ImageView imgcafe)
    {
        if(url != null && url.length()>0)
        {
            Picasso.with(c).load(url).placeholder(R.drawable.lll).error(R.drawable.dd).into(imgcafe);

        }else {
            Picasso.with(c).load(R.drawable.lll).into(imgcafe);
        }
    }

}
