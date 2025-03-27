package com.example.calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText eText1, eText2;
    private TextView textViewResult;
    private Button bPlus, bMinus, bMultiply, bDivide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // UI 요소 연결
        eText1 = findViewById(R.id.edit1);
        eText2 = findViewById(R.id.edit2);
        textViewResult = findViewById(R.id.textView3); // 결과는 TextView에 출력

        bPlus = findViewById(R.id.button1);
        bMinus = findViewById(R.id.button2);
        bMultiply = findViewById(R.id.button3);
        bDivide = findViewById(R.id.button4);

        // 버튼 클릭 이벤트 설정
        bPlus.setOnClickListener(v -> calculate("+"));
        bMinus.setOnClickListener(v -> calculate("-"));
        bMultiply.setOnClickListener(v -> calculate("*"));
        bDivide.setOnClickListener(v -> calculate("/"));
    }

    private void calculate(String operator) {
        String s1 = eText1.getText().toString();
        String s2 = eText2.getText().toString();

        // 입력값 검증 (빈 문자열 처리)
        if (s1.isEmpty() || s2.isEmpty()) {
            textViewResult.setText("값을 입력하세요.");
            return;
        }

        double num1 = Double.parseDouble(s1);
        double num2 = Double.parseDouble(s2);
        double result = 0;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    textViewResult.setText("0으로 나눌 수 없습니다.");
                    return;
                }
                result = num1 / num2;
                break;
        }

        textViewResult.setText("결과: " + result);
    }
}
