package com.example.engahmed.mitchamr.bags;

import android.Manifest;
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

import com.example.engahmed.mitchamr.R;
import com.example.engahmed.mitchamr.Souvenir.imagsouv;
import com.example.engahmed.mitchamr.Souvenir.picassclient;
import com.example.engahmed.mitchamr.Souvenir.souvenir_dety;

public class bags_detyalis extends AppCompatActivity {

    ImageView imgplace,imglogo,imgfacebook;
    TextView name,phone,place;
    FloatingActionButton fblocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bags_detyalis);
        imgplace=(ImageView)findViewById(R.id.imageView_bag);
        imglogo=(ImageView)findViewById(R.id.bag);
        imgfacebook=(ImageView)findViewById(R.id.imgfacebook);
        name=(TextView)findViewById(R.id.textname_bag);
        phone=(TextView)findViewById(R.id.textphonesbag);
        place=(TextView)findViewById(R.id.textplacebag);
        fblocation=(FloatingActionButton)findViewById(R.id.locabag);



        Intent i=this.getIntent();
        String nameb=i.getExtras().getString("name_");
        final String phoneb=i.getExtras().getString("phone");
        String logos=i.getExtras().getString("image");
        String placeb=i.getExtras().getString("place_bag");
        String imgs=i.getExtras().getString("img_place");

        name.setText(nameb);
        phone.setText(phoneb);
        place.setText(placeb);
        image_bag.downloadImage(this,logos,imglogo);
        imageplace_bag.downloadImage(this,imgs,imgplace);


        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+phoneb));
                if (ActivityCompat.checkSelfPermission(bags_detyalis.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)                                                   {
                    return;
                }
                startActivity(callIntent);





            }
        });

        gofacebookbag();
        gourllocationbag();


    }



    public void gofacebookbag(){

        final String facebookba= getIntent().getExtras().getString("facebook_bag");
        imgfacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(facebookba !=null) {

                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(facebookba));
                    startActivity(i);

                }
            }
        });




    }


    public void gourllocationbag(){
        final String locatba=getIntent().getExtras().getString("location_bag");
        fblocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(locatba !=null){

                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(locatba));
                    startActivity(i);

                }


            }
        });



    }




    }


