package com.example.reterofitsample;

import com.example.reterofitsample.model.NameObj;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://simplifiedcoding.net/demos/";
    @GET("marvel")
    Call<List<NameObj>> getNames();
}
