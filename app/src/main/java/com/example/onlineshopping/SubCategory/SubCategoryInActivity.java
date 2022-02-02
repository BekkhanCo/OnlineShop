package com.example.onlineshopping.SubCategory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.onlineshopping.CategoryItem.AdapterCategoryItem;
import com.example.onlineshopping.R;
import com.example.onlineshopping.mySqlDatabase.CollectionMahsulot;
import com.example.onlineshopping.mySqlDatabase.CollectionSubCategory;
import com.example.onlineshopping.mySqlDatabase.CollectionSubCategoryIn;
import com.example.onlineshopping.nestedview.AdapterAllCategory;
import com.example.onlineshopping.subCategoryin.AdapterSubCategoryIn;
import com.example.onlineshopping.subCategoryin.ModelSubCategoryIn;

import java.util.ArrayList;

public class SubCategoryInActivity extends AppCompatActivity {
    Context context;
    RecyclerView recyclerView;
    AdapterSubCategoryIn adapterSubCategoryIn;
    ArrayList<ModelSubCategory> modelSubCategories;
    GridLayoutManager manager;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        int id = intent.getIntExtra("kateid", -1);
        setContentView(R.layout.activity_sub_category_in);
        recyclerView = findViewById(R.id.recysubcategoryin);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
        adapterSubCategoryIn = new AdapterSubCategoryIn(context, CollectionSubCategoryIn.getModelSubCategoryIns(id));
        recyclerView.setAdapter(adapterSubCategoryIn);

    }
}