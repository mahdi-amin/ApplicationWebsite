package com.example.pakkat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FragmentDetail extends Fragment {

    String[] detail = new String[8];

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
        TextView linkTX = view.findViewById(R.id.link_web);
        ImageView img = view.findViewById(R.id.detail_img);
        Button callbtn = view.findViewById(R.id.button_call);

        titlebar.setText(detail[0]);
        titleTX.setText(detail[0]);
        dateTX.setText(detail[1]);
        categoryTX.setText(detail[2]);
        locTX.setText(detail[3]);
        priceTX.setText(detail[4]);
        descriptionTX.setText(detail[5]);
        Picasso.get().load(detail[6]).into(img);

        Spanned Text = Html.fromHtml("<a href='https:/"+detail[8]+"'>"+detail[8]+"</a>");
        linkTX.setMovementMethod(LinkMovementMethod.getInstance());
        linkTX.setText(Text);


        callbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{Manifest.permission.CALL_PHONE},
                            1);
                } else {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    String number = detail[7];
                    callIntent.setData(Uri.parse("tel: " + number));
                    startActivity(callIntent);
                }
            }
        });

        return view;
    }
}
