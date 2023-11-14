package com.example.a01_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

// 关于宽高的设置

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextView tv3 = findViewById(R.id.tv3);
        ViewGroup.LayoutParams params = tv3.getLayoutParams();
        params.width = 300;
        params.height = 500;
        tv3.setLayoutParams(params);
    }
}