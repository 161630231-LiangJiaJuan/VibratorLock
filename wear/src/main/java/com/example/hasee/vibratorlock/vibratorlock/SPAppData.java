package com.example.hasee.vibratorlock.vibratorlock;
/*
 *Created by haseeon 2018/9/16.
 */


import android.content.Context;
import android.content.SharedPreferences;

public class SPAppData {
    //用户密码
    public static String PASSWORD="1234";

    //保存密码
    public static void SavePwd(Context context,String password){
        SharedPreferences sp=context.getSharedPreferences(PASSWORD,Context.MODE_PRIVATE);
        SharedPreferences.Editor  et=sp.edit();
        et.putString(PASSWORD,password);
        et.apply();

    }
}
