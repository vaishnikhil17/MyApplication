package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class activity_second extends AppCompatActivity {
    private TextView text;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);
        text = findViewById(R.id.text_sec);
//        String temp = getIntent().getStringExtra("txt_key");
        Bundle b= getIntent().getExtras();
        if(b != null) {
            String txt = b.getString("text_key", null);
            text.setText(txt);
        }
    }
}
