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

public class FragmentHome extends Fragment {
    View view;
    private RecyclerView recyclerView;
    private List<ModelHome> listHome;

    public FragmentHome() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container,false);
        recyclerView = view.findViewById(R.id.HomeRC_id);
        AdapterHome HAdapter = new AdapterHome(getContext(), listHome);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(HAdapter);

        return view;
    }

    String url = "https://www.91-img.com/pictures/128557-v5-honor-9n-mobile-phone-large-1.jpg";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listHome = new ArrayList<>();
        listHome.add(new ModelHome("گوشی موبایل","تهران","1395","2 میلیون ", url));
        listHome.add(new ModelHome("ماشین","آبادان","1803","۸۰ میلیون ", url));
        listHome.add(new ModelHome("گوشی خانه","تبریز","1356","100 هزار", url));
        listHome.add(new ModelHome("یخچال","تهران","1395","2 میلیون ", url));
        listHome.add(new ModelHome("گاز","مکه","2200","2 00 ", url));
        listHome.add(new ModelHome("گوشی موبایل","تهران","1395","33 میلیون ", url));
    }
}
