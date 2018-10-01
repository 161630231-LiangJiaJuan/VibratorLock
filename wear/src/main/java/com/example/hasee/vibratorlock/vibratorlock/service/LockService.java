package com.example.hasee.vibratorlock.vibratorlock.service;
/*
 *Created by haseeon 2018/9/18.
 */

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

import com.example.hasee.vibratorlock.vibratorlock.activity.LockActivity;
import com.example.hasee.vibratorlock.vibratorlock.activity.MainActivity;


/**
 * Created by hasee on 2018/7/31.
 */

public class LockService extends Service {
    private  static  final  String TAG ="LockService" ;
    private ScreenOnReceiver screenOnReceiver;
    private ScreenOffReceiver screenOffReceiver;
    public static  boolean screenOnFlag ;

    @Override
    public void onCreate() {
        super.onCreate();
        screenOnFlag=true;
        screenOnReceiver=new ScreenOnReceiver();
        IntentFilter screenOnFilter=new IntentFilter();
        screenOnFilter.addAction("android.intent.action.SCREEN_ON");
        registerReceiver(screenOnReceiver, screenOnFilter);
        screenOffReceiver=new ScreenOffReceiver();
        IntentFilter screenOffFilter=new IntentFilter();
        screenOffFilter.addAction("android.intent.action.SCREEN_OFF");
        registerReceiver(screenOffReceiver, screenOffFilter);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return Service.START_STICKY;
    }
    /**
     * 监听屏幕变亮的广播接收器，变亮就屏蔽系统锁屏

     */
    private class ScreenOnReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action=intent.getAction();
            if(action.equals("android.intent.action.SCREEN_ON")){
                Log.i(TAG,"srceen on");
                screenOnFlag=true;
//                Intent i1=new Intent(context,LockActivity.class);
//                i1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(i1);
            }
        }
    }
    /**
     * 监听屏幕变暗的广播接收器，变暗就启动应用锁屏界面activity
     */
    private class ScreenOffReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            String action=intent.getAction();
            if(action.equals("android.intent.action.SCREEN_OFF")){
                Log.i(TAG,"screen off");
                screenOnFlag=false;
                Intent i1=new Intent(context,LockActivity.class);
                i1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i1);
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(screenOnReceiver);
        unregisterReceiver(screenOffReceiver);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}