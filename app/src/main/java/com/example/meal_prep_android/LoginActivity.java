package com.example.meal_prep_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;

public class LoginActivity extends AppCompatActivity {
    private Button login_btn;
    private TextView signup_btn;
    private TextView forgot_password_btn;
    private EditText email;
    private EditText password;
    private ImageView login_pic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_btn = findViewById(R.id.login_btn);
        signup_btn = findViewById(R.id.signup_btn);
        forgot_password_btn = findViewById(R.id.change_password);
        email = findViewById(R.id.email_field);
        password = findViewById(R.id.password_field);
        login_pic = findViewById(R.id.login_pic);

        try {
            InputStream ims = this.getAssets().open("images/login.jpg");
            Drawable d = Drawable.createFromStream(ims, null);
            login_pic.setImageDrawable(d);
        } catch (Exception ex) {
            Log.d("mylog", "Error: " + ex.toString());
        }

        login_btn.setOnClickListener(new View.OnClickListener() {
            public void makeToast(String text) {
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
            }
            @Override
            public void onClick(View v) {
                String emailText = email.getText().toString();
                String passwordText = password.getText().toString();
                Boolean userLogged = false;
                Boolean passwordLogged = false;
                if(emailText.equals("")) {
                    makeToast("Please enter Email Address");
                } else {
                    if(emailText.equals("dave.andersen@student.sgu.ac.id")) {
                        userLogged = true;
                    }
                }
                if(passwordText.equals("")) {
                    makeToast("Please enter Password");
                } else {
                    if(passwordText.equals("dave123")) {
                        passwordLogged = true;
                    }
                }

                // Will navigate to List Activity
                if(userLogged == true && passwordLogged == true) {
                    Intent intent = new Intent(v.getContext(), HomePageActivity2.class);
                    Bundle bundle = new Bundle();
//                    bundle.putString("email", emailText);
//                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();
                } else {
                    makeToast("Wrong username or password");
                }
            }
        });

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

        forgot_password_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ChangePasswordActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}