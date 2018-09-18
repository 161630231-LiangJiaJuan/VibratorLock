package com.example.hasee.vibratorlock.vibratorlock.activity;
/*
 *Created by haseeon 2018/9/14.
 */


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.hasee.vibratorlock.R;
import com.example.hasee.vibratorlock.vibratorlock.SPAppData;

public class VibActivity extends Activity{
    private long [][]vibArray = {{500,1000,500,1000},{500,1000,500,500},{500,500,500,1000},{500,500,500,500}};
    private Context context=this;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activtity_vib);
        SPAppData.SaveVibArr(context,vibArray,4);
    }
}
