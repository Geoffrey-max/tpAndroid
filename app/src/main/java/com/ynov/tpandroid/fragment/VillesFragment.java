package com.ynov.tpandroid.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ynov.tpandroid.R;
import com.ynov.tpandroid.adapter.VilleAdapter;
import com.ynov.tpandroid.bo.Ville;
import com.ynov.tpandroid.viewmodel.ListVilleFragmentViewModel;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class VillesFragment extends Fragment {
    OkHttpClient client;
    private static final String TAG = "ListeVilles";
    private RecyclerView rv;
    private VilleAdapter adapter;
    private ListVilleFragmentViewModel vm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        client = new OkHttpClient();
        vm = new ViewModelProvider(this).get(ListVilleFragmentViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_villes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        initializeVilles();
        Observer<ArrayList<Ville>> observerList = villes -> {
            adapter.setVilleArrayList(villes);
        };
        vm.getArrayListVille().observe(getViewLifecycleOwner(), observerList);
        if(vm.getArrayListVille().getValue().isEmpty()){
            fetchVilles();
        }
        super.onViewCreated(view, savedInstanceState);
    }

    public void fetchVilles(){
        Request requestMsg = new Request.Builder()
                .url("https://flutter-learning.mooo.com/villes")
                .build();
        client.newCall(requestMsg).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.e(TAG, "onFailure: récupération" + e.getMessage());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String body = response.body().string();
                Log.i(TAG, "onResponse: " + body);
                ArrayList<Ville> alVilles = new Gson().fromJson(
                        body,
                        new TypeToken<ArrayList<Ville>>(){}.getType()
                );
                vm.getArrayListVille().postValue(alVilles);
            }
        });

    }

    private void initializeVilles(){
        rv = getView().findViewById(R.id.recyclerView);
        adapter = new VilleAdapter();
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(adapter);
    }
}