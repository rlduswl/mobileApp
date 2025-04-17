package com.example.imageactivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnToActivity2).setOnClickListener(v -> startActivity(new Intent(this, MainActivity2.class)));
        findViewById(R.id.btnToActivity3).setOnClickListener(v -> startActivity(new Intent(this, MainActivity3.class)));
        findViewById(R.id.btnToActivity4).setOnClickListener(v -> startActivity(new Intent(this, MainActivity4.class)));
        findViewById(R.id.btnToActivity5).setOnClickListener(v -> startActivity(new Intent(this, MainActivity5.class)));}
}
