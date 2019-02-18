package com.example.lsz.activitytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

    //重写onCreateOptionsMenu方法，让菜单显示出来
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //获取MenuInflater对象并调用其inflate方法：参数1指定资源文件,即main.xml.参数2指定添加到哪个menu对象中
        getMenuInflater().inflate(R.menu.main, menu);
        //true表示允许创建的订单显示出来
        return true;
    }

    //重写onOptionsItemSelected方法，让菜单能响应事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this, "你按了添加", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "你按了移除", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }
}