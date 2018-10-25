package com.example.hasee.vibratorlock.vibratorlock.receiver;
/*
 *Created by haseeon 2018/10/1.
 */


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.hasee.vibratorlock.vibratorlock.activity.LockActivity;

import java.util.Objects;

public class BootCompleteReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Objects.equals(intent.getAction(), "android.intent.action.BOOT_COMPLETED")){
            Intent i=new Intent(context,LockActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }
}
