package com.example.dogapp;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class VaccineActivity extends AppCompatActivity {

    private CalendarView calendarView;
    private TextView recentDateText, nextDateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine);

        // 🔧 Toolbar 설정
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // 📅 캘린더와 텍스트뷰 연결
        calendarView = findViewById(R.id.calendarView);
        recentDateText = findViewById(R.id.recent_date_text);
        nextDateText = findViewById(R.id.next_date_text);

        // 날짜 선택 시 처리
        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            String selectedDate = year + "년 " + (month + 1) + "월 " + dayOfMonth + "일";
            recentDateText.setText("최근 접종 날짜 : " + selectedDate);

            Calendar cal = Calendar.getInstance();
            cal.set(year, month, dayOfMonth);
            cal.add(Calendar.DAY_OF_MONTH, 35); // 5주 후

            String nextDate = new SimpleDateFormat("yyyy년 MM월 dd일", Locale.KOREA).format(cal.getTime());
            nextDateText.setText("다음 접종 날짜 : " + nextDate);
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish(); // ← 뒤로가기 기능 수행
        return true;
    }
}
