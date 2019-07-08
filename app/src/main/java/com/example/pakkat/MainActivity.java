package com.example.pakkat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;
    FragmentCategory fragmentCategory;
    FragmentHome fragmentHome;
    FragmentAdd fragmentAdd;
    FragmentMe fragmentMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = findViewById(R.id.Framely);
        bottomNavigationView = findViewById(R.id.bottomNav);
        fragmentAdd = new FragmentAdd();
        fragmentCategory = new FragmentCategory();
        fragmentHome = new FragmentHome();
        fragmentMe = new FragmentMe();
        bottomNavigationView.setSelectedItemId(R.id.item_Home);

        setFragment(fragmentHome);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.item_list:
                        setFragment(fragmentCategory);
                        return true;
                    case R.id.item_add:
                        setFragment(fragmentAdd);
                        return true;
                    case R.id.item_Home:
                        setFragment(fragmentHome);
                        return true;
                    case R.id.item_Me:
                        setFragment(fragmentMe);
                        return true;

                }
                return false;
            }
        });


    }
    public void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.Framely, fragment);
        fragmentTransaction.commit();
    }
}
