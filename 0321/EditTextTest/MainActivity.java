package com.example.edittexttest;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText eText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 반드시 추가

        eText = findViewById(R.id.edittext);
        textView = findViewById(R.id.textView);
    }

    public void onClicked(View v) { // Viewv → View v 수정
        String str = eText.getText().toString();
        textView.setText(str);
    }
}
