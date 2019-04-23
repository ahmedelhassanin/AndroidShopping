package com.example.engahmed.mitchamr.clothes.children;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.engahmed.mitchamr.R;
import com.example.engahmed.mitchamr.clothes.man.model_man;
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

public class chil extends Fragment {


    DatabaseReference datachildren;
    ArrayList<model_chil> model_chils=new ArrayList<>();
    RecyclerView recyclerView;
    adapter_ch adapter_ch;




    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootview = inflater.inflate(R.layout.children, container, false);
        recyclerView=(RecyclerView) rootview.findViewById(R.id.recy_chi);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        adapter_ch=new adapter_ch(this.getActivity(),recice());
        recyclerView.setAdapter(adapter_ch);
        adapter_ch.notifyDataSetChanged();
        recyclerView.setHasFixedSize(true);
        datachildren=FirebaseDatabase.getInstance().getReference().child("market_children");

        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);



        return rootview;
    }


    public void feetchdatach(DataSnapshot dataSnapshot){
        model_chils.clear();
        for (DataSnapshot ds:dataSnapshot.getChildren()){
            model_chil m=ds.getValue(model_chil.class);
            model_chils.add(m);
        }
    }



    public ArrayList<model_chil> recice() {

        FirebaseDatabase.getInstance().getReference().child("market_children").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                feetchdatach(dataSnapshot);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        return model_chils;

    }




}
