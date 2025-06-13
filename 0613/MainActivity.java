package com.example.dogapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText todoInput;
    private LinearLayout todoListLayout;
    private TextView walkStart, walkEnd, walkTotal, recentDate, vaccineType, nextDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todoInput = findViewById(R.id.todo_input);
        todoListLayout = findViewById(R.id.todo_list_layout);
        walkStart = findViewById(R.id.walk_start);
        walkEnd = findViewById(R.id.walk_end);
        walkTotal = findViewById(R.id.walk_total);
        recentDate = findViewById(R.id.recent_date);
        vaccineType = findViewById(R.id.vaccine_type);
        nextDate = findViewById(R.id.next_date);

        Button addBtn = findViewById(R.id.add_button);
        addBtn.setOnClickListener(v -> {
            String task = todoInput.getText().toString();
            if (!task.isEmpty()) {
                TextView newItem = new TextView(this);
                newItem.setText("○ " + task);
                newItem.setTextSize(16);
                todoListLayout.addView(newItem);
                todoInput.setText("");
            }
        });

        walkStart.setText("산책 시작 시간 : 18시 20분");
        walkEnd.setText("산책 종료 시간 : 19시 30분");
        walkTotal.setText("총 산책 시간 : 1시간 10분");

        recentDate.setText("최근 접종 날짜 : 2025년 4월 15일");
        vaccineType.setText("백신 종류 : 종합백신");
        nextDate.setText("다음 접종 날짜 : 2025년 5월 20일");

        ImageView walkPlus = findViewById(R.id.walk_plus);
        walkPlus.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, WalkActivity.class);
            startActivity(intent);
        });

        ImageView vaccinePlus = findViewById(R.id.vaccine_plus);
        vaccinePlus.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, VaccineActivity.class);
            startActivity(intent);
        });

        CalendarView calendarView = findViewById(R.id.small_calendar);
        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            String dateStr = year + "년 " + (month + 1) + "월 " + dayOfMonth + "일";
            recentDate.setText("최근 접종 날짜 : " + dateStr);
            nextDate.setText("다음 접종 날짜 : " + year + "년 " + (month + 2) + "월 " + dayOfMonth + "일");
        });
    }
}
