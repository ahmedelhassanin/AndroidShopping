package com.example.engahmed.mitchamr.shoes;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by eng ahmed on 05/07/2017.
 */

public class shoes_db {

    DatabaseReference db;
    ArrayList<model_sh> model_shes = new ArrayList<>();




    public shoes_db(DatabaseReference databaseReference){

        this.db=databaseReference;
    }


    private void fetchDataa(DataSnapshot dataSnapshot) {
        model_shes.clear();
        for (DataSnapshot ds : dataSnapshot.getChildren()) {
            model_sh m = ds.getValue(model_sh.class);
     //     Log.i("the model shoes::",m.toString());
       //    Log.i("the model name ::",m.getName_sh());
       //     Log.i("the image ::",m.getImage_sh());

            System.out.println(ds.getValue());

            model_shes.add(m);
        }


    }

    public ArrayList<model_sh> recivedata(){

        FirebaseDatabase.getInstance().getReference().child("shoes").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                fetchDataa(dataSnapshot);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        return model_shes;
    }








}
