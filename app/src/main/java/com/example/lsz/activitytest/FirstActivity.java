package com.example.lsz.activitytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //给当前活动加载一个布局
        setContentView(R.layout.first_layout);
        //弹出toast
        //找到布局中的按钮
        Button button1 = (Button) findViewById(R.id.button_1);
        //注册一个监听器
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //静态方法makeText创建一个Toast对象，再调用show方法
                Toast.makeText(FirstActivity.this, "hey man", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
