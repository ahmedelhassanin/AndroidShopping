package com.example.engahmed.mitchamr.food.cafes;

import android.app.ProgressDialog;
import android.content.Context;
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

public class cafe extends Fragment {

    ArrayList<cafe_model> cafes = new ArrayList<>();


    DatabaseReference db;
    RecyclerView recyclerView;
    adaptercafe adaptercafe;
    private ProgressDialog pDialog;




    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootview = inflater.inflate(R.layout.cafe, container, false);

        pDialog = new ProgressDialog(getContext());
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();

                 recyclerView=(RecyclerView) rootview.findViewById(R.id.recycafe);
                 recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
                 adaptercafe=new adaptercafe(this.getActivity(),retrivedata());
                recyclerView.setAdapter(adaptercafe);
               recyclerView.setHasFixedSize(true);
               recyclerView.setItemViewCacheSize(20);
              recyclerView.setDrawingCacheEnabled(true);
               recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);


        adaptercafe.notifyDataSetChanged();
                  db= FirebaseDatabase.getInstance().getReference().child("cafes");
                db.keepSynced(true);



        return rootview;
    }


    public String toString(){
        return "cafes";
    }



    public ArrayList<cafe_model> retrivedata(){


        FirebaseDatabase.getInstance().getReference().child("cafes").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

              feetchdata(dataSnapshot);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });





        return cafes;


    }

    public void feetchdata(DataSnapshot dataSnapshot){
        hidePDialog();
        cafes.clear();
        for (DataSnapshot ds:dataSnapshot.getChildren()){
           cafe_model mm=ds.getValue(cafe_model.class);

            System.out.println(ds.getValue());
            cafes.add(mm);
        }
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


}
