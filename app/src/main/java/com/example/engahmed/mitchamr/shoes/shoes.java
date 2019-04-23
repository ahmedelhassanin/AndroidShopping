package com.example.engahmed.mitchamr.shoes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.engahmed.mitchamr.R;

import com.example.engahmed.mitchamr.food.menumodel;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;

public class shoes extends AppCompatActivity {


    RecyclerView recyclerView;
    DatabaseReference db;

    adapter_sh adapter_sh;
  shoes_db shoes_db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoes);
        shoes_db=new shoes_db(db);
        recyclerView=(RecyclerView)findViewById(R.id.reccy_sh);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter_sh=new adapter_sh(this,shoes_db.recivedata());
        adapter_sh.notifyDataSetChanged();
        recyclerView.setAdapter(adapter_sh);
        db=FirebaseDatabase.getInstance().getReference().child("shoes");
        db.keepSynced(true);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);




    }



    public String toString(){
        return "shoes";
    }





}


