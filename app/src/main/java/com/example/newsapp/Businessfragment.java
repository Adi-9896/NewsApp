package com.example.newsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Businessfragment extends Fragment {
    String api = "c4f842a959054b0fb92b4aca90db2c0d";
    ArrayList<Modal> modalArrayList;

    Adapter adapter;

    RecyclerView recyclerViewbusiness;

    private String category = "business";
    String  country ="in";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.businessfragment,null);
        recyclerViewbusiness =  view.findViewById(R.id.business);
        modalArrayList =  new ArrayList<>();
        recyclerViewbusiness.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter =new Adapter(getContext(),modalArrayList);
        recyclerViewbusiness.setAdapter(adapter);
        findnews();

        return view;
    }

    private void findnews() {
        Apputilities.getApiinterface().getcategorynews(country,category,100,api).enqueue(new Callback<Mainnews>() {
            @Override
            public void onResponse(Call<Mainnews> call, Response<Mainnews> response) {
                if (response.isSuccessful()) {
                    modalArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<Mainnews> call, Throwable t) {

            }
        });
    }
}
