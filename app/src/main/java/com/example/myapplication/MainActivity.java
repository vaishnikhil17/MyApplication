package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.activity.RetroClientBio;
import com.example.myapplication.activity.retro_person;
import com.example.myapplication.activity.retrofit_recycler;
import com.example.myapplication.model.RetroInfo.RetroBio;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button b1, b2, b3 ;
    private Button exp_btn, imp_btn;
    private TextView txt;
    ///////////////////
    private Button bottombtn;
    //custom dialog box
    final Context context = this;
    private Button cus_dia_btn ;
    //object and Button view for dialog box
    private AlertDialog.Builder builder;
    private Button dialog_btn;
    //Button for RecyclerView
    private Button recycle_btn;
    //Retrofit Button Recycler View
    private Button retrofitbtn;
    //Retrofit Person Information Button
    private Button retro_person_btn;
    //Retrofit Person Bio Button
    private Button RetroBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ///////////////////////////////////////////////////////////
        //Retro Person Bio
        RetroBtn = findViewById(R.id.bio);
        RetroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RetroClientBio.class);
                startActivity(intent);
            }
        });
        //Retro_Person_information
        retro_person_btn = findViewById(R.id.retro_person);
        retro_person_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), retro_person.class);
                startActivity(intent);
            }
        });




        ////////////////////////////////////////////////////////////////////////////
        //Retrofit Recycler View Get data
        retrofitbtn = findViewById(R.id.retrofit_btn);
        retrofitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), retrofit_recycler.class);
                startActivity(intent);
            }
        });
        //Recycler View
        bottombtn = findViewById(R.id.btmbtn);
        bottombtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), recycle_view.class);
                startActivity(intent);

            }
        });
        /////////////////////////////////////////////////////////////////////////////////////////////////////////


        //Log.d("lifecycle", "onCreateinvoked");
        ////////////////////////////////////////////////////////////////////
        //Dialog Box example
        dialog_btn = findViewById(R.id.dialogbox);
        builder = new AlertDialog.Builder(this);
        dialog_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setMessage("Do u want to go to another activity")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                Intent intent1 = new Intent(getApplicationContext(), activity_second.class);

                                startActivity(intent1);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.setTitle("Alert Dialog Example");
                alert.show();

            }
        });
        ////////////////////////////////////////////////////////////////////////
        //Custom dialog box example
        cus_dia_btn = findViewById(R.id.cdbtn);
        cus_dia_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog cusdialog = new Dialog(context);
                cusdialog.setContentView(R.layout.custom);
                cusdialog.setTitle("Hello.......");
                cusdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                TextView text = cusdialog.findViewById(R.id.custext);
                text.setText("Enter your email address to verify & earn 100 coins in your frizza wallet");
                ImageView image = cusdialog.findViewById(R.id.imagecus);
                //image.setImageResource(R.drawable.ic_launcher_background);
                TextView btn = cusdialog.findViewById(R.id.cusbtn);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        cusdialog.dismiss();


                    }
                });
                cusdialog.show();

            }
        });


        exp_btn = findViewById(R.id.btn1);

        imp_btn = findViewById(R.id.btn2);

        exp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text_val = txt.getText().toString();

                Intent intent = new Intent(getApplicationContext(), activity_second.class);
                intent.putExtra("text_key", text_val);
                startActivity(intent);
            }
        });

        imp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com"));
                startActivity(intent);
            }
        });
        txt = findViewById(R.id.text1);

        b1 = findViewById(R.id.btna);
        b1.setOnClickListener(this);

        b2 = findViewById(R.id.btnb);
        b2.setOnClickListener(this);

        b3 = findViewById(R.id.btnc);
        b3.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btna: {
                Toast.makeText(MainActivity.this, "Hello, this is toast notification", Toast.LENGTH_SHORT).show();

                txt.setText("Button1 press");
                break;
            }
            case R.id.btnb: {
                Toast.makeText(MainActivity.this, "toast of Button2", Toast.LENGTH_SHORT).show();

                txt.setText("Button2 press");
                break;
            }
            case R.id.btnc: {
                Toast.makeText(MainActivity.this, "toast of Button3", Toast.LENGTH_SHORT).show();

                txt.setText("Button3 press");
                break;
            }


        }

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle", "onStartInvoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle", "onResumeInvoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle", "onPauseInvoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle", "onStopInvoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle", "onRestartinvoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle", "onCreateinvoked");
    }
}
