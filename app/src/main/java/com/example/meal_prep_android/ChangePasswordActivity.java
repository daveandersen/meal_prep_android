package com.example.meal_prep_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePasswordActivity extends AppCompatActivity {
    Button submit;
    EditText email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        submit = findViewById(R.id.submit_btn);
        email = findViewById(R.id.email_field);

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(email.equals("")) {
                    Toast.makeText(getApplicationContext(), "Email address is empty", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Link to change password has been sent to your email", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(v.getContext(), LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}