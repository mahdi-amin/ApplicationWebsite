package com.example.pakkat;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class FragmentHome extends Fragment {
    View view;
    private RecyclerView recyclerView;
    ArrayList<ModelHome> listHome = new ArrayList<>();
    AdapterHome HAdapter;
    Button button;
    String search_txt;

    public FragmentHome() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container,false);
        recyclerView = view.findViewById(R.id.HomeRC_id);
        HAdapter = new AdapterHome(getContext(), listHome);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(HAdapter);

        button = view.findViewById(R.id.button_reload);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new getJson(getActivity()).execute();
            }
        });

        final EditText searchfield = view.findViewById(R.id.search_txt);
        searchfield.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keycode, KeyEvent keyEvent) {

                if(keyEvent.getAction() == KeyEvent.ACTION_DOWN){

                    if(keycode == KeyEvent.KEYCODE_ENTER){
                        search_txt = searchfield.getText().toString();
                        new getJson(getActivity()).execute();
                        return true;
                    }
                }
                return false;
            }
        });
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new getJson(getActivity()).execute();
    }

    public class getJson extends AsyncTask<Void,Void,String>{


        ProgressDialog progressDialog = new ProgressDialog(getActivity());
        Context context;
        public getJson(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

                progressDialog.setMessage("در حال بروزرسانی...");
                progressDialog.setCancelable(false);
                progressDialog.show();
        }

        @Override
        protected String doInBackground(Void... voids) {
            String link_Json = "http://site-baz.ir/app/test.json";
            return JsonParser.GetJson(link_Json);
        }

        @Override
        protected void onPostExecute(final String s) {
            super.onPostExecute(s);

            if (progressDialog.isShowing()){
                progressDialog.dismiss();
            }
            try {
                JSONObject object = new JSONObject(s);

                JSONArray Product_array = object.getJSONArray("pakkat");
                if(listHome!=null && listHome.size()>0){
                    listHome.clear();
                }
                for (int i = 0; i<Product_array.length(); i++){

                    JSONObject Product_item = Product_array.getJSONObject(i);

                    String title = Product_item.getString("title");
                    String loc = Product_item.getString("loc");
                    String date = Product_item.getString("date");
                    String price = Product_item.getString("price");
                    JSONArray image = Product_item.getJSONArray("img");
                    String[] img = new String[image.length()];
                    for(int j=0;j<image.length();j++){
                        img[j] = image.getString(j);
                    }
                    String category = Product_item.getString("category");
                    String description = Product_item.getString("txt");
                    String phone = Product_item.getString("phone");
                    String link = Product_item.getString("link");

                    if(search_txt == null){

                        listHome.add(new ModelHome(title,loc,date,price,img,category,description,phone,link));
                    }else{

                        if(title.contains(search_txt)){
                            listHome.add(new ModelHome(title,loc,date,price,img,category,description,phone,link));
                        }
                    }
                }
                search_txt = null;
                HAdapter.notifyDataSetChanged();


            }catch (JSONException e){
                Toast.makeText(context, e.getMessage(),Toast.LENGTH_SHORT).show();
            }catch (Exception e){
                Log.e("log",e.getMessage());
            }
        }

    }

}
