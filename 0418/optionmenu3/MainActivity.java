package com.example.optionmenu3;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RelativeLayout layout;  // XML에서 참조할 레이아웃

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // XML에서 정의한 레이아웃을 참조
        layout = findViewById(R.id.main_layout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 메뉴 XML을 연결
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        // 메뉴 항목 선택에 따라 배경색 변경
        if (id == R.id.menu_blue) {
            layout.setBackgroundColor(Color.BLUE);
            return true;
        } else if (id == R.id.menu_green) {
            layout.setBackgroundColor(Color.GREEN);
            return true;
        } else if (id == R.id.menu_red) {
            layout.setBackgroundColor(Color.RED);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
