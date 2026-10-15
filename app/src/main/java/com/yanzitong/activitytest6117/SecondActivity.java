package com.yanzitong.activitytest6117;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        Button mSecondBtn1 = findViewById(R.id.second_btn1);
        mSecondBtn1.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
            startActivity(intent);
        });
    }
}
/**
 * your turn:
 * 新建UI: third_layout和Java class: thirdActivity
 * 按钮text = "跳转到ThirdActivity"
 * 完成单击事件：实现从 SecondActivity 显式跳转到 ThirdActivity
 */