package com.group4.kidomtoystore.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.group4.kidomtoystore.Models.BannerHome;
import com.group4.kidomtoystore.R;

import java.util.ArrayList;

public class BannerHomeAdapter extends RecyclerView.Adapter<BannerHomeAdapter.ViewHolder>{
    Context context;
    ArrayList<BannerHome> bannerlists;

    public BannerHomeAdapter(Context context, ArrayList<BannerHome> bannerlists) {
        this.context = context;
        this.bannerlists = bannerlists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_banner,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imvBanner.setImageResource(bannerlists.get(position).getBannerImage());

    }

    @Override
    public int getItemCount() {
        return bannerlists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imvBanner;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imvBanner = itemView.findViewById(R.id.imvBanner);
        }
    }
}
