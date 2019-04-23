package com.example.engahmed.mitchamr.clothes.man;

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

public class man extends Fragment {

    RecyclerView recyclerView;
    adapter_man adapter_man;
    Context c;
    DatabaseReference db;
    ArrayList<model_man> model_mens=new ArrayList<>();


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootview = inflater.inflate(R.layout.man, container, false);
        recyclerView=(RecyclerView) rootview.findViewById(R.id.recy_man);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        adapter_man=new adapter_man(this.getActivity(),recice());
        recyclerView.setAdapter(adapter_man);
        adapter_man.notifyDataSetChanged();

        recyclerView.setHasFixedSize(true);
        db= FirebaseDatabase.getInstance().getReference().child("market_man");

        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);




        return rootview;

    }


    public String toString(){
        return "market_man";
    }





    public void feetchdata(DataSnapshot dataSnapshot){
        model_mens.clear();
        for (DataSnapshot ds :dataSnapshot.getChildren()){
            model_man m=ds.getValue(model_man.class);
            model_mens.add(m);
        }

    }





    public ArrayList<model_man> recice() {

        FirebaseDatabase.getInstance().getReference().child("market_man").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                feetchdata(dataSnapshot);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        return model_mens;

    }




}
