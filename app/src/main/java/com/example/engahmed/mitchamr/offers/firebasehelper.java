package com.example.engahmed.mitchamr.offers;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by eng ahmed on 10/9/2017.
 */

public class firebasehelper {

    DatabaseReference db;
    ArrayList<moder_offer> models=new ArrayList<>();

    public firebasehelper(DatabaseReference db){

        this.db=db;

    }


    public void feetchdata(DataSnapshot dataSnapshot){
        models.clear();
        for(DataSnapshot ds:dataSnapshot.getChildren()){

            moder_offer moder=ds.getValue(moder_offer.class);
            System.out.println(ds.getValue());

            models.add(moder);
        }

    }



    public ArrayList<moder_offer> reciceoffer(){

        FirebaseDatabase.getInstance().getReference().child("offer").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                feetchdata(dataSnapshot);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        return models;
    }








}
