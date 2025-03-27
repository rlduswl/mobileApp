package com.example.guessthenumber;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText inputNumber;
    private TextView guideText, hintText;
    private Button checkButton, restartButton;
    private int targetNumber; // 정답 숫자
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // UI 요소 연결
        inputNumber = findViewById(R.id.inputNumber);
        guideText = findViewById(R.id.guideText);
        hintText = findViewById(R.id.hintText);
        checkButton = findViewById(R.id.checkButton);
        restartButton = findViewById(R.id.restartButton);

        // 새로운 정답 생성
        generateNewTargetNumber();

        // 확인 버튼 클릭 이벤트
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkGuess();
            }
        });

        // 재시작 버튼 클릭 이벤트
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });
    }

    // 랜덤 숫자 생성 (1 ~ 100)
    private void generateNewTargetNumber() {
        targetNumber = random.nextInt(100) + 1;
    }

    // 사용자의 입력값을 확인하는 메서드
    private void checkGuess() {
        String userInput = inputNumber.getText().toString().trim();

        if (userInput.isEmpty()) {
            Toast.makeText(this, "숫자를 입력하세요!", Toast.LENGTH_SHORT).show();
            return;
        }

        int guessedNumber = Integer.parseInt(userInput);

        if (guessedNumber < 1 || guessedNumber > 100) {
            Toast.makeText(this, "1에서 100 사이의 숫자를 입력하세요!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (guessedNumber < targetNumber) {
            hintText.setText("더 큰 수를 입력하세요! ⬆️");
        } else if (guessedNumber > targetNumber) {
            hintText.setText("더 작은 수를 입력하세요! ⬇️");
        } else {
            hintText.setText("🎉 정답입니다! 🎉");
            checkButton.setEnabled(false);  // 확인 버튼 비활성화
            restartButton.setVisibility(View.VISIBLE); // 재시작 버튼 표시
        }
    }

    // 게임을 초기 상태로 리셋하는 메서드
    private void resetGame() {
        generateNewTargetNumber(); // 새로운 정답 생성
        hintText.setText(""); // 힌트 초기화
        inputNumber.setText(""); // 입력 필드 초기화
        checkButton.setEnabled(true); // 확인 버튼 다시 활성화
        restartButton.setVisibility(View.GONE); // 재시작 버튼 숨기기
    }
}
