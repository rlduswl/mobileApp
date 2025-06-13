package com.example.dogapp;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class WalkActivity extends AppCompatActivity {

    private Chronometer chronometer;
    private Button startButton, stopButton;
    private TextView startTimeText, endTimeText, totalTimeText;

    private long startTime = 0;
    private long endTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walk);

        // 툴바 설정
        Toolbar toolbar = findViewById(R.id.walk_toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        chronometer = findViewById(R.id.chronometer);
        startButton = findViewById(R.id.start_button);
        stopButton = findViewById(R.id.stop_button);
        startTimeText = findViewById(R.id.start_time_text);
        endTimeText = findViewById(R.id.end_time_text);
        totalTimeText = findViewById(R.id.total_time_text);

        startButton.setOnClickListener(v -> {
            startTime = System.currentTimeMillis();
            chronometer.setBase(SystemClock.elapsedRealtime());
            chronometer.start();

            String formattedTime = getCurrentTime();
            startTimeText.setText("산책 시작 시간 : " + formattedTime);
        });

        stopButton.setOnClickListener(v -> {
            endTime = System.currentTimeMillis();
            chronometer.stop();

            String formattedEndTime = getCurrentTime();
            endTimeText.setText("산책 종료 시간 : " + formattedEndTime);

            long durationMillis = endTime - startTime;
            long minutes = (durationMillis / 1000) / 60;
            long hours = minutes / 60;
            minutes %= 60;

            String totalTime = hours + "시간 " + minutes + "분";
            totalTimeText.setText("총 산책 시간 : " + totalTime);
        });
    }

    private String getCurrentTime() {
        return new SimpleDateFormat("HH시 mm분", Locale.KOREA).format(new Date());
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish(); // ← 뒤로가기 기능
        return true;
    }
}
