package com.example.pakkat;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class FragmentHome extends Fragment {
    View view;
    private RecyclerView recyclerView;
    ArrayList<ModelHome> listHome = new ArrayList<>();
    AdapterHome adapterHome;
    Context context;

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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new getJson(getActivity()).execute();
    }

    public class getJson extends AsyncTask<Void,Void,String>{

        Context context;
        public getJson(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... voids) {
            String link_Json = "http://site-baz.ir/app/test.json";
            return JsonParser.GetJson(link_Json);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject object = new JSONObject(s);

                JSONArray pakkat = object.getJSONArray("pakkat");
                for (int i = 0; i<pakkat.length(); i++){
                    JSONObject pakkatobj = pakkat.getJSONObject(i);

                    String title = pakkatobj.getString("title");
                    String loc = pakkatobj.getString("loc");
                    String date = pakkatobj.getString("date");
                    String price = pakkatobj.getString("price");
                    String img = pakkatobj.getString("img");
                    String category = pakkatobj.getString("category");
                    String description = pakkatobj.getString("txt");
                    String phone = pakkatobj.getString("phone");

                    listHome.add(new ModelHome(title,loc,date,price,img,category,description,phone));

                }
                //adapterHome.notifyDataSetChanged();
            }catch (JSONException e){
                Toast.makeText(context, e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }
    }
}
