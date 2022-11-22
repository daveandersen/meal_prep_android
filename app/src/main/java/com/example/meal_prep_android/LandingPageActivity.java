package com.example.meal_prep_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LandingPageActivity extends AppCompatActivity {
    private Button getStartedButton;
    private TextView login_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        getStartedButton = findViewById(R.id.getStarted_btn);
        login_btn = findViewById(R.id.login_btn);

        getStartedButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == MotionEvent.ACTION_DOWN) {
                    Log.d("hasOnTouchedFalse", "False");
                    v.animate().scaleX(1.1f);
                    v.animate().scaleY(1.1f);
                    return true;
                } else if (action == MotionEvent.ACTION_UP) {
                    Log.d("hasOnTouchedTrue", "True");
                    v.animate().cancel();
                    v.animate().scaleX(1f);
                    v.animate().scaleY(1f);
                    Intent intent = new Intent(v.getContext(), RegisterActivity.class);
                    startActivity(intent);
                    finish();
                    // add Navigation Logic here
                    return true;
                }
                return false;
            }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

