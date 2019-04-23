package com.example.engahmed.mitchamr.FlipperIntro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;


import com.example.engahmed.mitchamr.Main2Activity;
import com.example.engahmed.mitchamr.R;
import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

import static com.estimote.sdk.EstimoteSDK.getApplicationContext;

public class AppIntroActivity extends AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_app_intro);

        addSlide(AppIntroFragment.newInstance("First App Into", "First App Intro Details",
                R.drawable.img1, ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary)));
        addSlide(AppIntroFragment.newInstance("Second App Into", "Second App Intro Details",
                R.drawable.img2, ContextCompat.getColor(getApplicationContext(), R.color.orange)));
        addSlide(AppIntroFragment.newInstance("Third App Into", "Third App Intro Details",
                R.drawable.img3, ContextCompat.getColor(getApplicationContext(), R.color.blue)));

//        SharedPreferences sp = getSharedPreferences("checking",MODE_PRIVATE);
//
//        String data = sp.getString("check", "");
//
//        if (data.equals("success")) {
//
////one time proccess code
//
////with follow code
//
//            SharedPreferences spp= getSharedPreferences("mitchamr",MODE_PRIVATE);
//
//            SharedPreferences.Editor e1 = spp.edit();
//
//            e1.putString("check","success");
//
//            e1.commit();
//
//
//        } else {
//
//// code for main
//
//            Intent intent = new Intent(this, Main2Activity.class);
//            startActivity(intent);
//
//        }
//


    }



    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        Intent intent=new Intent(getApplicationContext(), Main2Activity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
        startActivity(intent);
        finish();
    }


}
