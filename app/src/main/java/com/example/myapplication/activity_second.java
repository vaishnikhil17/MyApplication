package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.service.FirstService;

public class activity_second extends AppCompatActivity implements View.OnClickListener {
    private TextView text;
    Button start_btn, stop_btn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);
        text = findViewById(R.id.text_sec);
        start_btn = findViewById(R.id.btn1);
        stop_btn = findViewById(R.id.btn2);
        start_btn.setOnClickListener(this);
        stop_btn.setOnClickListener(this);

//        String temp = getIntent().getStringExtra("txt_key");
        Bundle b= getIntent().getExtras();
        if(b != null) {
            String txt = b.getString("text_key", null);
            text.setText(txt);
        }
    }
    public void onClick(View view) {
        if(view == start_btn){
            Intent intent = new Intent(getApplicationContext() , FirstService.class);
            intent.setAction(FirstService.ACTION_START_FOREGROUND_SERVICE);
            startService(intent);
            //startActivity(intent);
        }
        else if(view == stop_btn){
            Intent intent = new Intent(getApplicationContext() , FirstService.class);
            intent.setAction(FirstService.ACTION_STOP_FOREGROUND_SERVICE);
            startService(intent);
            //startActivity(intent);
        }

    }
}
