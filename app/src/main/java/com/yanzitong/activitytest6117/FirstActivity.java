package com.yanzitong.activitytest6117;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

// 组合键：shift + enter
public class FirstActivity extends AppCompatActivity {
    private static final String TAG = "FirstActivity";

    // 先声明（变量命名：小驼峰）再使用
    // 全局（成员）变量：m开头
    Button mFirstBtn1;
    Button mFirstBtn2;

    /**
     * 事件驱动机制
     * 事件源、什么事件、监听器（XXXListener）
     * 按钮的单击事件实现方法一：
     * 内部匿名
     */

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Log.d(TAG, "onCreate: 活动创建成功"); // 组合键2：alter + enter
        mFirstBtn1 = findViewById(R.id.first_btn1);
        mFirstBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this, "6117严梓桐单击了按钮", Toast.LENGTH_SHORT).show();
            }
        });
        mFirstBtn2 = findViewById(R.id.first_btn2);
        mFirstBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Hello");
                Toast.makeText(FirstActivity.this, "我是严梓桐", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {  // 回调
        if (item.getItemId() == R.id.add_item) {
            Toast.makeText(this, "6117单击了菜单项add", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onOptionsItemSelected: 6117单击了菜单项add");
        } else if (item.getItemId() == R.id.modify_item) {
            Toast.makeText(this, "6117单击了菜单项modify", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onOptionsItemSelected: 6117单击了菜单项modify");
        } else if (item.getItemId() == R.id.delete_item) {
            Toast.makeText(this, "6117单击了菜单项delete", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onOptionsItemSelected: 6117单击了菜单项delete");
        }
        return super.onOptionsItemSelected(item);
    }
}

/**
 * 添加一个按钮，id = first_btn2，完成单击事件：弹出Toast消息日志，内容自定义，带个人标识
 * mFirstBtn2 = findViewById(R.id.first_btn2);
 * mFirstBtn2.setOnClickListener(new View.OnClickListener() {
 *
 * @Override public void onClick(View v) {
 * Log.d(TAG, "onClick: Hello");
 * Toast.makeText(FirstActivity.this, "我是严梓桐", Toast.LENGTH_SHORT).show();
 * }
 * });
 */