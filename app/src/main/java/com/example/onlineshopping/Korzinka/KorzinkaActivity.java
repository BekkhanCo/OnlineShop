package com.example.onlineshopping.Korzinka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.example.onlineshopping.R;
import com.example.onlineshopping.ui.ShopActivity;

import java.util.ArrayList;

public class KorzinkaActivity extends AppCompatActivity {
    public static Button btnsumma;
    public static double summa;
    RecyclerView recyclerView;
    AdapterKorzinka adapterKorzinka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_korzinka);
        setTitle("Haridlar ro`yhati");

        recyclerView=findViewById(R.id.recyclekorzina);
        recyclerView.setLayoutManager(new GridLayoutManager(KorzinkaActivity.this,1));
        adapterKorzinka=new AdapterKorzinka(KorzinkaActivity.this, ShopActivity.korzinkamahsulotlar);
        recyclerView.setAdapter(adapterKorzinka);

        summa=0;

        ArrayList<ModelKorzinka> modelKorzinkas=ShopActivity.korzinkamahsulotlar;

        for (int i=0;i<modelKorzinkas.size();i++){
            summa+=Double.parseDouble(modelKorzinkas.get(i).getUmumiysumma());
        }
    }
}