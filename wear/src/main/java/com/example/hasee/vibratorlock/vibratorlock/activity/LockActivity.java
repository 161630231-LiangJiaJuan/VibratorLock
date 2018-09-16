package com.example.hasee.vibratorlock.vibratorlock.activity;
/*
 *Created by haseeon 2018/9/14.
 */


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.example.hasee.vibratorlock.R;

public class LockActivity extends Activity {
    private Context context=this;
    @Override
    protected void onCreate(Bundle saveInstanceState) {

        super.onCreate(saveInstanceState);
        setContentView(R.layout.activtity_lock);
        initView();
    }

    private void initView() {
    }
}
