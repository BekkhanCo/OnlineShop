package com.example.onlineshopping.SubCategory;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopping.R;

public class HolderSubCategory extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView subtextCategory;
    ItemClickSubIn itemClickSubIn;

    public HolderSubCategory(@NonNull View itemView) {
        super(itemView);
        subtextCategory = itemView.findViewById(R.id.subtextkategory);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.itemClickSubIn.onItemClickListenerSubIn(v, getLayoutPosition());

    }

    public void SetItemClickListinereSubIn(ItemClickSubIn ic) {
        this.itemClickSubIn = ic;
    }
}
