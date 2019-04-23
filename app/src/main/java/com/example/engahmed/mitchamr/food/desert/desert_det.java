package com.example.engahmed.mitchamr.food.desert;

import android.*;
import android.Manifest;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.engahmed.mitchamr.*;
import com.example.engahmed.mitchamr.ChildAnimationExample;
import com.example.engahmed.mitchamr.R;
import com.example.engahmed.mitchamr.SliderLayout;
import com.example.engahmed.mitchamr.food.menues;
import com.example.engahmed.mitchamr.food.resturant_dety;


import java.util.HashMap;

public class desert_det extends AppCompatActivity {

    SliderLayout mDemoSliderde;
    ImageView imgd;
    TextView textname, textphone, textplace;
    FloatingActionButton fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desert_det);
        imgd = (ImageView) findViewById(R.id.image_des);
        textname = (TextView) findViewById(R.id.name_des);
        textphone = (TextView) findViewById(R.id.phone_des);
        textplace = (TextView) findViewById(R.id.textplace_des);


        Intent i = this.getIntent();
        String name = i.getExtras().getString("name_sweet");
        String imagurl = i.getExtras().getString("url_sweet");
        final String phone = i.getExtras().getString("phone_sweet");
        String place = i.getExtras().getString("place_sweet");

        textname.setText(name);
        textphone.setText(phone);
        picassdesert.downloadImage(this, imagurl, imgd);
        textplace.setText(place);


        textphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + phone));
                if (ActivityCompat.checkSelfPermission(desert_det.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);

            }
        });




        mDemoSliderde = (SliderLayout) findViewById(R.id.view_des);

        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("1", R.drawable.fash);
        file_maps.put("2", R.drawable.food);
        file_maps.put("3", R.drawable.ff);
        file_maps.put("4", R.drawable.as);


        for (String name1 : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    //  .description(name)
                    .image(file_maps.get(name1))
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop);
            //      .setOnSliderClickListener( this);


            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra", name1);

            mDemoSliderde.addSlider(textSliderView);
        }
        mDemoSliderde.setPresetTransformer(SliderLayout.Transformer.FlipHorizontal);
        mDemoSliderde.setPresetIndicator(com.example.engahmed.mitchamr.SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSliderde.setCustomAnimation(new ChildAnimationExample());
        mDemoSliderde.setDuration(4000);
        //   mDemoSlider.addOnPageChangeListener(this);




        displayInputDialog();
        golocation();

    }


    private void displayInputDialog() {


        fb = (FloatingActionButton) findViewById(R.id.floatingActionButton_des);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager manager = getFragmentManager();
                menue_desert popmenu = new menue_desert();
                popmenu.show(manager, null);


            }
        });


    }


    public void golocation(){
        final String  loacation=getIntent().getExtras().getString("location_sweet");

        textplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(loacation));
                startActivity(i);




            }
        });
    }




    }

