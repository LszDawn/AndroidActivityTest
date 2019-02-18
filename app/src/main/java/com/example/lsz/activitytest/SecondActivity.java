package com.example.lsz.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        /*//取出第一个活动传递过来的数据
        final Intent intent = getIntent();
        String data = intent.getStringExtra("data");
        Log.d("SecondActivity", data);*/

        //返回数据给FirstActivity
        Button button2 = findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = getIntent();
                intent1.putExtra("data_res", "我回来了！");
                setResult(RESULT_OK, intent1);
                finish();
            }
        });
    }

    //如果是通过返回键返回上一个活动，则可重写onBackPressed方法返回数据
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_res", "我是通过返回键返回来的！");
        setResult(RESULT_OK, intent);
        finish();
    }
}
