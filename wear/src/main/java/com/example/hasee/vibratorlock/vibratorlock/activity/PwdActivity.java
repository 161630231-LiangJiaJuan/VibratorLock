package com.example.hasee.vibratorlock.vibratorlock.activity;
/*
 *Created by haseeon 2018/9/14.
 */


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hasee.vibratorlock.R;
import com.example.hasee.vibratorlock.vibratorlock.SPAppData;
import com.example.hasee.vibratorlock.vibratorlock.util.ToastManager;
import com.example.hasee.vibratorlock.vibratorlock.view.ClearEditText;


public class PwdActivity  extends Activity{
    private ClearEditText et_oldPwd,et_newPwd,et_rePwd;
    private Button btn_confirm;
    private Context context=this;
    private boolean isFirstRun;
    @Override
    protected void onCreate(Bundle saveInstanceState) {

        super.onCreate(saveInstanceState);
        setContentView(R.layout.activtity_pwd);
        SharedPreferences sp=getSharedPreferences(SPAppData.FIRST_RUN,MODE_PRIVATE);
        isFirstRun=sp.getBoolean(SPAppData.FIRST_RUN,true);
        initView();
    }

    private void initView() {
        et_oldPwd=findViewById(R.id.et_oldPwd);
        et_newPwd=findViewById(R.id.et_newPwd);
        et_rePwd=findViewById(R.id.et_rePwd);
        btn_confirm=findViewById(R.id.btn_confirm);

        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmPwd();
            }
        });
        if (isFirstRun){
            et_oldPwd.setVisibility(View.GONE);
        }
    }

    private void confirmPwd() {
        SharedPreferences sp=getSharedPreferences(SPAppData.PASSWORD,MODE_PRIVATE);
        String cur_pwd=sp.getString(SPAppData.PASSWORD,"1234");

        if (isFirstRun){
            if(! et_newPwd.getText().toString().equals(et_rePwd.getText().toString())){
                ToastManager.showShortToast(context,"两次密码输入不一致");
                return;
            }
            else{
                SPAppData.SavePwd(context,et_newPwd.getText().toString());
                ToastManager.showShortToast(context,"设置密码成功,现密码"+sp.getString(SPAppData.PASSWORD,null));
                SPAppData.SaveRunStatus(context,false);
                return;
            }
        }

        if (!et_oldPwd.getText().toString().equals(cur_pwd)){
            ToastManager.showShortToast(context,"旧的密码错误");
            return;
        }
        else{
            if(! et_newPwd.getText().toString().equals(et_rePwd.getText().toString())){
                ToastManager.showShortToast(context,"两次密码输入不一致");
                return;
            }
            else{
                SPAppData.SavePwd(context,et_newPwd.getText().toString());
                ToastManager.showShortToast(context,"设置密码成功,现密码"+sp.getString(SPAppData.PASSWORD,null));
                return;
            }
        }
    }
}
