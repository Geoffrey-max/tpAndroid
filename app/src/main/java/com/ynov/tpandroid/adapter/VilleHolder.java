package com.ynov.tpandroid.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ynov.tpandroid.databinding.RowLayoutVilleBinding;

public class VilleHolder extends RecyclerView.ViewHolder {
    RowLayoutVilleBinding binding;

    public VilleHolder(@NonNull RowLayoutVilleBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
