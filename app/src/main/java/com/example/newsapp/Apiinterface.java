package com.example.newsapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Apiinterface {
    String BASEURL ="https://newsapi.org/v2/";
    @GET("top-headlines")
    Call<Mainnews> getnews(
            @Query("country")String country,
            @Query("pageSize") int pageSize,
            @Query("apiKey")  String apiKey);

    @GET("top-headlines")
    Call<Mainnews> getcategorynews(
            @Query("country")String country,
            @Query("category") String category,
            @Query("pageSize") int pageSize,
            @Query("apiKey")  String apiKey);


}
