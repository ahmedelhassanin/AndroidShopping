package com.example.engahmed.mitchamr.food.desert;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.engahmed.mitchamr.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * Created by Eng Ahmed on 16/03/2017.
 */

public class holdersweets extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView namesweets;
    ImageView imgsweets;
    itemclicksweet itemclicksweet;
    DatabaseReference db;

    public holdersweets(View itemView) {
        super(itemView);

        namesweets=(TextView) itemView.findViewById(R.id.textviewsweet);
        imgsweets=(ImageView) itemView.findViewById(R.id.imagesweet);
        db= FirebaseDatabase.getInstance().getReference("deserts");
         itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
       this.itemclicksweet.onItemClick(this.getLayoutPosition());

    }


    public void setItemclicksweet(itemclicksweet itemclicksweet){
        this.itemclicksweet=itemclicksweet;
    }




}
