package com.example.galleryapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager;
    ArrayList<ImageItem> imageList;
    ImageAdapter imageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        imageList = new ArrayList<>();

        imageList.add(new ImageItem("스마트 거울", "온도와 날씨를 보여주는 IoT 미러", R.drawable.mirror));
        imageList.add(new ImageItem("드론 탐지기", "해양 쓰레기를 자동 탐지하는 드론 시스템", R.drawable.drone));
        imageList.add(new ImageItem("갤러리 앱", "작품들을 소개하는 안드로이드 앱", R.drawable.gallery));

        imageAdapter = new ImageAdapter(this, imageList);
        viewPager.setAdapter(imageAdapter);
    }
}
