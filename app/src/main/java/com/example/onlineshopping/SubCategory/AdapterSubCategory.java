package com.example.onlineshopping.SubCategory;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopping.R;

import java.util.ArrayList;

public class AdapterSubCategory extends RecyclerView.Adapter<HolderSubCategory> {
    ArrayList<ModelSubCategory> modelSubCategories;
    Context c;

    public AdapterSubCategory(ArrayList<ModelSubCategory> modelSubCategories, Context c) {
        this.modelSubCategories = modelSubCategories;
        this.c = c;
    }

    @NonNull
    @Override
    public HolderSubCategory onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recysabcategory, null, false);
        return new HolderSubCategory(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderSubCategory holder, int position) {
        holder.subtextCategory.setText(modelSubCategories.get(position).getNomi());
        holder.SetItemClickListinereSubIn(new ItemClickSubIn() {
            @Override
            public void onItemClickListenerSubIn(View v, int position) {
                Intent intent = new Intent(c, SubCategoryInActivity.class);
                intent.putExtra("kateid", modelSubCategories.get(position).getId());
                c.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return modelSubCategories.size();
    }
}
