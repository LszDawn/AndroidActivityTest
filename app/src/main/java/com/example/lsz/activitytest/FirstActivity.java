package com.example.lsz.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //记录活动启动的standard模式
        Log.d("FirstActivity", this.toString());
        //给当前活动加载一个布局
        setContentView(R.layout.first_layout);
        //弹出toast
        //找到布局中的按钮
        Button button1 = (Button) findViewById(R.id.button_1);
        //注册一个监听器
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*//静态方法makeText创建一个Toast对象，再调用show方法
                Toast.makeText(FirstActivity.this, "hey man", Toast.LENGTH_SHORT).show();
                //活动的销毁
                // finish();*/

                //显式Intent：点击按钮启动目标活动,参数1上下文，参数2目标活动。即在FirstActivity的基础上打开SecondActivity
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                //向下一个活动传递数据
                intent.putExtra("data", "你好呀！第二个活动！");

                //返回数据给上一个活动：SecondActivity再传回来
                Intent intent4 = new Intent(FirstActivity.this, SecondActivity.class);
                startActivityForResult(intent4, 1);

                //隐式Intent,一个Intent可以指定多个category,只能指定一个action
                Intent intent1 = new Intent("com.example.lsz.activitytest.ACTION_START");
                intent1.addCategory("com.example.lsz.activitytest.MY_CATEGORY");

                //利用隐式Intent调用系统浏览器打开网页
                Intent intent2 = new Intent(Intent.ACTION_VIEW);//ACTION_VIEW是系统内置的动作
                //setData指定当前intent正在操作的数据，通常以字符串的形式传入到Uri.parse方法中
                intent2.setData(Uri.parse("http://www.baidu.com"));

                //隐式Intent拨打电话
                Intent intent3 = new Intent(Intent.ACTION_DIAL);//ACTION_DIAL打电话
                intent3.setData(Uri.parse("tel:10086"));

                //记录活动启动的standard模式
                Intent intent5 = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent5);
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

    //重写onActivityResult方法得到SecondActivity返回的数据
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case 1:
                if (resultCode == RESULT_OK){
                    String returnData = data.getStringExtra("data_res");
                    Log.d("FirstActivity", returnData);
                }
                break;
        }
    }

    //测试singleTask模式

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("FirstActivity", "First,Restart");
    }
}