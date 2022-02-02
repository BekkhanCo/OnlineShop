package com.example.onlineshopping.CategoryItem;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopping.R;

import java.util.ArrayList;


public class AdapterCategoryItem extends RecyclerView.Adapter<HolderCategoryItem> {
    Context c;
    ArrayList<ModelCategoryItem> modelCategoryItems;

    public AdapterCategoryItem(Context c, ArrayList<ModelCategoryItem> modelCategoryItems) {
        this.c = c;
        this.modelCategoryItems = modelCategoryItems;
    }

    @NonNull
    @Override
    public HolderCategoryItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_row_items, null, false);
        return new HolderCategoryItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderCategoryItem holder, int position) {
        if (modelCategoryItems.get(position).getRasm() != null) {
            byte[] rasm = modelCategoryItems.get(position).getRasm();
            Bitmap bitmap = BitmapFactory.decodeByteArray(rasm, 0, rasm.length);
            holder.imageView.setImageBitmap(bitmap);
        } else {
            holder.imageView.setImageResource(R.mipmap.korzina);
        }
        holder.tovarnomi.setText(modelCategoryItems.get(position).getNomi());
        holder.narxmahsulot.setText(modelCategoryItems.get(position).getNarxi() + "so'm");
        holder.mahsulotsanasi.setText(modelCategoryItems.get(position).getSanasi());
        holder.OnClickListenere(new ItemClick() {
            @Override
            public void OnClickM(View v, int position) {
                Intent intent = new Intent(v.getContext(), MahsulotActivity.class);
                intent.putExtra("modelid", modelCategoryItems.get(position).getMarka_id());
                intent.putExtra("rasm", modelCategoryItems.get(position).getRasm());
                intent.putExtra("tovar", modelCategoryItems.get(position).getNomi());
                intent.putExtra("narx", modelCategoryItems.get(position).getNarxi());
                v.getContext().startActivity(intent);


            }

        });

    }

    @Override
    public int getItemCount() {
        return modelCategoryItems.size();
    }

}
