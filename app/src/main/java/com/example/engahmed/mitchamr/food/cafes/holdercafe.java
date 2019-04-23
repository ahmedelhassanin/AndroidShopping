package com.example.engahmed.mitchamr.food.cafes;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.engahmed.mitchamr.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Eng Ahmed on 19/05/2017.
 */

public class holdercafe extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView textView;
    ImageView imageView;
    itemclickcafe itemclickcafe;
    DatabaseReference db;


    public holdercafe(View itemView) {
        super(itemView);

        textView=(TextView) itemView.findViewById(R.id.textviewcafe);
        imageView=(ImageView) itemView.findViewById(R.id.imagecafe);
         db= FirebaseDatabase.getInstance().getReference("cafes");
         itemView.setOnClickListener(this);

    }




    @Override
    public void onClick(View v) {

        this.itemclickcafe.onItemClick(this.getLayoutPosition());
    }



    public void setItemclickcafe(itemclickcafe itemclickcafe){
        this.itemclickcafe=itemclickcafe;

    }





}
