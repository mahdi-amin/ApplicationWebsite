package com.example.pakkat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FragmentDetail extends Fragment {

    String[] detail = new String[7];

    public void setDetail(String[] detail) {
        this.detail = detail;
    }

    public FragmentDetail() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.detail_home,container,false);

        TextView titleTX = view.findViewById(R.id.detail_title);
        TextView titlebar = view.findViewById(R.id.title_bar);
        TextView dateTX = view.findViewById(R.id.detail_time);
        TextView categoryTX = view.findViewById(R.id.detail_category);
        TextView locTX = view.findViewById(R.id.detail_loc);
        TextView priceTX = view.findViewById(R.id.detail_price);
        TextView descriptionTX = view.findViewById(R.id.detail_description);
        ImageView img = view.findViewById(R.id.detail_img);

        titlebar.setText(detail[0]);
        titleTX.setText(detail[0]);
        dateTX.setText(detail[1]);
        categoryTX.setText(detail[2]);
        locTX.setText(detail[3]);
        priceTX.setText(detail[4]);
        descriptionTX.setText(detail[5]);
        Picasso.get().load(detail[6]).into(img);

        return view;
    }
}
