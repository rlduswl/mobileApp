package com.example.imageactivity;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);  // 두 번째 레이아웃

        Button btnClose = findViewById(R.id.btnClose);
        btnClose.setOnClickListener(v -> finish());  // 현재 액티비티 종료
    }
}
