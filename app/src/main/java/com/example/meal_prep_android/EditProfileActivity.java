package com.example.meal_prep_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class EditProfileActivity extends AppCompatActivity {
    private ImageView profileImage;
    private Button update;
    private EditText username;
    private EditText email;
    private EditText phoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        profileImage = findViewById(R.id.profile_image);
        update = findViewById(R.id.update_btn);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        phoneNo = findViewById(R.id.phone_number);

        Glide.with(this)
                .load("https://reqres.in/img/faces/7-image.jpg")
                .circleCrop()
                .into(profileImage);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter username", Toast.LENGTH_LONG).show();
                } else if(email.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter email", Toast.LENGTH_LONG).show();
                } else if(phoneNo.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter phone number", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Profile Updated", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(v.getContext(), ProfileActivity.class);
                    startActivity(intent);
                }

            }
        });

    }
}