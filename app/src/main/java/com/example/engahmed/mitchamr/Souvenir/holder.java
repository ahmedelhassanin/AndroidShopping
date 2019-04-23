package com.example.engahmed.mitchamr.Souvenir;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.engahmed.mitchamr.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Eng Ahmed on 03/06/2017.
 */

public class holder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView name;
    ImageView img;
    ItemClickLisner itemClickLisner;
    DatabaseReference db;




    public holder(View itemView) {
        super(itemView);
        name=(TextView) itemView.findViewById(R.id.name_souv);
        img=(ImageView)  itemView.findViewById(R.id.souvenir);
       db= FirebaseDatabase.getInstance().getReference("souvenir");
        itemView.setOnClickListener(this);

    }


    public void setItemClickLisner(ItemClickLisner itemClickLisner) {
        this.itemClickLisner = itemClickLisner;
    }

    @Override
    public void onClick(View v) {

        this.itemClickLisner.onItemClick(this.getLayoutPosition());

    }
}
