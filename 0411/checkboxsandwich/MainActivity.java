package com.example.checkboxsandwich;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CheckBox chkMeat, chkCheese;
    ImageView imgMeat, imgCheese;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkMeat = findViewById(R.id.chkMeat);
        chkCheese = findViewById(R.id.chkCheese);
        imgMeat = findViewById(R.id.imgMeat);
        imgCheese = findViewById(R.id.imgCheese);

        chkMeat.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                imgMeat.setVisibility(ImageView.VISIBLE);
            } else {
                imgMeat.setVisibility(ImageView.GONE);
            }
        });

        chkCheese.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                imgCheese.setVisibility(ImageView.VISIBLE);
            } else {
                imgCheese.setVisibility(ImageView.GONE);
            }
        });
    }
}
