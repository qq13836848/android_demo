package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Toast toast;

    private int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "hello world");
        button = findViewById(R.id.button);

        button.setOnClickListener((e) -> {
            CustomPickerDialog.Builder dialogBuild = new CustomPickerDialog.Builder(this);
            CustomPickerDialog dialog = dialogBuild.create();
            dialog.setCallback((year, month, day) -> {
                Log.d("MainActivity", "year: " + year + ",month: " + month + ",day: " + day);
            });
            dialog.setCanceledOnTouchOutside(true);// 点击外部区域关闭
            dialog.show();

        });

    }
}