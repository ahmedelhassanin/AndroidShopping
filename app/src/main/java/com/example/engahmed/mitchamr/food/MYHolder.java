package com.example.engahmed.mitchamr.food;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.engahmed.mitchamr.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * Created by Eng Ahmed on 17/01/2017.
 */

public class MYHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    TextView nametext;
    ImageView img;
    ItemClickLisner itemClickLisner;
    DatabaseReference db;






    public MYHolder(View itemView) {
        super(itemView);

        nametext=(TextView) itemView.findViewById(R.id.textview);
        img=(ImageView) itemView.findViewById(R.id.moveimage);

        db= FirebaseDatabase.getInstance().getReference("resturants");
         itemView.setOnClickListener(this);


    }

     public void setItemClickLisner(ItemClickLisner itemClickLisner){
         this.itemClickLisner=itemClickLisner;
     }

    @Override
    public void onClick(View v) {
        this.itemClickLisner.onItemClick(this.getLayoutPosition());
    }
}
