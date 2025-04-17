package com.example.imageactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        EditText num1 = findViewById(R.id.editNum1);
        EditText num2 = findViewById(R.id.editNum2);
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnSub = findViewById(R.id.btnSub);
        Button btnMul = findViewById(R.id.btnMul);
        Button btnDiv = findViewById(R.id.btnDiv);
        TextView result = findViewById(R.id.txtCalcResult);
        Button btnBack = findViewById(R.id.btnBack);

        View.OnClickListener calcListener = v -> {
            try {
                double a = Double.parseDouble(num1.getText().toString());
                double b = Double.parseDouble(num2.getText().toString());
                double res;

                int id = v.getId();

                if (id == R.id.btnAdd) {
                    res = a + b;
                } else if (id == R.id.btnSub) {
                    res = a - b;
                } else if (id == R.id.btnMul) {
                    res = a * b;
                } else if (id == R.id.btnDiv) {
                    if (b == 0) {
                        result.setText("0으로 나눌 수 없습니다");
                        return;
                    }
                    res = a / b;
                } else {
                    result.setText("알 수 없는 버튼입니다.");
                    return;
                }

                result.setText("결과: " + res);
            } catch (Exception e) {
                result.setText("숫자를 모두 입력하세요");
            }
        };

        btnAdd.setOnClickListener(calcListener);
        btnSub.setOnClickListener(calcListener);
        btnMul.setOnClickListener(calcListener);
        btnDiv.setOnClickListener(calcListener);
        btnBack.setOnClickListener(v -> finish());
    }
}
