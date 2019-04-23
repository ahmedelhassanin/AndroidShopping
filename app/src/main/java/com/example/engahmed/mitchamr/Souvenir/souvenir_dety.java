package com.example.engahmed.mitchamr.Souvenir;

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

public class souvenir_dety extends AppCompatActivity {


    ImageView img,logo,facebook;
    TextView textname,textphone,textplace;
    FloatingActionButton fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_souvenir_dety);
        img=(ImageView)findViewById(R.id.imageView_p);
        logo=(ImageView)findViewById(R.id.bag);
        textname=(TextView)findViewById(R.id.textname_bag);
        textphone=(TextView)findViewById(R.id.textphonesbag);
        textplace=(TextView)findViewById(R.id.textplace);
        facebook=((ImageView)findViewById(R.id.imgfacebook));
        fb=(FloatingActionButton)findViewById(R.id.loca);


        Intent i=this.getIntent();
        String name=i.getExtras().getString("name_sou");
        final String phone=i.getExtras().getString("phone");
        String logos=i.getExtras().getString("logo");
        String place=i.getExtras().getString("place_sou");
        String imgs=i.getExtras().getString("imaage_sou");


        textname.setText(name);
        textphone.setText(phone);
        textplace.setText(place);
        picassclient.downloadImage(this,logos,logo);

        imagsouv.downloadImage(this,imgs,img);



        textphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+phone));
                if (ActivityCompat.checkSelfPermission(souvenir_dety.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)                                                   {
                    return;
                }
                startActivity(callIntent);

            }
        });




        gofacebooksouv();

       goLocation();


    }




    public void gofacebooksouv(){

        Intent f=this.getIntent();
        final String facebook_= getIntent().getExtras().getString("urlfacebook");
       // facebook.setImageURI(Uri.parse(facebook_));
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(facebook_ !=null) {

                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(facebook_));
                    startActivity(i);

                }
            }
        });



    }


    public void goLocation(){
        final String locat=getIntent().getExtras().getString("urllocation");
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(locat !=null){

                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(locat));
                    startActivity(i);

                }
            }
        });

    }






}
