package com.example.demo;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.demo.R;
import com.example.demo.page.BaseActivity;

import java.util.Random;

public class MainActivity extends BaseActivity {
    private final static String Tag = "MainActivity：";
    //关于TextView组件的id数组
    private int[] textViewId = {R.id.textView,R.id.textView2,R.id.textView3,R.id.textView4,R.id.textView5};
    //颜色数组
    private int[] colorId = {R.color.colorGreen,R.color.colorYellow,R.color.colorBlue,R.color.colorRed,R.color.colorPink,};

    private TextView[] textView = new TextView[textViewId.length];

    private CheckBox checkBox;
    private Random random = new Random();//创建随机数对象
    private boolean flag = true;//处理线程是否停止
    //通过handler更新主线程中的组件值
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            int anInt = random.nextInt(colorId.length);
            textView[msg.arg1].setBackgroundColor(getResources().getColor(colorId[anInt]));
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        initListen();
    }

    @Override
    public void initView() {
        for(int i=0;i<textViewId.length;i++){
            textView[i] = (TextView) findViewById(textViewId[i]);
        }
        checkBox = (CheckBox)findViewById(R.id.checkBox);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListen() {
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Log.d(Tag,isChecked+"");
                    flag = true;
                    Thread thread = new Thread(new MyRunnable());
                    thread.start();
                }else{
                    flag = false;
                }
            }
        });
    }
    //处理颜色变化
    class MyRunnable implements Runnable {
        private int count = 0;
        @Override
        public void run() {
            while (flag){
                Message message = new Message();
                count++;
                if(count >= textViewId.length){
                    count = 0;
                }
                SystemClock.sleep(100);
                message.arg1 = count;
                handler.sendMessage(message);
            }
        }
    }
}
