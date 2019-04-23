package com.example.engahmed.mitchamr.food.cafes;

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
import com.example.engahmed.mitchamr.SliderLayout;
import com.example.engahmed.mitchamr.ChildAnimationExample;
import com.example.engahmed.mitchamr.food.desert.menue_desert;

import java.util.HashMap;

public class cafe_det extends AppCompatActivity {

    ImageView imagecafe;
    TextView textname,textphone,textplace;
    SliderLayout mDemoSliderc;

    FloatingActionButton fb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe_det);

        imagecafe=(ImageView)findViewById(R.id.image_cafe);
        textname=(TextView)findViewById(R.id.name_cafe);
        textphone=(TextView)findViewById(R.id.phone_cafe);
        textplace=(TextView)findViewById(R.id.textplace_cafe);

        Intent i=this.getIntent();

        String name=i.getExtras().getString("name_cafe");
        String imagurl=i.getExtras().getString("url_cafe");
        final String phone=i.getExtras().getString("phone_cafe");
        String place=i.getExtras().getString("place_cafe");


        textname.setText(name);
        textphone.setText(phone);
        textplace.setText(place);
        picasscafe.downloadImage(this,imagurl,imagecafe);


        textphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+phone));
                if (ActivityCompat.checkSelfPermission(cafe_det.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)                                                   {
                    return;
                }
                startActivity(callIntent);

            }
        });





        //************slider*****************


        mDemoSliderc = (SliderLayout) findViewById(R.id.view_cafe);

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("1", R.drawable.fash);
        file_maps.put("2",R.drawable.food);
        file_maps.put("3",R.drawable.ff);
        file_maps.put("4",R.drawable.as);



        for(String name1 : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    //  .description(name)
                    .image(file_maps.get(name1))
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop);
            //      .setOnSliderClickListener( this);


            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra", name1);

            mDemoSliderc.addSlider(textSliderView);
        }
        mDemoSliderc.setPresetTransformer(SliderLayout.Transformer.FlipHorizontal);
        mDemoSliderc.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSliderc.setCustomAnimation(new ChildAnimationExample());
        mDemoSliderc.setDuration(4000);
        //   mDemoSlider.addOnPageChangeListener(this);


    displayInputDialog();

    golication_cafe();

    }





    private void displayInputDialog() {


        fb = (FloatingActionButton) findViewById(R.id.floatingActionButton_cafe);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager manager = getFragmentManager();
                cafe_menue popmenu = new cafe_menue();
                popmenu.show(manager, null);


            }
        });

    }



    public void  golication_cafe(){
        final String locat_cafe=getIntent().getExtras().getString("location_cafe");

        textplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(locat_cafe));
                startActivity(i);




            }
        });



    }



}
