package com.outerspace.ondotlv.view;

import java.util.ArrayList;

import com.bumptech.glide.Glide;
import com.outerspace.ondotlv.R;
import com.outerspace.ondotlv.model.TwoPictureURL;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class PixabayListAdapter extends RecyclerView.Adapter<PixabayListAdapter.PixabayViewHolder> {
    ArrayList<TwoPictureURL> twoPicList;

    public PixabayListAdapter(ArrayList<TwoPictureURL> twoPicList) {
        this.twoPicList = twoPicList;
    }

    @NonNull
    @Override
    public PixabayListAdapter.PixabayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pixabay_hit_item_layout, parent, false);
        PixabayViewHolder holder = new PixabayViewHolder(view);
        holder.context = parent.getContext();
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PixabayListAdapter.PixabayViewHolder holder, int position) {
        TwoPictureURL twoPic = twoPicList.get(position);
        Glide.with(holder.context)
                .load(twoPic.RightPictureURL)
                .into(holder.imageRight);
        Glide.with(holder.context)
                .load(twoPic.LeftPictureURL)
                .into(holder.imageLeft);
    }

    @Override
    public int getItemCount() {
        return twoPicList.size();
    }

    public class PixabayViewHolder extends ViewHolder {
        public ImageView imageRight;
        public ImageView imageLeft;
        public Context context;

        public PixabayViewHolder(View itemView) {
            super(itemView);
            imageRight = (ImageView) itemView.findViewById(R.id.image_right);
            imageLeft = (ImageView) itemView.findViewById(R.id.image_left);
        }
    }
}
