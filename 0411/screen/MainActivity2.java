package com.example.imageactivity;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        EditText input = findViewById(R.id.editInput);
        Button convert = findViewById(R.id.btnConvert);
        TextView result = findViewById(R.id.txtResult);
        Button back = findViewById(R.id.btnBack);

        convert.setOnClickListener(v -> {
            try {
                double cm = Double.parseDouble(input.getText().toString());
                result.setText(String.format("%.2f cm = %.2f inch", cm, cm / 2.54));
            } catch (Exception e) {
                result.setText("숫자를 입력하세요");
            }
        });

        back.setOnClickListener(v -> finish());
    }
}
