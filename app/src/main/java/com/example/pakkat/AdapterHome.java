package com.example.pakkat;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterHome extends RecyclerView.Adapter<AdapterHome.MyViewHolder> {

    Context mContext;
    List<ModelHome> mHome;
    Dialog dialog;

    public AdapterHome(Context mContext, List<ModelHome> mHome) {

        this.mContext = mContext;
        this.mHome = mHome;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //set View For ViewHolder
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_home, parent,false);
        final MyViewHolder viewHolder = new MyViewHolder(view);

        dialog = new Dialog(mContext);
        dialog.setContentView(R.layout.detail_home);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);

        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView detailTitle = dialog.findViewById(R.id.detail_title);
                TextView detailTime = dialog.findViewById(R.id.detail_time);
                TextView detailCategory = dialog.findViewById(R.id.detail_category);
                TextView detailLoc = dialog.findViewById(R.id.detail_loc);
                TextView detailPrice = dialog.findViewById(R.id.detail_price);
                TextView detaildesc = dialog.findViewById(R.id.detail_description);
                ImageView detailImg = dialog.findViewById(R.id.detail_img);

                detailTitle.setText(mHome.get(viewHolder.getAdapterPosition()).getTitle());
                detailTime.setText(mHome.get(viewHolder.getAdapterPosition()).getDate());
                detailCategory.setText(mHome.get(viewHolder.getAdapterPosition()).getCategory());
                detailLoc.setText(mHome.get(viewHolder.getAdapterPosition()).getLoc());
                detailPrice.setText(mHome.get(viewHolder.getAdapterPosition()).getPrice());
                detaildesc.setText(mHome.get(viewHolder.getAdapterPosition()).getTxt());
                Picasso.get().load(mHome.get(viewHolder.getAdapterPosition()).getPic()).into(detailImg);

                dialog.show();
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
