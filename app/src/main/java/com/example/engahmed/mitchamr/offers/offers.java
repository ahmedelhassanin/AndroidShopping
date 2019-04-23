package com.example.engahmed.mitchamr.offers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import com.example.engahmed.mitchamr.R;
import com.example.engahmed.mitchamr.Souvenir.model_souvenir;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class offers extends AppCompatActivity {
    DatabaseReference db;
    GridView gridView;
    Baseadaptre baseadaptre;
    firebasehelper firebasehelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);
    db =FirebaseDatabase.getInstance().getReference().child("offer");


        firebasehelper=new firebasehelper(db);
        gridView=(GridView)findViewById(R.id.gridview);
        baseadaptre=new Baseadaptre(this,firebasehelper.reciceoffer());

        gridView.setAdapter(baseadaptre);

    }












}
