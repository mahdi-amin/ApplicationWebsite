package com.example.pakkat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterHome extends RecyclerView.Adapter<AdapterHome.MyViewHolder> {

    Context mContext;
    List<ModelHome> mHome;

    public AdapterHome(Context mContext, List<ModelHome> mHome) {

        this.mContext = mContext;
        this.mHome = mHome;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //set View For ViewHolder
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_home, parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.titleTX.setText(mHome.get(position).getTitle());
        holder.locTX.setText(mHome.get(position).getLoc());
        holder.dateTX.setText(mHome.get(position).getDate());
        holder.priceTX.setText(mHome.get(position).getPrice());
        Picasso.get().load(mHome.get(position).getPic()).into(holder.iconIMG);
    }

    @Override
    public int getItemCount() {
        return mHome.size();
    }

    //ViewHolder
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView titleTX, locTX, priceTX, dateTX;
        private ImageView iconIMG;

        public MyViewHolder(@NonNull View view) {
            super(view);

            titleTX = view.findViewById(R.id.title_Home);
            locTX = view.findViewById(R.id.Loc_Home);
            priceTX = view.findViewById(R.id.Price_Home);
            dateTX = view.findViewById(R.id.Date_Home);
            iconIMG = view.findViewById(R.id.Icon_Home);
        }
    }
}
