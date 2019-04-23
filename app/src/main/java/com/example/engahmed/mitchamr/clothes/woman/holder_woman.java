package com.example.engahmed.mitchamr.clothes.woman;

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

public class holder_woman extends RecyclerView.ViewHolder implements View.OnClickListener {

    Itemclick_wo itemclick_wo;
    TextView textViewname;
    ImageView imgwoman;
    DatabaseReference db;


    public holder_woman(View itemView) {
        super(itemView);
        textViewname=(TextView) itemView.findViewById(R.id.textoffer);
        imgwoman=(ImageView) itemView.findViewById(R.id.imagewoman);
        db= FirebaseDatabase.getInstance().getReference("market_woman");

    }


    public void setItemclick_wo(Itemclick_wo itemclick_wo) {
        this.itemclick_wo = itemclick_wo;
    }

    @Override
    public void onClick(View v) {
        this.itemclick_wo.onItemClick(this.getLayoutPosition());

    }
}
