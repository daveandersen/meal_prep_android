package com.example.meal_prep_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.meal_prep_android.models.ListItem;
import com.google.gson.Gson;

import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    private ImageView image;
    private TextView name;
    private TextView category;
    private TextView ingredients;
    private TextView descriptions;
    private TextView directions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getSupportActionBar().hide();

        image = findViewById(R.id.image_view);
        name = findViewById(R.id.name_text_view);
//        category = findViewById(R.id.last_name_text_view);
        ingredients = findViewById(R.id.ingredients_text_view);
        descriptions = findViewById(R.id.descriptions_text_view);
        directions = findViewById(R.id.directions_text_view);

        String jsonMyObject = null;
        Bundle userBundle = getIntent().getExtras();
        if (userBundle != null) {
            jsonMyObject = userBundle.getString("onClickedItem");
        }
        ListItem item = new Gson().fromJson(jsonMyObject, ListItem.class);

        Glide.with(this)
                .load(item.getImageName())
                .into(image);

        name.setText(item.getName());
        descriptions.setText(item.getDescription());
        ingredients.setText(item.getIngredients());
        directions.setText(item.getDirections());
    }
}