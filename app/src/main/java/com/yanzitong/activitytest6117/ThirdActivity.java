package com.yanzitong.activitytest6117;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    private Button mThirdBtn1;
    private Button mThirdBtn2;
    private Button mThirdBtn3;
    TextView mThirdShowMsgTV;
    public static final String TAG = "ThirdActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);

        mThirdShowMsgTV = findViewById(R.id.third_show_msg_tv);

        Intent intent3 = getIntent();
        String msgFromSecond = intent3.getStringExtra("second_to_third");
        if (!TextUtils.isEmpty(msgFromSecond)) {
            Log.d(TAG, "收到来自于Second的数据" + msgFromSecond);
            Toast.makeText(this, "收到来自于Second的数据" + msgFromSecond, Toast.LENGTH_SHORT).show();
            mThirdShowMsgTV.setText(msgFromSecond);
        } else {

        }

        mThirdBtn1 = findViewById(R.id.third_btn1);
        mThirdBtn1.setOnClickListener(v -> {    // 项目内部隐式Intent：匹配action和category
            Intent intent = new Intent("com.yanzitong.activitytest6117.action.YZT_FIRST");  // 为FirstActivity定义对应的action
            intent.addCategory("com.yanzitong.activitytest6117.category.YZT_FIRST");
            startActivity(intent);
        });

        mThirdBtn2 = findViewById(R.id.third_btn2);
        mThirdBtn3 = findViewById(R.id.third_btn3);
        mThirdBtn2.setOnClickListener(v -> {
            // 方法二
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.baidu.com"));
            startActivity(intent);
            // 方法一
            /* Uri uri = Uri.parse("https://www.baidu.com");
             * Intent intent = new Intent(Intent.ACTION_VIEW, uri);     // 等价于"Intent intent = new Intent(android.intent.action.VIEW)"
             * startActivity(intent);
             */
        });
        mThirdBtn3.setOnClickListener(v -> {
            Intent intent4 =  new Intent();
            if (TextUtils.isEmpty(msgFromSecond) == false) {
                intent4.putExtra("third_backto_second", "Hi, second! 我收到你的消息了，谢谢，加油！");
            } else {
                intent4.putExtra("third_backto_second", "Hi, second! 我没有收到消息！你想跟我说什么？");
            }
            setResult(RESULT_OK, intent4);
            finish();
//            Intent intent = new Intent(Intent.ACTION_DIAL);
//            intent.setData(Uri.parse("tel:10000"));
//            startActivity(intent);
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