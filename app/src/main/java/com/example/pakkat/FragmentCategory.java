package com.example.pakkat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    String url = "https://www.91-img.com/pictures/128557-v5-honor-9n-mobile-phone-large-1.jpg";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listcategory = new ArrayList<>();
        listcategory.add(new ModelCategory("موبایل"));
        listcategory.add(new ModelCategory("کامپیوتر"));
        listcategory.add(new ModelCategory("تلویزیون"));
        listcategory.add(new ModelCategory("سیستم"));
        listcategory.add(new ModelCategory("بخاری"));
        listcategory.add(new ModelCategory("ماشین"));
    }
}
