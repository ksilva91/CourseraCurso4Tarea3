package com.example.kruger.petagram.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kruger.petagram.R;
import com.example.kruger.petagram.model.Media;
import com.example.kruger.petagram.model.Pet;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Kruger on 27/12/2017.
 */

public class PetGridAdapter extends RecyclerView.Adapter<PetGridAdapter.MediaViewHolder> {
    private ArrayList<Media> mediaArrayList;
    private Activity activity;

    public PetGridAdapter(ArrayList<Media> mediaArrayList, Activity activity) {
        this.mediaArrayList = mediaArrayList;
        this.activity = activity;
    }

    @Override
    public MediaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_list_pet, parent, false);
        return new MediaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MediaViewHolder holder, int position) {
        final Media media = mediaArrayList.get(position);
        Picasso.with(activity)
                .load(media.getUrlPhoto())
                .placeholder(R.drawable.image_not_found)
                .into(holder.ivImage);
        holder.tvMediaRating.setText(String.valueOf(media.getLikes()));
    }

    @Override
    public int getItemCount() {
        return mediaArrayList.size();
    }

    static class MediaViewHolder extends RecyclerView.ViewHolder {

        ImageView ivImage;
        TextView tvMediaRating;

        MediaViewHolder(View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.iv_image);
            tvMediaRating = itemView.findViewById(R.id.tv_rating);
        }
    }
}
