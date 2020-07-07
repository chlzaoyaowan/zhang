package com.example.demo.page;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 所属包：com.example.demo.page
 * 作者：Administrator on 2020/6/22 18:59
 * 邮箱：tzw1109296630@163.com
 */
public abstract class BaseActivity extends AppCompatActivity {

    //初始化组件
    public abstract void initView();
    //初始化数据
    public abstract void initData();
    //初始化监听事件
    public abstract void initListen();

    //显示提示框
    private void showToast(String str,int index){
        Toast.makeText(this,str,index==0?Toast.LENGTH_SHORT:Toast.LENGTH_LONG).show();
    }
}
