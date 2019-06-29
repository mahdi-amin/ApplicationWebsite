package com.example.pakkat;

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
            public void onClick(View v) {

                String[] data = new String[12];

                data[0] = mHome.get(viewHolder.getAdapterPosition()).getTitle();
                data[1] = mHome.get(viewHolder.getAdapterPosition()).getDate();
                data[2] = mHome.get(viewHolder.getAdapterPosition()).getCategory();
                data[3] = mHome.get(viewHolder.getAdapterPosition()).getLoc();
                data[4] = mHome.get(viewHolder.getAdapterPosition()).getPrice();
                data[5] = mHome.get(viewHolder.getAdapterPosition()).getDescription();
                data[6] = mHome.get(viewHolder.getAdapterPosition()).getImg1();
                data[7] = mHome.get(viewHolder.getAdapterPosition()).getImg2();
                data[8] = mHome.get(viewHolder.getAdapterPosition()).getImg3();
                data[9] = mHome.get(viewHolder.getAdapterPosition()).getImg4();
                data[10] = mHome.get(viewHolder.getAdapterPosition()).getPhone();
                data[11] = mHome.get(viewHolder.getAdapterPosition()).getLink();

                FragmentDetail.setDetail(data);
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
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
        Picasso.get().load(mHome.get(position).getImg1()).into(holder.iconIMG);

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
