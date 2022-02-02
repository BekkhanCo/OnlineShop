package com.example.onlineshopping.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopping.CategoryItem.AdapterCategoryItem;
import com.example.onlineshopping.R;
import com.example.onlineshopping.mySqlDatabase.CollectionMahsulot;
import com.example.onlineshopping.nestedview.AdapterAllCategory;


public class HomeFragment extends Fragment {
    Context context;
    RecyclerView recyclerView, recycler;
    AdapterAllCategory adapterAllCategory;
    AdapterCategoryItem adapterCategoryItem;
    GridLayoutManager manager;
    LinearLayoutManager linearLayoutManager;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = root.findViewById(R.id.main_recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        adapterAllCategory = new AdapterAllCategory(getContext(), CollectionMahsulot.getmodelAllCategories());
        recyclerView.setAdapter(adapterAllCategory);


        return root;
    }
}