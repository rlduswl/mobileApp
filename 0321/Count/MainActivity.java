package com.example.count;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView counterText;
    private int counter = 0; // 카운터 초기값

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterText = findViewById(R.id.counterText);
        Button increaseButton = findViewById(R.id.increaseButton);
        Button decreaseButton = findViewById(R.id.decreaseButton);

        // 카운터 증가 버튼 클릭 시
        increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++; // 카운터 증가
                updateCounterText();
            }
        });

        // 카운터 감소 버튼 클릭 시
        decreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter--; // 카운터 감소
                updateCounterText();
            }
        });
    }

    // 카운터 값을 업데이트하는 메서드
    private void updateCounterText() {
        counterText.setText("카운터: " + counter);
    }
}
