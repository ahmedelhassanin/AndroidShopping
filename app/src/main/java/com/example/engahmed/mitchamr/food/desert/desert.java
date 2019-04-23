package com.example.engahmed.mitchamr.food.desert;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
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
 * Created by Eng Ahmed on 17/05/2017.
 */

public class desert extends Fragment {

    RecyclerView recyclerView;

    DatabaseReference db;

     ArrayList<desert_model> desert= new ArrayList<>();
    adaptersweets adaptersweets;
    private ProgressDialog progressDialog;



    public desert(DatabaseReference databaseReference){
        this.db=databaseReference;
    }




    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootview = inflater.inflate(R.layout.desert, container, false);
        recyclerView=(RecyclerView) rootview.findViewById(R.id.recydesert);




        progressDialog = new ProgressDialog(this.getContext());

        progressDialog.setMessage("please wait ..");
        progressDialog.show();

        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
          adaptersweets=new adaptersweets(this.getActivity(),retrivedata());
          recyclerView.setAdapter(adaptersweets);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        adaptersweets.notifyDataSetChanged();

        db= FirebaseDatabase.getInstance().getReference().child("deserts");




        return rootview;
    }




    private void fetchData(DataSnapshot dataSnapshot) {
        desert.clear();
        for (DataSnapshot ds : dataSnapshot.getChildren()) {
            desert_model m = ds.getValue(desert_model.class);
            desert.add(m);
        }

    }

    public ArrayList<desert_model> retrivedata() {

        FirebaseDatabase.getInstance().getReference().child("deserts").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                fetchData(dataSnapshot);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        return desert;
    }











}
