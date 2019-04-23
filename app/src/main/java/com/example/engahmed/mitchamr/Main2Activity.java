package com.example.engahmed.mitchamr;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.engahmed.mitchamr.Souvenir.Main_souvenir;
import com.example.engahmed.mitchamr.bags.bags;
import com.example.engahmed.mitchamr.clothes.clothes;
import com.example.engahmed.mitchamr.food.food;
import com.example.engahmed.mitchamr.offers.offers;
import com.example.engahmed.mitchamr.shoes.shoes;

import java.util.HashMap;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    SliderLayout mDemoSlider_;
    ImageView imagebag,imageclose,imageshoes,imagefood,imagesouv,imageoffer;










    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       // FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
      //  fab.setOnClickListener(new View.OnClickListener() {
        //    @Override
          //  public void onClick(View view) {
            //    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
              //          .setAction("Action", null).show();
          //  }
       // });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        imagebag=(ImageView)findViewById(R.id.imagebag);
        imageclose=(ImageView)findViewById(R.id.imageclose);
        imageshoes=(ImageView)findViewById(R.id.imageshoes);
        imagefood=(ImageView) findViewById(R.id.imagefood);
        imagesouv=(ImageView) findViewById(R.id.imagesouv);
        imageoffer=(ImageView) findViewById(R.id.imageoffer);


        gosouv();
        gobag();
        goclose();
        gooffer();
        goofood();
        goshoes();








        mDemoSlider_ = (SliderLayout)findViewById(R.id.view_main);

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


























    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.food) {
            Intent intent=new Intent(Main2Activity.this,food.class);
            Toast.makeText(this,"food",Toast.LENGTH_SHORT).show();
            startActivity(intent);


        } else if (id == R.id.clothes) {
            Intent intent=new Intent(Main2Activity.this,clothes.class);
            Toast.makeText(this,"Clothes",Toast.LENGTH_SHORT).show();
            startActivity(intent);


        } else if (id == R.id.shoes) {
            Intent intent=new Intent(Main2Activity.this,shoes.class);
            Toast.makeText(this,"Shoes",Toast.LENGTH_SHORT).show();
            startActivity(intent);

        } else if (id == R.id.bags) {

            Intent intent = new Intent(Main2Activity.this, bags.class);
            Toast.makeText(this, "bags", Toast.LENGTH_SHORT).show();
            startActivity(intent);

        }else if (id == R.id.offer){


            Intent intent = new Intent(Main2Activity.this, offers.class);
            Toast.makeText(this, "offers", Toast.LENGTH_SHORT).show();
            startActivity(intent);



        } else if (id == R.id.nav_share) {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_SUBJECT, "Sharing URL");
            i.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.youm7.news");
            startActivity(Intent.createChooser(i, "Share URL"));

        } else if (id == R.id.Facebook) {

            openFacebookPage(this);


        }

        else if(id==R.id.souvenirr){

            Intent i=new Intent(Main2Activity.this,Main_souvenir.class);
            Toast.makeText(this,"Souvenir",Toast.LENGTH_SHORT).show();
            startActivity(i);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




    public void openFacebookPage(Context context) {
        Intent intent = null;
        try {
            context.getPackageManager().getPackageInfo("https://www.facebook.com/eng.Aabo7med", 0);
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/<id here>"));
            //tried this also
            //intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/<id here>"));
        } catch (Exception e) {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/eng.Aabo7med"));
        }
        context.startActivity(intent);
    }


          public void gosouv(){

              imagesouv.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {

                      Intent i=new Intent(Main2Activity.this,Main_souvenir.class);
                      startActivity(i);

                  }
              });


          }

          public void gobag(){

              imagebag.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {

                      Intent i=new Intent(Main2Activity.this,bags.class);
                      startActivity(i);
                  }
              });


          }


        public void  goclose(){

            imageclose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Intent i=new Intent(Main2Activity.this,clothes.class);
                    startActivity(i);

                }
            });


        }


        public void goofood(){
            imagefood.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Intent i=new Intent(Main2Activity.this,food.class);
                    startActivity(i);


                }
            });



        }



        public void goshoes(){

            imageshoes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i=new Intent(Main2Activity.this,shoes.class);
                    startActivity(i);
                }
            });

        }





        public void gooffer(){

            imageoffer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i=new Intent(Main2Activity.this,offers.class);
                    startActivity(i);
                }
            });



        }




}
