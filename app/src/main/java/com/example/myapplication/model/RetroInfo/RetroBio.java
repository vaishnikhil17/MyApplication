
package com.example.myapplication.model.RetroInfo;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class RetroBio {

    @SerializedName("results")
    private List<Result> results = null;

    @SerializedName("info")
    private Info info;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

}
