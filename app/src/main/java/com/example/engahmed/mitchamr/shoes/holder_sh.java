package com.example.engahmed.mitchamr.shoes;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.engahmed.mitchamr.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * Created by eng ahmed on 05/07/2017.
 */

public class holder_sh extends RecyclerView.ViewHolder implements View.OnClickListener {

   TextView name_sh;
    ImageView img_sh;
    ItemClickLisner itemClickLisner;
    DatabaseReference db;



    public holder_sh(View itemView) {
        super(itemView);


        name_sh=(TextView) itemView.findViewById(R.id.sh);
        img_sh=(ImageView) itemView.findViewById(R.id.logo_sh);
        db= FirebaseDatabase.getInstance().getReference("shoes");
       itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        this.itemClickLisner.onItemClick(this.getLayoutPosition());


    }

    public void setItemClickLisner(ItemClickLisner itemClickLisner) {
        this.itemClickLisner = itemClickLisner;
    }
}
