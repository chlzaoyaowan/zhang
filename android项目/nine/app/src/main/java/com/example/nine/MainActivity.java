package com.example.nine;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //图片表
    private int[] imageIds = new int[] { R.drawable.photo1, R.drawable.photo2,
            R.drawable.photo3, R.drawable.photo1, R.drawable.photo2 };// 图片
    private View root;// 布局控件
    private int currentPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        root = findViewById(R.id.root);// 根据id找到控件
        /*root.setBackgroundResource(imageIds[currentPosition]);// 设置默认背景*/

        Button exit = (Button) findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("退出程序")
                        .setMessage("是否退出程序")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                return;
                            }
                        }).create();
                alertDialog.show();
            }
        });
    }
}
