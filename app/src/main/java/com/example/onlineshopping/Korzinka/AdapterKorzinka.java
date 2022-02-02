package com.example.onlineshopping.Korzinka;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopping.R;

import java.util.ArrayList;

public class AdapterKorzinka extends RecyclerView.Adapter<HolderKorzinka> {
    Context c;
    ArrayList<ModelKorzinka> modelKorzinkas;

    public AdapterKorzinka(Context c, ArrayList<ModelKorzinka> modelKorzinkas) {
        this.c = c;
        this.modelKorzinkas = modelKorzinkas;
    }

    @NonNull
    @Override
    public HolderKorzinka onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardkorzinka, null, false);
        return new HolderKorzinka(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final HolderKorzinka holder, int position) {
        holder.mahnomi.setText(modelKorzinkas.get(position).getMahsulotNomi());
        holder.narx.setText(modelKorzinkas.get(position).getNarxi() + " so`m dona");
        holder.umumiysumma.setText(modelKorzinkas.get(position).getUmumiysumma());
        holder.mahsulotsoni.setText(modelKorzinkas.get(position).getMahsulotsoni() + "");

        if (modelKorzinkas.get(position).getRasm() != null) {
            byte[] rasm = modelKorzinkas.get(position).getRasm();
            Bitmap bitmap = BitmapFactory.decodeByteArray(rasm, 0, rasm.length);
            holder.rasm.setImageBitmap(bitmap);
        } else {

            holder.rasm.setImageResource(R.mipmap.korzina);

        }
        holder.setItemClickListener(new ItemClickListenerplus() {
            @Override
            public void onItemClickListener(View v, int position) {


            }

            @Override
            public void onMinusClickListener(int position) {
                int soni = modelKorzinkas.get(position).getMahsulotsoni();
                double narxi = Double.parseDouble(modelKorzinkas.get(position).getNarxi());
                if (soni <= 0) {
                    Toast.makeText(c, "stop", Toast.LENGTH_SHORT).show();

                } else {
                    soni--;
                    double summa = Double.parseDouble(modelKorzinkas.get(position).getUmumiysumma());
                    summa = narxi * soni;


                    modelKorzinkas.get(position).setUmumiysumma(summa + "");
                    modelKorzinkas.get(position).setMahsulotsoni(soni);
                    holder.mahsulotsoni.setText(soni + "");
                    holder.umumiysumma.setText((summa) + "");


                }

            }

            @Override
            public void onPlusClickListener(int position) {
                int soni = modelKorzinkas.get(position).getMahsulotsoni();
                double narxi = Double.parseDouble(modelKorzinkas.get(position).getNarxi());
                soni++;
                double summa = Double.parseDouble(modelKorzinkas.get(position).getUmumiysumma());

                summa = narxi * soni;


                modelKorzinkas.get(position).setUmumiysumma(summa + "");
                modelKorzinkas.get(position).setMahsulotsoni(soni);
                holder.mahsulotsoni.setText(soni + "");
                holder.umumiysumma.setText((summa) + "");

            }
        });


    }

    @Override
    public int getItemCount() {
        return modelKorzinkas.size();
    }
}
