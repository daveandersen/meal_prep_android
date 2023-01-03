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
    private TextView signup_btn;
    private ImageView signup_pic;
    private EditText usernameText;
    private EditText emailText;
    private EditText passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register_btn = findViewById(R.id.register_btn);
//        signup_btn = findViewById(R.id.signup_btn);
        signup_pic = findViewById(R.id.signup_pic);
        usernameText = findViewById(R.id.username_field);
        emailText = findViewById(R.id.email_field);
        passwordText = findViewById(R.id.password_field);

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
                String username = usernameText.getText().toString();
                String email = emailText.getText().toString();
                String password = passwordText.getText().toString();

                if(username.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter username", Toast.LENGTH_LONG).show();
                } else if(email.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter email", Toast.LENGTH_LONG).show();
                } else if(password.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter password", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(v.getContext(), LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

//        signup_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(v.getContext(), RegisterActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
    }
}
