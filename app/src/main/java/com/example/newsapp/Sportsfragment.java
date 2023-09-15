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

public class Sportsfragment extends Fragment {
    String api = "c4f842a959054b0fb92b4aca90db2c0d";
    ArrayList<Modal> modalArrayList;

    Adapter adapter;

    RecyclerView recyclerViewsports;

    private String category = "sports";
    String  country ="in";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sportsfragment,null);
        recyclerViewsports =  view.findViewById(R.id.recyclerviewofsports);
        modalArrayList =  new ArrayList<>();
        recyclerViewsports.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter =new Adapter(getContext(),modalArrayList);
        recyclerViewsports.setAdapter(adapter);
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
