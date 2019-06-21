package com.example.pakkat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterCategory extends RecyclerView.Adapter<AdapterCategory.MyViewHolder> {

    Context mContext;
    List<ModelCategory> mCategory;

    public AdapterCategory(Context mContext, List<ModelCategory> mCategory) {

        this.mContext = mContext;
        this.mCategory = mCategory;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //set View For ViewHolder
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_category, parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.titleTX.setText(mCategory.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mCategory.size();
    }

    //ViewHolder
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView titleTX;

        public MyViewHolder(@NonNull View view) {
            super(view);

            titleTX = view.findViewById(R.id.title_category);
        }
    }
}
