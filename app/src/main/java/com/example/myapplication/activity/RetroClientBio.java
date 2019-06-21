package com.example.myapplication.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;
import com.example.myapplication.model.RetroInfo.Result;
import com.example.myapplication.model.RetroInfo.RetroBio;
import com.example.myapplication.network.RetroClentBioInstance;
import com.example.myapplication.network.retro_person_clientInstance;
import com.example.myapplication.rest.GetDataService;
import com.google.android.material.snackbar.Snackbar;

import java.lang.reflect.Array;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClientBio extends AppCompatActivity {
    ImageView person;
    TextView name,dob;
    View v1,v2,v3;
    ImageButton email,phone,map;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retro_client_bio);

        GetDataService service = RetroClentBioInstance.getRetrofitInstance().create(GetDataService.class);
        Call <RetroBio> call = service.getInfo();
        call.enqueue(new Callback<RetroBio>() {
            @Override
            public void onResponse(Call<RetroBio> call, Response<RetroBio> response) {
                RetroBio obj = response.body();
                getObject(obj);
            }

            @Override
            public void onFailure(Call<RetroBio> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Some Error",Toast.LENGTH_SHORT).show();
            }
        });
        person = findViewById(R.id.person);
        name = findViewById(R.id.name);
        dob = findViewById(R.id.dob);



        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        map = findViewById(R.id.map);
        /*v1 = findViewById(R.id.email);
        v2 = findViewById(R.id.phone);
        v3 = findViewById(R.id.map);*/


    }
    private void getObject(RetroBio obj){
        final List<Result> list = obj.getResults();
        Glide.with(this)
                .load(list.get(0).getPicture().getLarge())
                .apply(RequestOptions.circleCropTransform())
                .into(person);
        name.setText(list.get(0).getName().getFirst());
        dob.setText(list.get(0).getDob().getDate());
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(view,list.get(0).getEmail(),Snackbar.LENGTH_SHORT)
                        .setAction("RETRY", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                            }
                        });
                snackbar.show();
            }
        });
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(view,list.get(0).getPhone(),Snackbar.LENGTH_SHORT)
                        .setAction("RETRY", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                            }
                        });
                snackbar.show();
            }
        });
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri navigationIntentUri = Uri.parse("google.navigation:q=" + list.get(0).getLocation().getCoordinates().getLatitude() + "," +
                        list.get(0).getLocation().getCoordinates().getLongitude());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, navigationIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });



    }
}
