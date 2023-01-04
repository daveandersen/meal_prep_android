package com.example.meal_prep_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;

public class RegisterActivity extends AppCompatActivity {
    private Button register_btn;
    private TextView login_btn;
    private ImageView signup_pic;
    private EditText usernameText;
    private EditText emailText;
    private EditText passwordText;
    private EditText confirmPasswordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register_btn = findViewById(R.id.register_btn);
        login_btn = findViewById(R.id.login_btn);
        signup_pic = findViewById(R.id.signup_pic);
        emailText = findViewById(R.id.email_field);
        passwordText = findViewById(R.id.password_field);
        confirmPasswordText = findViewById(R.id.confirm_password_field);

        try {
            InputStream ims = this.getAssets().open("images/login.jpg");
            Drawable d = Drawable.createFromStream(ims, null);
            signup_pic.setImageDrawable(d);
        } catch (Exception ex) {
            Log.d("mylog", "Error: " + ex.toString());
        }

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailText.getText().toString();
                String password = passwordText.getText().toString();
                String confirmPassword = confirmPasswordText.getText().toString();

                if(email.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter email", Toast.LENGTH_LONG).show();
                } else if(password.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter password", Toast.LENGTH_LONG).show();
                } else if(confirmPassword.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter confirm password", Toast.LENGTH_LONG).show();
                }
                else {
                    if(password.equals(confirmPassword)) {
                        Intent intent = new Intent(v.getContext(), LoginActivity.class);
                        startActivity(intent);
//                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Confirm password does not match with password", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), LoginActivity.class);
                startActivity(intent);
//                finish();
            }
        });
    }
}
