package com.example.pakkat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.theartofdev.edmodo.cropper.CropImage;

import java.io.FileNotFoundException;
import java.io.InputStream;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;

public class FragmentAdd extends Fragment {


    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    final int IMAGE_ONE = 100;
    final int IMAGE_TWO = 200;
    final int IMAGE_THREE = 300;

    public FragmentAdd() {


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_add, container, false);

        image1 = view.findViewById(R.id.image_1);
        image2 = view.findViewById(R.id.image_2);
        image3 = view.findViewById(R.id.image_3);

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(ActivityCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED |
                        ActivityCompat.checkSelfPermission(getActivity(),
                                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
                {

                    requestPermissions(
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                                    Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            2000);
                }
                else {

                    Intent intent = CropImage.activity()
                            .setAspectRatio(16,9)
                            .getIntent(getContext());

                    startActivityForResult(intent, IMAGE_ONE);
                }
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(ActivityCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED |
                        ActivityCompat.checkSelfPermission(getActivity(),
                                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
                {

                    requestPermissions(
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                                    Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            2000);
                }
                else {

                    Intent intent = CropImage.activity()
                            .setAspectRatio(16,9)
                            .getIntent(getContext());

                    startActivityForResult(intent, IMAGE_TWO);
                }
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(ActivityCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED |
                        ActivityCompat.checkSelfPermission(getActivity(),
                                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
                {

                    requestPermissions(
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                                    Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            2000);
                }
                else {

                    Intent intent = CropImage.activity()
                            .setAspectRatio(16,9)
                            .getIntent(getContext());

                    startActivityForResult(intent, IMAGE_THREE);
                }
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case IMAGE_ONE:

                CropImage.ActivityResult result1 = CropImage.getActivityResult(data);
                if (resultCode == RESULT_OK) {
                    Uri resultUri = result1.getUri();
                    Log.e("resultUri ->", String.valueOf(resultUri));
                    image1.setImageURI(resultUri);
                } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                    Exception error = result1.getError();
                    Log.e("error ->", String.valueOf(error));
                }
            case IMAGE_TWO:
                CropImage.ActivityResult result2 = CropImage.getActivityResult(data);
                if (resultCode == RESULT_OK) {
                    Uri resultUri = result2.getUri();
                    Log.e("resultUri ->", String.valueOf(resultUri));
                    image1.setImageURI(resultUri);
                } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                    Exception error = result2.getError();
                    Log.e("error ->", String.valueOf(error));
                }
                break;
            case IMAGE_THREE:
                CropImage.ActivityResult result3 = CropImage.getActivityResult(data);
                if (resultCode == RESULT_OK) {
                    Uri resultUri = result3.getUri();
                    Log.e("resultUri ->", String.valueOf(resultUri));
                    image1.setImageURI(resultUri);
                } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                    Exception error = result3.getError();
                    Log.e("error ->", String.valueOf(error));
                }
                break;
        }
    }
}