package com.example.engahmed.mitchamr.Souvenir;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.engahmed.mitchamr.R;
import com.example.engahmed.mitchamr.bags.bag_model;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.Marker;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Main_souvenir extends AppCompatActivity{

    DatabaseReference databaseReference;
    ArrayList<model_souvenir> model_souvenirs=new ArrayList<>();
    adapter_souv adapter_souv;
    RecyclerView recyclerView;
    private ProgressDialog pDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_souvenir);
        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();

        recyclerView=(RecyclerView)findViewById(R.id.recy_souve);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter_souv=new adapter_souv(this,recicesouv());
        adapter_souv.notifyDataSetChanged();
        recyclerView.setAdapter(adapter_souv);
        databaseReference  =FirebaseDatabase.getInstance().getReference().child("souvenir");
        databaseReference.keepSynced(true);

        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);




    }

    public void feetchdata(DataSnapshot dataSnapshot){
        model_souvenirs.clear();
        for(DataSnapshot ds:dataSnapshot.getChildren()){
            model_souvenir b=ds.getValue(model_souvenir.class);
            System.out.println(ds.getValue());

            model_souvenirs.add(b);
        }

    }



    public ArrayList<model_souvenir> recicesouv(){
        hidePDialog();

        FirebaseDatabase.getInstance().getReference().child("souvenir").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                feetchdata(dataSnapshot);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        return model_souvenirs;
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
