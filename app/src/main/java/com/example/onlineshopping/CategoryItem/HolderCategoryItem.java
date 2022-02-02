package com.example.onlineshopping.CategoryItem;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopping.R;

public class HolderCategoryItem extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView imageView;
    TextView tovarnomi, mahsulotsanasi, narxmahsulot;
    ItemClick itemClick;

    public HolderCategoryItem(@NonNull View itemView) {
        super(itemView);
        this.imageView = itemView.findViewById(R.id.item_image);
        this.tovarnomi = itemView.findViewById(R.id.tovarnomi);
        this.mahsulotsanasi = itemView.findViewById(R.id.mahsulotsanasi);
        this.narxmahsulot = itemView.findViewById(R.id.narxmahsulot);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.itemClick.OnClickM(v, getLayoutPosition());
    }

    public void OnClickListenere(ItemClick ic) {
        this.itemClick = ic;
    }
}
