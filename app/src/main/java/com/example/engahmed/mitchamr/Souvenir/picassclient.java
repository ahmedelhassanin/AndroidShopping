package com.example.engahmed.mitchamr.Souvenir;

import android.content.Context;
import android.widget.ImageView;

import com.example.engahmed.mitchamr.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Eng Ahmed on 15/02/2017.
 */

public class picassclient {

    public static void downloadImage(Context c, String url, ImageView img)
    {
        if(url != null && url.length()>0)
        {
            Picasso.with(c).load(url).skipMemoryCache().resize(80,80).placeholder(R.drawable.ch).into(img);
                    //.error(R.drawable.lll).into(img);

        }else {
            Picasso.with(c).load(R.drawable.ch).into(img);
        }
    }

}
