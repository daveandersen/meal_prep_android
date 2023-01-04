package com.example.meal_prep_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class SettingsActivity extends AppCompatActivity {
    ImageView profileImage;
    CardView change_password;
    CardView about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        profileImage = findViewById(R.id.image_view);
        change_password = findViewById(R.id.change_password);
        about = findViewById(R.id.about);

        Glide.with(this)
                .load("https://reqres.in/img/faces/7-image.jpg")
                .circleCrop()
                .into(profileImage);

        change_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ChangePasswordActivity.class);
                startActivity(intent);
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AboutActivity.class);
                startActivity(intent);
            }
        });
    }
}