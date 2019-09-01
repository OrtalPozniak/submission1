package com.example.sub1fruits;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView clickedFruitName = findViewById(R.id.fruitNameWasClicked);//name
        clickedFruitName.setText(getIntent().getExtras().getString(MyAdapter.FRUIT_NAME_INTENT_KEY));

        TextView clickedFruitCalories = findViewById(R.id.fruitCaloriesWasClicked);//calories
        clickedFruitCalories.setText(
                getIntent().getExtras().getString(MyAdapter.FRUIT_CALORIES_INTENT_KEY)+" calories");

        ImageView clickedFruitImageIV = findViewById(R.id.fruitImageWasClicked);//image

        clickedFruitImageIV.setImageResource(getIntent().getExtras().getInt(MyAdapter.FRUIT_IMAGE_INTENT_KEY));
    }
}
