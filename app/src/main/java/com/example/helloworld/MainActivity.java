package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Button button1;

    private int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "hello world");
        button = findViewById(R.id.button);
        button.setOnClickListener((e) -> {
            AMapAppUtils.openMap(this, 31.23795, 121.46682, "交通银行上海新昌路支行", "marker", "https://m.amap.com/navigation/carmap/sort=tfc&daddr=114.086217,22.540805");
        });

        button1 = findViewById(R.id.button1);
        button1.setOnClickListener((e) -> {
            BrowserUtils.openBrowser(this,"https://www.baidu.com");
        });


    }






}