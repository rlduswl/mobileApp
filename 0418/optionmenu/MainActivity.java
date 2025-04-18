package com.example.optionmenu;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    RelativeLayout rootLayout;

    // 메뉴 항목 ID 정의
    final int MENU_RED = 1;
    final int MENU_GREEN = 2;
    final int MENU_BLUE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootLayout = findViewById(R.id.root_layout);
        textView = findViewById(R.id.textView);

        // 컨텍스트 메뉴 등록
        registerForContextMenu(textView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("배경색 선택");
        menu.add(0, MENU_RED, 0, "배경색: RED");
        menu.add(0, MENU_GREEN, 0, "배경색: GREEN");
        menu.add(0, MENU_BLUE, 0, "배경색: BLUE");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_RED:
                rootLayout.setBackgroundColor(Color.RED);
                return true;
            case MENU_GREEN:
                rootLayout.setBackgroundColor(Color.GREEN);
                return true;
            case MENU_BLUE:
                rootLayout.setBackgroundColor(Color.BLUE);
                return true;
        }
        return super.onContextItemSelected(item);
    }
}
