package com.example.hasee.vibratorlock.vibratorlock;
/*
 *Created by haseeon 2018/9/16.
 */


import android.content.Context;
import android.content.SharedPreferences;

public class SPAppData {
    //用户密码
    public static String PASSWORD="password";
    //用户选择的震动序列
    public static String VIBARR="vibarr";
    public static String VIBLEN="viblen";
    public static long [][]VIBARRAY={{500,1000,500,1000},{500,1000,500,500},{500,500,500,1000},{500,500,500,500}};;
    //保存密码
    public static void SavePwd(Context context,String password){
        SharedPreferences sp=context.getSharedPreferences(PASSWORD,Context.MODE_PRIVATE);
        SharedPreferences.Editor  et=sp.edit();
        et.putString(PASSWORD,password);
        et.apply();
    }

    public static void SaveVibArr(Context context,long [][]vibarr,int length){
        SharedPreferences sp=context.getSharedPreferences(VIBARR,Context.MODE_PRIVATE);
        SharedPreferences.Editor et=sp.edit();
        for (int i=0;i<vibarr.length;i++){
            for (int j=0;j<vibarr[i].length;j++){
                et.putLong(String.valueOf(VIBARRAY[i][j]),vibarr[i][j]);
            }
        }
        et.putInt(VIBLEN,length);
        et.apply();
    }

}
