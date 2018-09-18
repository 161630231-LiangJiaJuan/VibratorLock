package com.example.hasee.vibratorlock.vibratorlock.activity;
/*
 *Created by haseeon 2018/9/14.
 */


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.hasee.vibratorlock.R;
import com.example.hasee.vibratorlock.vibratorlock.SPAppData;
import com.example.hasee.vibratorlock.vibratorlock.adapter.VibArrAdapter;
import com.example.hasee.vibratorlock.vibratorlock.util.VibArrUtil;

import java.util.ArrayList;
import java.util.List;

public class VibActivity extends Activity{
    private long [][]vibArray = {{500,1000,500,1000},{500,1000,500,500},{500,500,500,1000},{500,500,500,500}};
    private List<VibArrUtil> list=new ArrayList<>();
    private RecyclerView rcv_data;
    private VibArrAdapter vibArrAdapter;
    private int id_longlong=R.mipmap.longlong,id_shortlong=R.mipmap.shortlong,id_shortshort=R.mipmap.shortshort,id_longshort=R.mipmap.longshort;
    private Button btn_test,btn_use;
    private Context context=this;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activtity_vib);
        SPAppData.SaveVibArr(context,vibArray,4);
        initView();
    }
    
    private void initView() {
        rcv_data=findViewById(R.id.rcv_data);
        LinearLayoutManager layoutManager=new LinearLayoutManager(context);
        rcv_data.setLayoutManager(layoutManager);
        
        vibArrAdapter=new VibArrAdapter(list, context);
        rcv_data.setAdapter(vibArrAdapter);

        btn_use=findViewById(R.id.btn_use);
        btn_test=findViewById(R.id.btn_test);

        btn_use.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,UseActivity.class);
                startActivity(intent);
            }
        });

        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,TestActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }

    private void initData() {
        VibArrUtil vibArrUtil0 = new VibArrUtil();
        vibArrUtil0.setIv_1st(id_longlong);
        vibArrUtil0.setIv_2nd(id_longshort);
        vibArrUtil0.setIv_3rd(id_shortlong);
        vibArrUtil0.setIv_4th(id_shortshort);
        list.add(vibArrUtil0);

        vibArrAdapter.notifyDataSetChanged();
    }
}
