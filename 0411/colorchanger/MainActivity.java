package com.example.colorchanger;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    FrameLayout imageFrame;
    Button btnColor1, btnColor2, btnColor3, btnColor4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageFrame = findViewById(R.id.image_frame);
        btnColor1 = findViewById(R.id.btnColor1);
        btnColor2 = findViewById(R.id.btnColor2);
        btnColor3 = findViewById(R.id.btnColor3);
        btnColor4 = findViewById(R.id.btnColor4);

        btnColor1.setOnClickListener(v -> imageFrame.setBackgroundColor(Color.GREEN));
        btnColor2.setOnClickListener(v -> imageFrame.setBackgroundColor(Color.YELLOW));
        btnColor3.setOnClickListener(v -> imageFrame.setBackgroundColor(Color.BLUE));
        btnColor4.setOnClickListener(v -> imageFrame.setBackgroundColor(Color.RED));
    }
}
