package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.app.hubert.guide.NewbieGuide;
import com.app.hubert.guide.core.Controller;
import com.app.hubert.guide.model.GuidePage;
import com.app.hubert.guide.model.HighLight;
import com.app.hubert.guide.model.RelativeGuide;


public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;
    private Toast toast;

    private int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "hello world");
        button = findViewById(R.id.button);

        button.setOnClickListener((e) -> {
            i = i + 1;
//            Toast.makeText(MainActivity.this,"content ",Toast.LENGTH_SHORT).show();
            if (toast == null) {
                toast = Toast.makeText(MainActivity.this, "content ", Toast.LENGTH_SHORT);
            } else {
                toast.cancel();
                toast = Toast.makeText(MainActivity.this, "content ", Toast.LENGTH_SHORT);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setText("content" + i);
            }
            toast.show();
        });

        textView = findViewById(R.id.text);

        Controller guide1 = NewbieGuide.with(this)
                .alwaysShow(true)
                .setLabel("0")

                .addGuidePage(GuidePage.newInstance()
                        .setEverywhereCancelable(false)
                        .addHighLight(button, HighLight.Shape.RECTANGLE)
//                        .setLayoutRes(R.layout.mask)
//                        .addHighLight(textView)
                        .setLayoutRes(R.layout.mask, R.id.next))
                .addGuidePage(GuidePage.newInstance()
                        .addHighLight(textView, HighLight.Shape.RECTANGLE,  new RelativeGuide(R.layout.mask1,
                                Gravity.TOP, 8))
//                        .setLayoutRes(R.layout.mask)
//                        .addHighLight(textView)
                        .setLayoutRes(R.layout.mask)
                ).build();
        guide1.show();

    }
}