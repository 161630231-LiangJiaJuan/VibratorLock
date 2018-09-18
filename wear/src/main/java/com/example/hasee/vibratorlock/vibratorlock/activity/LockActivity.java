package com.example.hasee.vibratorlock.vibratorlock.activity;
/*
 *Created by haseeon 2018/9/14.
 */


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hasee.vibratorlock.R;
import com.example.hasee.vibratorlock.vibratorlock.SPAppData;
import com.example.hasee.vibratorlock.vibratorlock.util.ToastManager;

public class LockActivity extends Activity {
    private Button btn_0num,btn_1num,btn_2num,btn_3num,btn_4num,btn_5num,btn_6num,btn_7num,btn_8num,btn_9num,btn_del,btn_jing;
    private TextView tv_pwd;
    private String cur_pwd,in_pwd;
//    private long [][]vibArray = {{500,1000,500,1000},{500,1000,500,500},{500,500,500,1000},{500,500,500,500}};
    private long [][]vibArray= new long[5][5];
    private int pwd_len;
    private BtnListener btnListener;
    private Context context=this;

    @Override
    protected void onCreate(Bundle saveInstanceState) {

        super.onCreate(saveInstanceState);
        setContentView(R.layout.activtity_lock);
        initView();
    }

    @Override
    protected void onStart() {

        super.onStart();
        SharedPreferences sp;
        sp=getSharedPreferences(SPAppData.VIBARR,MODE_PRIVATE);
        pwd_len=sp.getInt(SPAppData.VIBLEN,0);
        for (int i=0;i<pwd_len;i++){
            for (int j=0;j<pwd_len;j++){
                vibArray[i][j]=sp.getLong(String.valueOf(SPAppData.VIBARRAY[i][j]),0);
                Log.i("vib arr", String.valueOf(vibArray[i][j]));
            }
        }
        sp=getSharedPreferences(SPAppData.PASSWORD,MODE_PRIVATE);
        cur_pwd=sp.getString(SPAppData.PASSWORD,null);
        if (cur_pwd==null){
            ToastManager.showShortToast(context,"未设置密码");
            Intent intent=new Intent(context,PwdActivity.class);
            startActivity(intent);
        }
        else {
            in_pwd="";
            in_pwd+=GetResult(cur_pwd,1);
        }


    }

    private StringBuffer GetResult(String str, int count) {
        java.util.Random random=new java.util.Random();
        StringBuffer result = new StringBuffer();
        Vibrator vibrator = (Vibrator)this.getSystemService(VIBRATOR_SERVICE);
        for (int i=0;i<count;i++){
            int temp=random.nextInt(pwd_len);
            //vibrator()
            assert vibrator != null;
            vibrator.vibrate(vibArray[temp],-1);
            String ch = String.valueOf(str.charAt(temp));
            ToastManager.showShortToast(context,ch);
            result.append(str.charAt(temp));
        }
        Log.i("GetResult", String.valueOf(result));
        return result;
    }

    private void initView() {
        btn_0num=findViewById(R.id.btn_0num);
        btn_1num=findViewById(R.id.btn_1num);
        btn_2num=findViewById(R.id.btn_2num);
        btn_3num=findViewById(R.id.btn_3num);
        btn_4num=findViewById(R.id.btn_4num);
        btn_5num=findViewById(R.id.btn_5num);
        btn_6num=findViewById(R.id.btn_6num);
        btn_7num=findViewById(R.id.btn_7num);
        btn_8num=findViewById(R.id.btn_8num);
        btn_9num=findViewById(R.id.btn_9num);
        btn_del=findViewById(R.id.btn_del);
        btn_jing=findViewById(R.id.btn_jing);

        btn_0num.setOnClickListener(new BtnListener());
        btn_1num.setOnClickListener(new BtnListener());
        btn_2num.setOnClickListener(new BtnListener());
        btn_3num.setOnClickListener(new BtnListener());
        btn_4num.setOnClickListener(new BtnListener());
        btn_5num.setOnClickListener(new BtnListener());
        btn_6num.setOnClickListener(new BtnListener());
        btn_7num.setOnClickListener(new BtnListener());
        btn_8num.setOnClickListener(new BtnListener());
        btn_9num.setOnClickListener(new BtnListener());
        btn_del.setOnClickListener(new BtnListener());
        btn_jing.setOnClickListener(new BtnListener());

        tv_pwd=findViewById(R.id.tv_pwd);
    }

    public class BtnListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            String str=String.valueOf(tv_pwd.getText());
            int id=v.getId();
            switch (id){
                case R.id.btn_0num:tv_pwd.setText(String.format("%s0", String.valueOf(tv_pwd.getText())));break;
                case R.id.btn_1num:tv_pwd.setText(String.format("%s1", String.valueOf(tv_pwd.getText())));break;
                case R.id.btn_2num:tv_pwd.setText(String.format("%s2", String.valueOf(tv_pwd.getText())));break;
                case R.id.btn_3num:tv_pwd.setText(String.format("%s3", String.valueOf(tv_pwd.getText())));break;
                case R.id.btn_4num:tv_pwd.setText(String.format("%s4", String.valueOf(tv_pwd.getText())));break;
                case R.id.btn_5num:tv_pwd.setText(String.format("%s5", String.valueOf(tv_pwd.getText())));break;
                case R.id.btn_6num:tv_pwd.setText(String.format("%s6", String.valueOf(tv_pwd.getText())));break;
                case R.id.btn_7num:tv_pwd.setText(String.format("%s7", String.valueOf(tv_pwd.getText())));break;
                case R.id.btn_8num:tv_pwd.setText(String.format("%s8", String.valueOf(tv_pwd.getText())));break;
                case R.id.btn_9num:tv_pwd.setText(String.format("%s9", String.valueOf(tv_pwd.getText())));break;
                case R.id.btn_del:
                    if (str.length()==0) return;
                    tv_pwd.setText(str.substring(0,str.length()-1));break;
                case R.id.btn_jing:tv_pwd.setText(String.format("%s1", String.valueOf(tv_pwd.getText())));break;
                default:break;
            }
            tv_pwd.requestFocus();
            if (tv_pwd.length()>cur_pwd.length()){
                ToastManager.showShortToast(context,"密码错误");
                return;
            }
            else if (tv_pwd.length()==cur_pwd.length()){
                unlock();
            }
            else {
                in_pwd+=GetResult(cur_pwd,1);
            }
        }
    }

    private void unlock() {
        if (tv_pwd.getText().toString().equals(in_pwd)){
            finish();
        }
        else {
            tv_pwd.setText("");
            ToastManager.showShortToast(context,"密码错误");
            recreate();
        }
    }
}
