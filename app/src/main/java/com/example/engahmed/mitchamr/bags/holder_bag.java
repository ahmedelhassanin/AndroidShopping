package com.example.engahmed.mitchamr.bags;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.engahmed.mitchamr.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Eng Ahmed on 30/05/2017.
 */

public class holder_bag extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView name_bag;
    ImageView image_bag;
    ItemClickLisner_bag itemClickLisner_bag;
    DatabaseReference db;



    public holder_bag(View itemView) {
        super(itemView);

        name_bag=(TextView) itemView.findViewById(R.id.name_bag);
        image_bag=(ImageView) itemView.findViewById(R.id.image_bag);
        db= FirebaseDatabase.getInstance().getReference("bag");
        itemView.setOnClickListener(this);

    }


    public void setItemClickLisner_bag(ItemClickLisner_bag itemClickLisner_bag){
        this.itemClickLisner_bag=itemClickLisner_bag;
    }


    @Override
    public void onClick(View v) {

        this.itemClickLisner_bag.onItemClick(this.getLayoutPosition());

    }



}
