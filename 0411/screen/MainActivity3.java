package com.example.imageactivity;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MainActivity3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        EditText dateInput = findViewById(R.id.editDate);
        Button calcBtn = findViewById(R.id.btnCalc);
        TextView result = findViewById(R.id.txtDday);
        Button btnBack = findViewById(R.id.btnBack);

        calcBtn.setOnClickListener(v -> {
            String inputDate = dateInput.getText().toString();
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date today = sdf.parse(sdf.format(new Date())); // 오늘
                Date target = sdf.parse(inputDate);             // 입력받은 날짜

                long diff = target.getTime() - today.getTime();
                long days = TimeUnit.MILLISECONDS.toDays(diff);

                if (days > 0) {
                    result.setText("D-" + days);
                } else if (days == 0) {
                    result.setText("D-Day");
                } else {
                    result.setText("D+" + Math.abs(days));
                }
            } catch (Exception e) {
                result.setText("형식: yyyy-MM-dd (예: 2025-12-25)");
            }
        });

        btnBack.setOnClickListener(v -> finish());
    }
}
