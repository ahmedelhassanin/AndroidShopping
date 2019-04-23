package com.example.engahmed.mitchamr.clothes.woman;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.engahmed.mitchamr.R;
import com.example.engahmed.mitchamr.food.menumodel;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Eng Ahmed on 18/05/2017.
 */

public class woman extends Fragment {

    ArrayList<woman_model> woman_models=new ArrayList<>();
    DatabaseReference db;
    Context c;
    RecyclerView recyclerView;
    adapter_woman adapter_woman;






    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootview = inflater.inflate(R.layout.woman, container, false);
        recyclerView=(RecyclerView) rootview.findViewById(R.id.recy_woman);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        adapter_woman=new adapter_woman(this.getActivity(),recice());
        recyclerView.setAdapter(adapter_woman);
        adapter_woman.notifyDataSetChanged();
        recyclerView.setHasFixedSize(true);

        db= FirebaseDatabase.getInstance().getReference().child("market_woman");

        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);



        return rootview;
    }


    public String toString(){
        return "market_woman";
    }










    public void feetchdata(DataSnapshot dataSnapshot){
        woman_models.clear();
        for (DataSnapshot ds:dataSnapshot.getChildren()){
            woman_model m=ds.getValue(woman_model.class);
            woman_models.add(m);

        }
    }


    public ArrayList<woman_model> recice() {

        FirebaseDatabase.getInstance().getReference().child("market_woman").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                feetchdata(dataSnapshot);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        return woman_models;

    }







}
