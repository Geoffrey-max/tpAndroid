package com.ynov.tpandroid.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ynov.tpandroid.bo.Ville;

import java.util.ArrayList;

public class ListVilleFragmentViewModel extends ViewModel {
    MutableLiveData<ArrayList<Ville>> arrayListVille;

    public MutableLiveData<ArrayList<Ville>> getArrayListVille() {
        if(arrayListVille == null){
            this.arrayListVille = new MutableLiveData<>(new ArrayList<>());
        }
        return arrayListVille;
    }
}
