package com.example.engahmed.mitchamr.clothes.man;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.engahmed.mitchamr.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Eng Ahmed on 31/05/2017.
 */

public class holder_man extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView market_name;
    ImageView imagelogo;
    ItemClickLisner itemClickLisner;
    DatabaseReference db;


    public holder_man(View itemView) {
        super(itemView);

        market_name=(TextView) itemView.findViewById(R.id.man);
        imagelogo=(ImageView) itemView.findViewById(R.id.logo_man);
        db= FirebaseDatabase.getInstance().getReference("market_man");





    }

    public void setItemClickLisner(ItemClickLisner itemClickLisner) {
        this.itemClickLisner = itemClickLisner;
    }

    @Override
    public void onClick(View v) {
        this.itemClickLisner.onItemClick(this.getLayoutPosition());
    }
}
