package com.yanzitong.activitytest6117;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    public static final String TAG = "SecondActivity";
    TextView mSecondShowMsgTV;

    ActivityResultLauncher mLauncher;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        mLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                o -> {
                    if (o.getResultCode() == RESULT_OK && o.getData() != null) {
                        Intent intent = o.getData();
                        String msgBackFromThird = intent.getStringExtra("third_backto_second");
                        Log.d(TAG, "Second收到Third反馈的数据：" + msgBackFromThird);
                    }
                });

        // 判断数据是否接受成功
        Intent intent2 = getIntent();
        String msgFromFirst = intent2.getStringExtra("first_to_second");
        mSecondShowMsgTV = findViewById(R.id.second_show_msg_tv);
        Button mSecondBtn2 = findViewById(R.id.second_btn2);
        mSecondBtn2.setOnClickListener(v -> {
            Intent intent3 = new Intent();
            if (!TextUtils.isEmpty(msgFromFirst)) {
                intent3.putExtra("second_backto_first", "Hi, first! 我收到你的消息了，谢谢，加油！");
            } else {
                intent3.putExtra("second_backto_first", "Hi, first! 我没有收到你的数据，有什么事啊？");
            }
            setResult(RESULT_OK, intent3);
            finish();
        });


        if (TextUtils.isEmpty(msgFromFirst) == false) {
            Log.d(TAG, "收到来自于First的数据" + msgFromFirst);
            Toast.makeText(this, "收到来自于First的数据" + msgFromFirst, Toast.LENGTH_SHORT).show();
            mSecondShowMsgTV.setText(msgFromFirst);
        } else {

        }

        Button mSecondBtn1 = findViewById(R.id.second_btn1);
        mSecondBtn1.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
            intent.putExtra("second_to_third", "Nice to meet you, Third! 我是Second! 6117");

            mLauncher.launch(intent);

//            startActivity(intent);
        });
    }
}

/**
 * your turn:
 * SecondActivity传递数据给ThirdActivity, "Nice to meet you, Third! 我是Second! 6117"
 * 日志、Toast、界面显示数据
 */

/**
 * your turn:
 * 新建UI: third_layout和Java class: thirdActivity
 * 按钮text = "跳转到ThirdActivity"
 * 完成单击事件：实现从 SecondActivity 显式跳转到 ThirdActivity
 */