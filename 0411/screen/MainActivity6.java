package com.example.imageactivity;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity6 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        EditText editHeight = findViewById(R.id.editHeight);
        EditText editWeight = findViewById(R.id.editWeight);
        Button btnCalc = findViewById(R.id.btnCalc);
        TextView result = findViewById(R.id.txtResult);
        Button btnBack = findViewById(R.id.btnBack);

        btnCalc.setOnClickListener(v -> {
            try {
                double heightCm = Double.parseDouble(editHeight.getText().toString());
                double weight = Double.parseDouble(editWeight.getText().toString());
                double heightM = heightCm / 100.0;
                double bmi = weight / (heightM * heightM);

                String status;
                if (bmi < 18.5) {
                    status = "저체중";
                } else if (bmi < 23) {
                    status = "정상";
                } else if (bmi < 25) {
                    status = "과체중";
                } else {
                    status = "비만";
                }

                result.setText(String.format("BMI: %.1f (%s)", bmi, status));
            } catch (Exception e) {
                result.setText("숫자를 모두 입력하세요");
            }
        });

        btnBack.setOnClickListener(v -> finish());
    }
}
