package com.example.engahmed.mitchamr.clothes.children;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.engahmed.mitchamr.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Eng Ahmed on 02/06/2017.
 */

public class holder_ch extends RecyclerView.ViewHolder implements View.OnClickListener{

    ItemClickLisner itemClickLisner;
    TextView name_chi;
    ImageView  img_chi;
    DatabaseReference db;



    public holder_ch(View itemView) {
        super(itemView);

        name_chi=(TextView) itemView.findViewById(R.id.namechi);

        img_chi=(ImageView) itemView.findViewById(R.id.imgchi);
        //db= FirebaseDatabase.getInstance().getReference("market_children");

    }


    public void setItemClickLisner(ItemClickLisner itemClickLisner) {
        this.itemClickLisner = itemClickLisner;
    }

    @Override
    public void onClick(View v) {

        this.itemClickLisner.onItemClick(this.getLayoutPosition());
    }
}
