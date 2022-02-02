package com.example.onlineshopping.Korzinka;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopping.R;

public class HolderKorzinka extends RecyclerView.ViewHolder implements RecyclerView.OnClickListener {
    TextView mahnomi, narx, umumiysumma, mahsulotsoni;
    ImageView rasm;
    ItemClickListenerplus itemClickListenerplus;
    Button btnminus, btnplus;
    int itemid;

    public HolderKorzinka(@NonNull View itemView) {
        super(itemView);
        itemid = itemView.getId();
        this.mahnomi = itemView.findViewById(R.id.nomikorzina);
        this.narx = itemView.findViewById(R.id.narxikorzina);
        this.umumiysumma = itemView.findViewById(R.id.summakorzina);
        this.rasm = itemView.findViewById(R.id.rasmkorzina);
        this.mahsulotsoni = itemView.findViewById(R.id.mohsulotsonikorzina);
        this.btnminus = itemView.findViewById(R.id.btnminuskorzina);
        this.btnplus = itemView.findViewById(R.id.btnpluskorzina);
        itemView.setOnClickListener(this);
        btnplus.setOnClickListener(this);
        btnminus.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == itemid)
            this.itemClickListenerplus.onItemClickListener(v, getLayoutPosition());
        if (id == R.id.btnminuskorzina)
            this.itemClickListenerplus.onMinusClickListener(getLayoutPosition());
        if (id == R.id.btnpluskorzina)
            this.itemClickListenerplus.onPlusClickListener(getLayoutPosition());

    }

    public void setItemClickListener(ItemClickListenerplus ic) {
        this.itemClickListenerplus = ic;
    }
}
