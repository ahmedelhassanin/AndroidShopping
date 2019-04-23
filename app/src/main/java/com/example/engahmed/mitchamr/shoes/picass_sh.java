package com.example.engahmed.mitchamr.shoes;

import android.content.Context;
import android.widget.ImageView;

import com.example.engahmed.mitchamr.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

/**
 * Created by eng ahmed on 05/07/2017.
 */

public class picass_sh {

    public static void downloadImage(Context c, String url, ImageView img)
    {
        if(url != null && url.length()>0)
        {
            Picasso.with(c).load(url).skipMemoryCache().placeholder(R.drawable.lll).error(R.drawable.dd).into(img);


        }else {
            Picasso.with(c).load(R.drawable.dd).into(img);
        }
    }

}
