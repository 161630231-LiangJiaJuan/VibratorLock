package com.example.hasee.vibratorlock.vibratorlock;
/*
 *Created by haseeon 2018/9/16.
 */


import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

import com.example.hasee.vibratorlock.vibratorlock.util.VibArrUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SPAppData {
    //用户密码
    public static String PASSWORD="password";
    //用户选择的震动序列
    public static String VIBARR="vibarr";
    public static String VIBLEN="viblen";

    //第一次运行程序，设置密码
    public static String FIRST_RUN="first_run";

    //震动序列图形
    public static String VIB_IMG="vib_img";
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

    public static void SaveRunStatus(Context context,boolean isFirstRun){
        SharedPreferences sp=context.getSharedPreferences(FIRST_RUN,Context.MODE_PRIVATE);
        SharedPreferences.Editor et =sp.edit();
        et.putBoolean(FIRST_RUN,isFirstRun);
        et.apply();
    }

    public static void SaveVibImg(Context context, VibArrUtil vibArrUtil){
        SharedPreferences sp=context.getSharedPreferences(VIB_IMG,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(vibArrUtil);
            String Base64VibArrUtil= Base64.encodeToString(baos.toByteArray(),Base64.DEFAULT);
            editor.putString("vibArrUtil",Base64VibArrUtil);
            editor.apply();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
