package com.example.onlineshopping.KategoriyaRec;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopping.R;

public class HolderKategoriya extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView txtnomi;
    ImageView imageView;
    itemClickListener ItemClickListener;
    RecyclerView recyclerView;
    ConstraintLayout constraintLayout;

    public HolderKategoriya(@NonNull View itemView) {
        super(itemView);
        this.txtnomi = itemView.findViewById(R.id.nomikatalog);
        this.imageView = itemView.findViewById(R.id.rasmkatalog);
        recyclerView = itemView.findViewById(R.id.recysubcategory);
        constraintLayout = itemView.findViewById(R.id.con);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.ItemClickListener.onClickListener(v, getLayoutPosition());


    }

    public void SetonnClickListener(itemClickListener ic) {
        this.ItemClickListener = ic;
    }
}
