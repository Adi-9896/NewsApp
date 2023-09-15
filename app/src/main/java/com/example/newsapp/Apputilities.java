package com.example.newsapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apputilities {
    public  static Retrofit retrofit = null;

    public static Apiinterface getApiinterface(){

        if ( retrofit== null){
            retrofit = new Retrofit.Builder().baseUrl(Apiinterface.BASEURL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(Apiinterface.class);
    }
}
