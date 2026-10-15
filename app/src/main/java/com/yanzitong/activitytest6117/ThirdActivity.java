package com.yanzitong.activitytest6117;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    private Button mThirdBtn1;
    private Button mThirdBtn2;
    private Button mThirdBtn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);

        mThirdBtn1 = findViewById(R.id.third_btn1);
        mThirdBtn1.setOnClickListener(v -> {    // 项目内部隐式Intent：匹配action和category
            Intent intent = new Intent("com.yanzitong.activitytest6117.action.YZT_FIRST");  // 为FirstActivity定义对应的action
            intent.addCategory("com.yanzitong.activitytest6117.category.YZT_FIRST");
            startActivity(intent);
        });

        mThirdBtn2 = findViewById(R.id.third_btn2);
        mThirdBtn3 = findViewById(R.id.third_btn3);
        mThirdBtn2.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);     // 等价于"Intent intent = new Intent(android.intent.action.VIEW)"
            startActivity(intent);
        });
        mThirdBtn3.setOnClickListener(v -> {
            Intent intent = new Intent();
            startActivity(intent);
        });
    }

    // 隐式Intent——项目内部或项目之间的调用
    // 1. 实现ThirdActivity返回FirstActivity
    /**
     * 为FirstActivity定义对应的action和category的值
     * category可以是默认值，不可缺
     * category自定义
     */
}