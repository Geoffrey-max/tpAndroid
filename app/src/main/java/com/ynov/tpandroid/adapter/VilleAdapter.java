package com.ynov.tpandroid.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.ynov.tpandroid.R;
import com.ynov.tpandroid.bo.Ville;
import com.ynov.tpandroid.databinding.RowLayoutVilleBinding;

import java.util.ArrayList;

public class VilleAdapter extends RecyclerView.Adapter<VilleHolder> {
    ArrayList<Ville> villeArrayList;

    public VilleAdapter() { villeArrayList = new ArrayList<>();}

    public void setVilleArrayList(ArrayList<Ville> villeArrayList) {
        this.villeArrayList = villeArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VilleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowLayoutVilleBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.row_layout_ville,
                parent,
                false
        );
        return new VilleHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull VilleHolder holder, int position) {
        Ville ville = villeArrayList.get(position);
        holder.binding.setVille(ville);
        Picasso.get().load("https://flutter-learning.mooo.com" + ville.getPic().getUrl()).resize(50, 50).into(holder.binding.imageView);
    }

    @Override
    public int getItemCount() {
        return villeArrayList.size();
    }

}
