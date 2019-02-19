package com.example.lsz.activitytest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


public class BaseActivity extends AppCompatActivity {


    /**
     * 让其他活动都继承这个BaseActivity,作用是记录当前是哪个activity
     */
    private static final String TAG = "BaseActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, getClass().getSimpleName());
        //创建一个activity，就放入活动管理器，便于管理
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //销毁一个activity，就从活动管理器中移除一个
        ActivityCollector.removeActivity(this);
    }
}
