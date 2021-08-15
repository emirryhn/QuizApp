package com.example.ujianquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class SuccessPage extends AppCompatActivity {

    ImageView imageView;
    Button btnSuccess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_page);
        imageView = findViewById(R.id.image_success);
        btnSuccess = findViewById(R.id.btn_success);

        Glide.with(this).load("https://assets.stickpng.com/images/586383a07d90850fc3ce290f.png")
                .into(imageView);

        btnSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}