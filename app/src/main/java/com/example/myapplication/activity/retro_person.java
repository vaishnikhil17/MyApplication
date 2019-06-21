package com.example.myapplication.activity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.retro_person_adapter;
import com.example.myapplication.model.Result;
import com.example.myapplication.model.ResultPojo;
import com.example.myapplication.network.retro_person_clientInstance;
import com.example.myapplication.rest.GetDataService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class retro_person extends AppCompatActivity {
    private RecyclerView recyclerView;
    private retro_person_adapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retro_person);
        //Build our API object
        GetDataService service = retro_person_clientInstance.getRetrofitInstance().create(GetDataService.class);
        //Call our API
        Call<ResultPojo> call = service.getResults();
        call.enqueue(new Callback<ResultPojo>() {
            @Override
            public void onResponse(Call<ResultPojo> call, Response<ResultPojo> response) {
                Toast.makeText(retro_person.this, "Got result", Toast.LENGTH_SHORT).show();
                resultlistgenerated(response.body());
            }

            @Override
            public void onFailure(Call<ResultPojo> call, Throwable t) {
                Toast.makeText(retro_person.this,"Something wrong",Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void resultlistgenerated(ResultPojo list) {
        recyclerView = findViewById(R.id.retro_person);
        Result[] results = list.getResults();
        adapter = new retro_person_adapter(this,results);

        //adapter = new retro_person_adapter(results);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(retro_person.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}
