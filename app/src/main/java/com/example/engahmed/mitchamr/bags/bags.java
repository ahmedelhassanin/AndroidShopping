package com.example.engahmed.mitchamr.bags;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.engahmed.mitchamr.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class bags extends AppCompatActivity {

    private ProgressDialog progressDialog;
    adapter_bag adapter_bag;
    RecyclerView recyclerView;
    DatabaseReference db;
    private ProgressDialog pDialog;

    ArrayList<bag_model> bag_models=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bags);
        progressDialog = new ProgressDialog(this);

        progressDialog.setMessage("please wait ..");
        progressDialog.show();

        recyclerView=(RecyclerView)findViewById(R.id.recy_bag);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter_bag=new adapter_bag(this,recice()) ;
        adapter_bag.notifyDataSetChanged();
        recyclerView.setAdapter(adapter_bag);

        db= FirebaseDatabase.getInstance().getReference().child("bag");
        recyclerView.setHasFixedSize(true);

        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);




    }


    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }

    public String toString(){
        return "bag";
    }



    public void fettchdata(DataSnapshot dataSnapshot){
        bag_models.clear();
        for (DataSnapshot ds: dataSnapshot.getChildren()) {
            bag_model b=ds.getValue(bag_model.class);

            System.out.println(ds.getValue());

            bag_models.add(b);
        }

    }



    public ArrayList<bag_model> recice(){

        hidePDialog();

        FirebaseDatabase.getInstance().getReference().child("bag").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                fettchdata(dataSnapshot);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        return bag_models;
    }








}
