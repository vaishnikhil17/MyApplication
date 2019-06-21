package com.example.myapplication.adapter;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.activity.retro_person;
import com.example.myapplication.model.Result;
//import com.example.myapplication.model.retro_person_model;
import com.example.myapplication.model.ResultPojo;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

import static android.Manifest.*;
import static android.Manifest.permission.*;
import static androidx.core.content.ContextCompat.checkSelfPermission;

public class retro_person_adapter extends RecyclerView.Adapter<retro_person_adapter.viewHolder> {
    private Result[] list;
    private Context context;
    //private Result obj = Result[0];


    public retro_person_adapter(Context context, Result[] list) {

        this.list = list;
        this.context = context;
    }


    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_retro_person_row, parent, false);
        return new viewHolder(view);
    }


    @Override
    public void onBindViewHolder(viewHolder holder, final int position) {

        Result mode = list[position];
        //holder.image.setImageDrawable(getDrawable(mode.getPicture().getMedium()));
        holder.age.setText(String.valueOf(list[position].getDob().getAge()));
        holder.gender.setText(list[position].getGender());
        holder.name.setText(list[position].getName().getFirst());
        holder.phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+list[position].getPhone()));

                context.startActivity(callIntent);
            }
        });
        holder.emailbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);

                String recipients= list[position].getEmail();
                //String recipients="mailto@gmail.com";
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{list[position].getEmail()});
                intent.setType("message/rfc822");
                intent.setPackage("com.google.android.gm");
                context.startActivity(Intent.createChooser(intent, "Send mail"));
            }
        });
        Glide.with(context)
                .load(list[position].getPicture().getMedium())
                .into(holder.image);
/*
        Picasso.with(context)
                .load(list[position].getPicture().getMedium())
                .into(holder.image);
*/
/*

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(list[position].getPicture().getMedium())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(holder.image);*/
    }

    @Override
    public int getItemCount() {
        Log.d("","");
        return list.length;
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        public TextView age,name,gender;
        //private Result mode;
        public ImageView image;
        public final View mView;
        //Button emailbtn,phone;
        ImageButton emailbtn,phone;
        viewHolder(View itemView){
            super(itemView);
            mView= itemView;
            age = mView.findViewById(R.id.age);
            gender = mView.findViewById(R.id.gender);
            name = mView.findViewById(R.id.name);
            image = mView.findViewById(R.id.image);
            emailbtn = mView.findViewById(R.id.emailbtn);
            phone = mView.findViewById(R.id.phone);


        }

    }
}
///
