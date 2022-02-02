package com.example.onlineshopping.ui.gallery;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineshopping.KategoriyaRec.AdapterKategoriya;
import com.example.onlineshopping.KategoriyaRec.ModelKategoriya;
import com.example.onlineshopping.R;
import com.example.onlineshopping.mySqlDatabase.CollectionKategoriya;

import java.util.ArrayList;


public class GalleryFragment extends Fragment {

    RecyclerView recyclerView;
    AdapterKategoriya adapterKategoriya;
    GridLayoutManager manager;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        recyclerView = root.findViewById(R.id.recyclekatalog);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        adapterKategoriya=new AdapterKategoriya(getContext(),CollectionKategoriya.getModelKategoriyas());
        recyclerView.setAdapter(adapterKategoriya);


        return root;
    }

}