package com.example.engahmed.mitchamr.food;


import android.Manifest;
import android.app.Dialog;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.engahmed.mitchamr.R;
import com.example.engahmed.mitchamr.SliderLayout;
import com.example.engahmed.mitchamr.ChildAnimationExample;

import java.util.HashMap;

public class resturant_dety extends AppCompatActivity {


    SliderLayout mDemoSlider_;
    TextView textname,textphone,late,lang,textplace;
    ImageView logo,menuess;
    FloatingActionButton fb;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resturant_dety);

        textname=(TextView)findViewById(R.id.name_res);
        textphone=(TextView)findViewById(R.id.phone_res);
        logo=(ImageView)findViewById(R.id.image_res);
        textplace=(TextView)findViewById(R.id.textplace);


        displayInputDialog();



        Intent i=this.getIntent();
        String name=i.getExtras().getString("name");
        final String phone=i.getExtras().getString("phone");
        String imagurl=i.getExtras().getString("url");
        String place=i.getExtras().getString("place");





       // String imagmenue=i.getExtras().getString("menue");
        textname.setText(name);
       textphone.setText(phone);
        textplace.setText(place);
        picassclient.downloadImage(this,imagurl,logo);


      //  picassclient.downloadImage(this,imagmenue,menue);
        textphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+phone));
                if (ActivityCompat.checkSelfPermission(resturant_dety.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)                                                   {
                    return;
                }
                startActivity(callIntent);

            }
        });


     //    textplace.setOnClickListener(new View.OnClickListener() {
       //      @Override
         //   public void onClick(View v) {
           //      String uri = "http://maps.google.com/maps?daddr=" + late + "," + lang + " (" + "Where the party is at" + ")";
             //    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
               //  intent.setPackage("com.google.android.apps.maps");
               //  startActivity(intent);

      //     }
     //  });



        //************slider*****************




        mDemoSlider_ = (SliderLayout)findViewById(R.id.view_rest);

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("1", R.drawable.fash  );
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

            mDemoSlider_.addSlider(textSliderView);
        }
        mDemoSlider_.setPresetTransformer(SliderLayout.Transformer.Background2Foreground);
        mDemoSlider_.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider_.setCustomAnimation(new ChildAnimationExample());
        mDemoSlider_.setDuration(4000);
        //   mDemoSlider.addOnPageChangeListener(this);


         goolocation();

    }


    private void displayInputDialog() {


        fb=(FloatingActionButton)findViewById(R.id.floatingActionButton);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager manager=getFragmentManager();
               menues popmenu1=new menues();
                popmenu1.show(manager,null);



            }
        });


    }



    public void goolocation(){
        final String locat_re=getIntent().getExtras().getString("urlLocation_res");


        textplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(locat_re));
                startActivity(i);


            }
        });

    }







    }











