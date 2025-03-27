package com.example.dice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView diceImage;
    private TextView diceNumberText; // 주사위 숫자 표시 TextView
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diceImage = findViewById(R.id.diceImage);
        diceNumberText = findViewById(R.id.diceNumberText); // TextView 추가
        Button rollButton = findViewById(R.id.rollButton);

        // ROLL 버튼 클릭 시 주사위 굴리기 실행
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
            }
        });
    }

    // 주사위 굴리기 함수
    private void rollDice() {
        int diceNumber = random.nextInt(6) + 1; // 1~6 랜덤 숫자 생성

        // 숫자 업데이트
        diceNumberText.setText("주사위 숫자: " + diceNumber);
    }
}

