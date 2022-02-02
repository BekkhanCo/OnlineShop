package com.example.onlineshopping.subCategoryin;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopping.R;

public class HolderSubCategoryIn extends RecyclerView.ViewHolder {
    ImageView imageViewsubin;
    TextView tovarnomisubin, mahsulotsanasisubin, narxmahsulotsubin;

    public HolderSubCategoryIn(@NonNull View itemView) {
        super(itemView);
        this.imageViewsubin = itemView.findViewById(R.id.rasmmahsulot);
        this.tovarnomisubin = itemView.findViewById(R.id.tovarnomi);
        this.mahsulotsanasisubin = itemView.findViewById(R.id.markamahsulot);
        this.narxmahsulotsubin = itemView.findViewById(R.id.narxmahsulot);
    }
}
