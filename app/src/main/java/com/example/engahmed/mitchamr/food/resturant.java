package com.example.engahmed.mitchamr.food;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.engahmed.mitchamr.R;
import com.example.engahmed.mitchamr.bags.bag_model;
import com.google.firebase.FirebaseApp;
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

public class resturant extends Fragment {

      RecyclerView recyclerView;

      MYAdapter adapter;

    ArrayList<menumodel> resturants = new ArrayList<>();

    Context c;
    DatabaseReference db;





    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootview = inflater.inflate(R.layout.resturant, container, false);

        recyclerView=(RecyclerView) rootview.findViewById(R.id.recy);
         recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
         adapter=new MYAdapter(this.getActivity(),retrivedata_res());
          recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
         adapter.notifyDataSetChanged();

    //    recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));


        recyclerView.setHasFixedSize(true);
         db= FirebaseDatabase.getInstance().getReference().child("resturants");


        return rootview;

    }

    public String toString(){
        return "resturants";
    }


    private void fetchData(DataSnapshot dataSnapshot) {
        resturants.clear();
        for(DataSnapshot ds:dataSnapshot.getChildren()){
            menumodel m=ds.getValue(menumodel.class);
            System.out.println(ds.getValue());
            resturants.add(m);
        }


        }


    public ArrayList<menumodel> retrivedata_res() {


        FirebaseDatabase.getInstance().getReference().child("resturants").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                fetchData(dataSnapshot);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });





        return resturants;


    }







}
