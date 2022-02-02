package com.example.onlineshopping.nestedview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopping.CategoryItem.AdapterCategoryItem;
import com.example.onlineshopping.R;
import com.example.onlineshopping.mySqlDatabase.CollectionMahsulot;

import java.util.ArrayList;

public class AdapterAllCategory extends RecyclerView.Adapter<AdapterAllCategory.HolderAllCategory> {
    private Context context;
    ArrayList<ModelAllCategory> modelAllCategories;

    public AdapterAllCategory(Context context, ArrayList<ModelAllCategory> modelAllCategories) {
        this.context = context;
        this.modelAllCategories = modelAllCategories;
    }

    @NonNull
    @Override
    public HolderAllCategory onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HolderAllCategory(LayoutInflater.from(context).inflate(R.layout.main_recycler_row_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HolderAllCategory holder, int position) {
        holder.categoryTitle.setText(modelAllCategories.get(position).getNomi());
        holder.itemRecycler.setLayoutManager(new GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false));
        AdapterCategoryItem adapterCategoryItem = new AdapterCategoryItem(context, CollectionMahsulot.getModelCategoryItems(modelAllCategories.get(position).getId()));
        holder.itemRecycler.setAdapter(adapterCategoryItem);
        holder.itemRecycler.setHasFixedSize(true);
        adapterCategoryItem.notifyDataSetChanged();
        // Log.i("teste",""+CollectionMahsulot.getModelCategoryItems(modelAllCategories.get(position).getId()).size());
    }

    @Override
    public int getItemCount() {
        return modelAllCategories.size();
    }


    public static final class HolderAllCategory extends RecyclerView.ViewHolder {

        TextView categoryTitle;
        RecyclerView itemRecycler;


        public HolderAllCategory(@NonNull View itemView) {
            super(itemView);
            categoryTitle = itemView.findViewById(R.id.cat_title);
            itemRecycler = itemView.findViewById(R.id.itemrecycler);


        }
    }


}
