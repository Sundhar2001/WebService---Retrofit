package com.example.reterofitsample.instance;

import com.example.reterofitsample.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static RetrofitInstance instance = null;
    private Api api;

    private RetrofitInstance (){

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);
    }

    public static synchronized RetrofitInstance getInstance(){

        if (instance == null){
            instance = new RetrofitInstance();
        }
        return instance;
    }

    public Api getApi(){
        return api;
    }

}
