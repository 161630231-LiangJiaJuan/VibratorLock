package com.example.hasee.vibratorlock.vibratorlock.activity;
/*
 *Created by haseeon 2018/9/14.
 */


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hasee.vibratorlock.R;

public class MainActivity extends Activity {
    private Button btn_lock,btn_pwd,btn_vib;
    @Override
    protected void onCreate(Bundle saveInstanceState) {

        super.onCreate(saveInstanceState);
        setContentView(R.layout.activtity_main);
        initView();
    }

    private void initView() {
        btn_lock=findViewById(R.id.btn_lock);
        btn_pwd=findViewById(R.id.btn_pwd);
        btn_vib=findViewById(R.id.btn_vib);

        btn_lock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,LockActivity.class);
                startActivity(intent);
            }
        });

        btn_pwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,PwdActivity.class);
                startActivity(intent);
            }
        });

        btn_vib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,VibActivity.class);
                startActivity(intent);
            }
        });
    }
}
