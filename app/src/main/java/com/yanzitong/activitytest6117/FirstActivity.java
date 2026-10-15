package com.yanzitong.activitytest6117;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

// 组合键：shift + enter
public class FirstActivity extends AppCompatActivity {
    private static final String TAG = "FirstActivity";

    // 先声明（变量命名：小驼峰）再使用
    // 全局（成员）变量：m开头
    Button mFirstBtn1;
    Button mFirstBtn2;
    LinearLayout mFirstLinearLayout;
    Button mFirstBtn3;
    Button mFirstBtn4;

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

        mFirstBtn4 = findViewById(R.id.first_btn4);
        mFirstBtn4.setOnClickListener(v -> {
            // Activity之间的跳转——显式Intent
            Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
            startActivity(intent);
        });

        mFirstBtn3 = findViewById(R.id.first_btn3);
        mFirstBtn3.setOnClickListener(v -> {
            finish();
        });

        mFirstBtn1 = findViewById(R.id.first_btn1);
        mFirstBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this, "6117严梓桐单击了按钮", Toast.LENGTH_SHORT).show();
                PopupMenu popupMenu = new PopupMenu(FirstActivity.this, v);     // this, super
                popupMenu.getMenuInflater().inflate(R.menu.main, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(item -> {
                    if (item.getItemId() == R.id.add_item) {
                        Toast.makeText(FirstActivity.this, "单击了add按钮", Toast.LENGTH_SHORT).show();
                    } else if (item.getItemId() == R.id.modify_item) {
                        Toast.makeText(FirstActivity.this, "单击了modify按钮", Toast.LENGTH_SHORT).show();
                    } else if (item.getItemId() == R.id.delete_item) {
                        Toast.makeText(FirstActivity.this, "单击了delete按钮", Toast.LENGTH_SHORT).show();
                    }
                    return true;
                });     // 箭头函数（lambda表达式）——接口[只能有一个抽象函数]
                popupMenu.show();
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

        mFirstLinearLayout = findViewById(R.id.first_linear_layout);
        registerForContextMenu(mFirstLinearLayout);
    }

    // 弹出式菜单——触发事件


    // 上下文菜单
    // ctrl + shift + "+ / -": 展开、折叠代码块
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("上下文菜单");
        // 参数1：分组号，参数2：item编号，参数3：顺序编号
        menu.add(1, 1, 1, "保存");
        menu.add(1, 2, 2, "更改");
        menu.add(1, 3, 3, "删除");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == 1) {
            Toast.makeText(this, "人物简介——特长", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onContextItemSelected: 人物简介——特长");
        } else if (item.getItemId() == 2) {
            Toast.makeText(this, "人物简介——战斗力", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onContextItemSelected: 人物简介——战斗力");
        } else if (item.getItemId() == 3) {
            Toast.makeText(this, "人物简介——经典语录", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onContextItemSelected: 人物简介——经典语录");
        }

        return super.onContextItemSelected(item);
    }

    // 选项菜单
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
 * <p>
 * mFirstBtn2 = findViewById(R.id.first_btn2);
 * mFirstBtn2.setOnClickListener(new View.OnClickListener() {
 *
 * @Override public void onClick(View v) {
 * Log.d(TAG, "onClick: Hello");
 * Toast.makeText(FirstActivity.this, "我是严梓桐", Toast.LENGTH_SHORT).show();
 * }
 * });
 */