package com.example.pakkat;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FragmentCategory extends Fragment {
    View view;
    private RecyclerView recyclerView;
    private List<ModelCategory> listcategory;

    public FragmentCategory() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_category, container,false);
        recyclerView = view.findViewById(R.id.CategoryRC_id);
        AdapterCategory CAdapter = new AdapterCategory(getContext(), listcategory);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(CAdapter);

        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listcategory.add(new ModelCategory("اتوبوس"));
        listcategory.add(new ModelCategory("ماشین"));
        listcategory.add(new ModelCategory("وسایل نقلیه"));
        listcategory.add(new ModelCategory("فروش غذا"));
        listcategory.add(new ModelCategory("حسابداری"));
        listcategory.add(new ModelCategory("بازرگانی"));
        listcategory.add(new ModelCategory("بازاریابی"));
        listcategory.add(new ModelCategory("کاریابی"));
        listcategory.add(new ModelCategory("استخدام"));
        listcategory.add(new ModelCategory("لباسشویی"));
        listcategory.add(new ModelCategory("یخچال"));
        listcategory.add(new ModelCategory("کامپیوتر"));
        listcategory.add(new ModelCategory("موبایل"));
    }
}
