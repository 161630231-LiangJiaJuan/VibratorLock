package com.example.hasee.vibratorlock.vibratorlock.activity;
/*
 *Created by haseeon 2018/9/14.
 */


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.hasee.vibratorlock.R;
import com.example.hasee.vibratorlock.vibratorlock.SPAppData;
import com.example.hasee.vibratorlock.vibratorlock.adapter.VibArrAdapter;
import com.example.hasee.vibratorlock.vibratorlock.util.ToastManager;
import com.example.hasee.vibratorlock.vibratorlock.util.VibArrUtil;
import com.example.hasee.vibratorlock.vibratorlock.util.VibTimeUtil;

import java.util.ArrayList;
import java.util.List;

public class VibActivity extends Activity{
    private long [][]vibArray = {{500,1000,500,1000},{500,500,500,1000},{500,1000,500,500},{500,500,500,500}};
    private List<VibArrUtil> list=new ArrayList<>();
    private VibArrUtil vib_select;
    private RecyclerView rcv_data;
    private VibArrAdapter vibArrAdapter;
    private int id_longlong=R.mipmap.longlong,id_shortlong=R.mipmap.shortlong,id_shortshort=R.mipmap.shortshort,id_longshort=R.mipmap.longshort;
    private Button btn_test,btn_use,btn_confirm;
    private Context context=this;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activtity_vib);

        initView();
        initData();
    }
    
    private void initView() {
        rcv_data=findViewById(R.id.rcv_data);
        LinearLayoutManager layoutManager=new LinearLayoutManager(context);
        rcv_data.setLayoutManager(layoutManager);
        
        vibArrAdapter=new VibArrAdapter(list, context);
        rcv_data.setAdapter(vibArrAdapter);

        btn_use=findViewById(R.id.btn_use);
        btn_test=findViewById(R.id.btn_test);
        btn_confirm=findViewById(R.id.btn_confirm);
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
//                intent.putExtra("vib_select",vib_select);
                startActivity(intent);
            }
        });

        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmVib();
            }
        });

        vibArrAdapter.setmOnClickListener(new VibArrAdapter.MOnClickListener() {
            @Override
            public void onClick(int position) {
                select(position);
            }
        });
    }

    private void confirmVib() {
        switch (vib_select.getIv_1st()){
            case R.mipmap.longlong:vibArray[0]= new long[]{VibTimeUtil.VIB_STOP, VibTimeUtil.VIB_LONG, VibTimeUtil.VIB_STOP, VibTimeUtil.VIB_LONG};break;
            case R.mipmap.longshort:vibArray[0]=new long[]{VibTimeUtil.VIB_STOP,VibTimeUtil.VIB_LONG,VibTimeUtil.VIB_STOP,VibTimeUtil.VIB_SHORT};break;
            case R.mipmap.shortshort:vibArray[0]=new long[]{VibTimeUtil.VIB_STOP,VibTimeUtil.VIB_SHORT,VibTimeUtil.VIB_STOP,VibTimeUtil.VIB_SHORT};break;
            case R.mipmap.shortlong:vibArray[0]=new long[]{VibTimeUtil.VIB_STOP,VibTimeUtil.VIB_SHORT,VibTimeUtil.VIB_STOP,VibTimeUtil.VIB_LONG};break;
            default:break;
        }
        switch (vib_select.getIv_2nd()){
            case R.mipmap.longlong:vibArray[1]= new long[]{VibTimeUtil.VIB_STOP, VibTimeUtil.VIB_LONG, VibTimeUtil.VIB_STOP, VibTimeUtil.VIB_LONG};break;
            case R.mipmap.longshort:vibArray[1]=new long[]{VibTimeUtil.VIB_STOP,VibTimeUtil.VIB_LONG,VibTimeUtil.VIB_STOP,VibTimeUtil.VIB_SHORT};break;
            case R.mipmap.shortshort:vibArray[1]=new long[]{VibTimeUtil.VIB_STOP,VibTimeUtil.VIB_SHORT,VibTimeUtil.VIB_STOP,VibTimeUtil.VIB_SHORT};break;
            case R.mipmap.shortlong:vibArray[1]=new long[]{VibTimeUtil.VIB_STOP,VibTimeUtil.VIB_SHORT,VibTimeUtil.VIB_STOP,VibTimeUtil.VIB_LONG};break;
            default:break;
        }
        switch (vib_select.getIv_3rd()){
            case R.mipmap.longlong:vibArray[2]= new long[]{VibTimeUtil.VIB_STOP, VibTimeUtil.VIB_LONG, VibTimeUtil.VIB_STOP, VibTimeUtil.VIB_LONG};break;
            case R.mipmap.longshort:vibArray[2]=new long[]{VibTimeUtil.VIB_STOP,VibTimeUtil.VIB_LONG,VibTimeUtil.VIB_STOP,VibTimeUtil.VIB_SHORT};break;
            case R.mipmap.shortshort:vibArray[2]=new long[]{VibTimeUtil.VIB_STOP,VibTimeUtil.VIB_SHORT,VibTimeUtil.VIB_STOP,VibTimeUtil.VIB_SHORT};break;
            case R.mipmap.shortlong:vibArray[2]=new long[]{VibTimeUtil.VIB_STOP,VibTimeUtil.VIB_SHORT,VibTimeUtil.VIB_STOP,VibTimeUtil.VIB_LONG};break;
            default:break;
        }
        switch (vib_select.getIv_4th()) {
            case R.mipmap.longlong:vibArray[3]= new long[]{VibTimeUtil.VIB_STOP, VibTimeUtil.VIB_LONG, VibTimeUtil.VIB_STOP, VibTimeUtil.VIB_LONG};break;
            case R.mipmap.longshort:vibArray[3]=new long[]{VibTimeUtil.VIB_STOP,VibTimeUtil.VIB_LONG,VibTimeUtil.VIB_STOP,VibTimeUtil.VIB_SHORT};break;
            case R.mipmap.shortshort:vibArray[3]=new long[]{VibTimeUtil.VIB_STOP,VibTimeUtil.VIB_SHORT,VibTimeUtil.VIB_STOP,VibTimeUtil.VIB_SHORT};break;
            case R.mipmap.shortlong:vibArray[3]=new long[]{VibTimeUtil.VIB_STOP,VibTimeUtil.VIB_SHORT,VibTimeUtil.VIB_STOP,VibTimeUtil.VIB_LONG};break;
            default:break;
        }
        SharedPreferences sharedPreferences=getSharedPreferences(SPAppData.VIBARR,MODE_PRIVATE);
        ToastManager.showShortToast(context,"选择成功");
        SPAppData.SaveVibArr(context,vibArray,sharedPreferences.getInt(SPAppData.VIBLEN,4));
        SPAppData.SaveVibImg(context,vib_select);
    }

    private void select(int position) {

        SharedPreferences sp=getSharedPreferences(SPAppData.VIBARR,MODE_PRIVATE);
        int length=sp.getInt(SPAppData.VIBLEN,0);
        vib_select=new VibArrUtil();
        vib_select=list.get(position);
        vibArrAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    private void initData() {
        VibArrUtil vibArrUtil0 = new VibArrUtil();
        vibArrUtil0.setIv_1st(id_longlong);
        vibArrUtil0.setIv_2nd(id_longshort);
        vibArrUtil0.setIv_3rd(id_shortlong);
        vibArrUtil0.setIv_4th(id_shortshort);
        list.add(vibArrUtil0);

        VibArrUtil vibArrUtil1 = new VibArrUtil();
        vibArrUtil1.setIv_1st(id_longshort);
        vibArrUtil1.setIv_2nd(id_longshort);
        vibArrUtil1.setIv_3rd(id_shortlong);
        vibArrUtil1.setIv_4th(id_shortshort);
        list.add(vibArrUtil1);

        VibArrUtil vibArrUtil2 = new VibArrUtil();
        vibArrUtil2.setIv_1st(id_longshort);
        vibArrUtil2.setIv_2nd(id_longshort);
        vibArrUtil2.setIv_3rd(id_shortlong);
        vibArrUtil2.setIv_4th(id_longlong);
        list.add(vibArrUtil2);

        vibArrAdapter.notifyDataSetChanged();
    }
}
