package com.example.onlineshopping.subCategoryin;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopping.R;

import java.util.ArrayList;

public class AdapterSubCategoryIn extends RecyclerView.Adapter<HolderSubCategoryIn> {
    Context c;
    ArrayList<ModelSubCategoryIn> modelSubCategoryIns;

    public AdapterSubCategoryIn(Context c, ArrayList<ModelSubCategoryIn> modelSubCategoryIns) {
        this.c = c;
        this.modelSubCategoryIns = modelSubCategoryIns;
    }

    @NonNull
    @Override
    public HolderSubCategoryIn onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardmahsulot, null, false);
        return new HolderSubCategoryIn(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderSubCategoryIn holder, int position) {
        if (modelSubCategoryIns.get(position).getRasmi() != null) {
            byte[] rasm = modelSubCategoryIns.get(position).getRasmi();
            Bitmap bitmap = BitmapFactory.decodeByteArray(rasm, 0, rasm.length);
            holder.imageViewsubin.setImageBitmap(bitmap);
        } else {
            holder.imageViewsubin.setImageResource(R.mipmap.korzina);
        }
        holder.tovarnomisubin.setText(modelSubCategoryIns.get(position).getNomi());
        holder.narxmahsulotsubin.setText(modelSubCategoryIns.get(position).getNarxi() + "");
        holder.mahsulotsanasisubin.setText(modelSubCategoryIns.get(position).getSana());
    }

    @Override
    public int getItemCount() {
        return modelSubCategoryIns.size();
    }
}
