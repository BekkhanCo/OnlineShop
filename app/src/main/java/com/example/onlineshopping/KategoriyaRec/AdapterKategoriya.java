package com.example.onlineshopping.KategoriyaRec;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopping.R;
import com.example.onlineshopping.SubCategory.AdapterSubCategory;
import com.example.onlineshopping.mySqlDatabase.CollectionSubCategory;

import java.util.ArrayList;

public class AdapterKategoriya extends RecyclerView.Adapter<HolderKategoriya> {
    Context c;
    ArrayList<ModelKategoriya> modelKategoriyas;

    public AdapterKategoriya(Context c, ArrayList<ModelKategoriya> modelKategoriyas) {
        this.c = c;
        this.modelKategoriyas = modelKategoriyas;
    }

    @NonNull
    @Override
    public HolderKategoriya onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardcategory, null, false);
        return new HolderKategoriya(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final HolderKategoriya holder, int position) {
        holder.txtnomi.setText(modelKategoriyas.get(position).getNomi());
        if (modelKategoriyas.get(position).getRasmi() != null) {
            byte[] rasm = modelKategoriyas.get(position).getRasmi();
            Bitmap bitmap = BitmapFactory.decodeByteArray(rasm, 0, rasm.length);
            holder.imageView.setImageBitmap(bitmap);
        } else {
            holder.imageView.setImageResource(R.mipmap.korzina);
        }
        holder.SetonnClickListener(new itemClickListener() {
            @Override
            public void onClickListener(View v, int position) {
                supOl(holder.recyclerView, position + 1);
                if (holder.constraintLayout.getVisibility() == View.VISIBLE) {
                    holder.constraintLayout.setVisibility(View.GONE);
                } else {
                    holder.constraintLayout.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return modelKategoriyas.size();
    }

    private void supOl(RecyclerView recyclerView, int position) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(c, 1);
        AdapterSubCategory adapterSubCategory = new AdapterSubCategory(CollectionSubCategory.getModelSubCategory(position), c);
        recyclerView.setAdapter(adapterSubCategory);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        adapterSubCategory.notifyDataSetChanged();
    }
}
