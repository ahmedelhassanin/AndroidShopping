package com.example.engahmed.mitchamr.shoes;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.engahmed.mitchamr.*;


public class shoess_dety extends AppCompatActivity {

    TextView textname,textphone,textplace;
    ImageView imglogo,image,facebook;
    FloatingActionButton fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoess_dety);

        textname=(TextView)findViewById(R.id.textname_bag);
        textphone=(TextView)findViewById(R.id.textphonesbag);
        textplace=(TextView)findViewById(R.id.textplacesh);
        imglogo=(ImageView)findViewById(R.id.bag);
        image=(ImageView)findViewById(R.id.imageView_sh);
        facebook=(ImageView)findViewById(R.id.facebooksh);
        fb=(FloatingActionButton)findViewById(R.id.locash);

        Intent i=this.getIntent();
        String name=i.getExtras().getString("name_sh");
        final String phone=i.getExtras().getString("phone_sh");
        String logos=i.getExtras().getString("image_sh");
        String place=i.getExtras().getString("plac_sh");
        String imgs=i.getExtras().getString("imgsh");

      textname.setText(name);
      textphone.setText(phone);
       textplace.setText(place);
         picass_sh.downloadImage(this,logos,imglogo);
        imgshoes.downloadImage(this,imgs,image);
        gofacebooksh();
        golocation();

    }




    public void gofacebooksh(){

        final String facebookshoes= getIntent().getExtras().getString("urlfacebook_sh");

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(facebookshoes !=null) {

                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(facebookshoes));
                    startActivity(i);

                }


            }
        });


    }
            public void golocation(){

                fb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        final String locatsh=getIntent().getExtras().getString("urllocation_sh");
                        fb.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if(locatsh !=null){

                                    Intent i = new Intent(Intent.ACTION_VIEW);
                                    i.setData(Uri.parse(locatsh));
                                    startActivity(i);

                                }
                            }
                        });






                    }
                });



            }





}
