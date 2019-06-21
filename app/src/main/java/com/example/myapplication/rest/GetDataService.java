package com.example.myapplication.rest;

import com.example.myapplication.model.ResultPojo;
import com.example.myapplication.model.RetroInfo.RetroBio;
import com.example.myapplication.model.RetroPhoto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("/photos")
    Call<List<RetroPhoto>> getAllPhotos();

    @GET("/api?results=25")
    public Call<ResultPojo> getResults();

    @GET("/api")
    public Call<RetroBio> getInfo();
}