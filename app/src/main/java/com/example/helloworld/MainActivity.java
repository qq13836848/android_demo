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
            i = i+1;
//            Toast.makeText(MainActivity.this,"content ",Toast.LENGTH_SHORT).show();
            if (toast == null){
                toast = Toast.makeText(MainActivity.this,"content ",Toast.LENGTH_SHORT);
            }else {
                toast.cancel();
                toast = Toast.makeText(MainActivity.this,"content ",Toast.LENGTH_SHORT);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setText("content" + i);
            }
            toast.show();
        });
    }
}