package com.example.pakkat;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterHome extends RecyclerView.Adapter<AdapterHome.MyViewHolder> {

    Context mContext;
    List<ModelHome> mHome;
    Dialog dialog;
    FragmentDetail FragmentDetail = new FragmentDetail();

    public AdapterHome(Context mContext, List<ModelHome> mHome) {

        this.mContext = mContext;
        this.mHome = mHome;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {

        //set View For ViewHolder
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_home, parent,false);
        final MyViewHolder viewHolder = new MyViewHolder(view);

        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                view = LayoutInflater.from(mContext).inflate(R.layout.detail_home, parent,false);
                TextView detailTitle = view.findViewById(R.id.detail_title);
                TextView detailTime = view.findViewById(R.id.detail_time);
                TextView detailCategory = view.findViewById(R.id.detail_category);
                TextView detailLoc = view.findViewById(R.id.detail_loc);
                TextView detailPrice = view.findViewById(R.id.detail_price);
                TextView detaildesc = view.findViewById(R.id.detail_description);
                TextView titlebar = view.findViewById(R.id.title_bar);
                ImageView detailImg = view.findViewById(R.id.detail_img);

                detailTitle.setText(mHome.get(viewHolder.getAdapterPosition()).getTitle());
                titlebar.setText(mHome.get(viewHolder.getAdapterPosition()).getTitle());
                detailTime.setText(mHome.get(viewHolder.getAdapterPosition()).getDate());
                detailCategory.setText(mHome.get(viewHolder.getAdapterPosition()).getCategory());
                detailLoc.setText(mHome.get(viewHolder.getAdapterPosition()).getLoc());
                detailPrice.setText(mHome.get(viewHolder.getAdapterPosition()).getPrice());
                detaildesc.setText(mHome.get(viewHolder.getAdapterPosition()).getTxt());
                Picasso.get().load(mHome.get(viewHolder.getAdapterPosition()).getPic()).into(detailImg);

                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.Framely , FragmentDetail)
                        .addToBackStack(null).commit();
            }
        });



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
        private LinearLayout linearLayout;

        public MyViewHolder(@NonNull View view) {
            super(view);

            titleTX = view.findViewById(R.id.title_Home);
            locTX = view.findViewById(R.id.Loc_Home);
            priceTX = view.findViewById(R.id.Price_Home);
            dateTX = view.findViewById(R.id.Date_Home);
            iconIMG = view.findViewById(R.id.Icon_Home);
            linearLayout = view.findViewById(R.id.item_Homely);
        }
    }

}
