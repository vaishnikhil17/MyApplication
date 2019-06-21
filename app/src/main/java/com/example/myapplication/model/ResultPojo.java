package com.example.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class ResultPojo {

    @SerializedName("results")
    private Result[] results;

    public Result[] getResults() {
        return results;
    }

    public void setResults(Result[] results) {
        this.results = results;
    }
}
