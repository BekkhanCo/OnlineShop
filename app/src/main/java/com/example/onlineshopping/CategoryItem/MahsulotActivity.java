package com.example.onlineshopping.CategoryItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onlineshopping.Korzinka.ModelKorzinka;
import com.example.onlineshopping.R;
import com.example.onlineshopping.mySqlDatabase.CollectionMahsulot;
import com.example.onlineshopping.nestedview.AdapterAllCategory;
import com.example.onlineshopping.ui.ShopActivity;

import java.util.ArrayList;

public class MahsulotActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView rasmmahoyna;
    TextView txttovar, txtmarka, txtsumma, txtumumiysumma;
    EditText edtsoni;
    Button btnplus, btnminus, btnkorzinagaqosh;
    private int mahsulotsoni = 1;
    private double summa;
    private int modelid;
    RecyclerView recyclerView;
    ModelKorzinka modelKorzinka;
    ModelCategoryItem modelCategoryItem;
    Context context;
    GridLayoutManager manager;
    AdapterCategoryItem adapterCategoryItem;
    byte[] rasm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahsulot);
        rasmmahoyna = findViewById(R.id.rasmmahsulotoyna);
        txttovar = findViewById(R.id.tovarmahoyna);
        txtsumma = findViewById(R.id.narxmahoyna);
        txtumumiysumma = findViewById(R.id.umumiysumma);
        edtsoni = findViewById(R.id.summahsoni);
        btnplus = findViewById(R.id.btnplus);
        btnminus = findViewById(R.id.btnminus);
        btnkorzinagaqosh = findViewById(R.id.btnkorzinagaqosh);
        btnplus.setOnClickListener(this);
        btnminus.setOnClickListener(this);
        btnkorzinagaqosh.setOnClickListener(this);

        edtsoni.setSelection(edtsoni.getText().length());
        Intent intent = getIntent();
        modelid = intent.getIntExtra("modelid", 0);
        String tovarnomi = intent.getStringExtra("tovar");
        String marka = intent.getStringExtra("marka");
        Double narxi = (intent.getDoubleExtra("narx", 0));
        rasm = intent.getByteArrayExtra("rasm");
        if (rasm == null) {
            rasmmahoyna.setImageResource(R.mipmap.imgdefault);
        } else {
            Bitmap bitmap = BitmapFactory.decodeByteArray(rasm, 0, rasm.length);
            rasmmahoyna.setImageBitmap(bitmap);
        }
        txttovar.setText(tovarnomi);
        txtsumma.setText(narxi + "");
        setTitle(marka);
        edtsoni.setText(mahsulotsoni + "");
        edtsoni.setSelection(edtsoni.getText().length());
        summa = narxi;
        txtumumiysumma.setText(summa * mahsulotsoni + "");
        recyclerView = findViewById(R.id.recyclikemah);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
        AdapterCategoryItem adapterCategoryItem = new AdapterCategoryItem(context, CollectionMahsulot.getModelCategoryItems(modelid));
        recyclerView.setAdapter(adapterCategoryItem);

    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        switch (id) {
            case R.id.btnplus:
                mahsulotsoni++;
                edtsoni.setText(mahsulotsoni + "");
                edtsoni.setSelection(edtsoni.getText().length());
                Double narx = new Double(mahsulotsoni * summa);
                txtumumiysumma.setText((narx) + "");
                break;
            case R.id.btnminus:
                if (mahsulotsoni <= 0) {
                    Toast.makeText(this, "stop", Toast.LENGTH_SHORT).show();
                    break;
                }
                mahsulotsoni--;
                edtsoni.setText(mahsulotsoni + "");
                edtsoni.setSelection(edtsoni.getText().length());
                Double narx1 = new Double(mahsulotsoni * summa);
                txtumumiysumma.setText((narx1) + "");
                break;
            case R.id.btnkorzinagaqosh:
                ArrayList<ModelKorzinka> modelKorzinkas = ShopActivity.korzinkamahsulotlar;
                boolean A = true;
                for (int i = 0; i < modelKorzinkas.size(); i++) {
                    if (modelKorzinkas.get(i).getModel_id() == modelid) {
                        modelKorzinka = modelKorzinkas.get(i);
                        A = false;
                        break;
                    }
                }
                if (A)
                    modelKorzinka = new ModelKorzinka();
                modelKorzinka.setModel_id(modelid);
                modelKorzinka.setNarxi(summa + "");
                modelKorzinka.setUmumiysumma(txtumumiysumma.getText().toString());
                modelKorzinka.setRasm(rasm);
                modelKorzinka.setMahsulotsoni(mahsulotsoni);
                Toast.makeText(this, "korzinkaga qo`shildi", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MahsulotActivity.this, ShopActivity.class);
                startActivity(intent);
                if (A) {
                    ShopActivity.korzinkamahsulotlar.add(modelKorzinka);
                }
                break;


        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}