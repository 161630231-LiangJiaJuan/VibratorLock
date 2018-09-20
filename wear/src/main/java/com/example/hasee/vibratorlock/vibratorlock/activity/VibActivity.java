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
        vibArrUtil1.setIv_1st(id_longlong);
        vibArrUtil1.setIv_2nd(id_longshort);
        vibArrUtil1.setIv_3rd(id_shortshort);
        vibArrUtil1.setIv_4th(id_shortlong);
        list.add(vibArrUtil1);

        VibArrUtil vibArrUtil2 = new VibArrUtil();
        vibArrUtil2.setIv_1st(id_longlong);
        vibArrUtil2.setIv_2nd(id_shortlong);
        vibArrUtil2.setIv_3rd(id_longshort);
        vibArrUtil2.setIv_4th(id_shortshort);
        list.add(vibArrUtil2);

        VibArrUtil vibArrUtil3 = new VibArrUtil();
        vibArrUtil3.setIv_1st(id_longlong);
        vibArrUtil3.setIv_2nd(id_shortlong);
        vibArrUtil3.setIv_3rd(id_shortshort);
        vibArrUtil3.setIv_4th(id_longshort);
        list.add(vibArrUtil3);

        VibArrUtil vibArrUtil4 = new VibArrUtil();
        vibArrUtil4.setIv_1st(id_longlong);
        vibArrUtil4.setIv_2nd(id_shortshort);
        vibArrUtil4.setIv_3rd(id_longshort);
        vibArrUtil4.setIv_4th(id_shortlong);
        list.add(vibArrUtil4);

        VibArrUtil vibArrUtil5 = new VibArrUtil();
        vibArrUtil5.setIv_1st(id_longlong);
        vibArrUtil5.setIv_2nd(id_shortshort);
        vibArrUtil5.setIv_3rd(id_shortlong);
        vibArrUtil5.setIv_4th(id_longshort);
        list.add(vibArrUtil5);

        VibArrUtil vibArrUtil6 = new VibArrUtil();
        vibArrUtil6.setIv_1st(id_longshort);
        vibArrUtil6.setIv_2nd(id_longlong);
        vibArrUtil6.setIv_3rd(id_shortlong);
        vibArrUtil6.setIv_4th(id_shortshort);
        list.add(vibArrUtil6);

        VibArrUtil vibArrUtil7 = new VibArrUtil();
        vibArrUtil7.setIv_1st(id_longshort);
        vibArrUtil7.setIv_2nd(id_longlong);
        vibArrUtil7.setIv_3rd(id_shortshort);
        vibArrUtil7.setIv_4th(id_shortlong);
        list.add(vibArrUtil7);

        VibArrUtil vibArrUtil8 = new VibArrUtil();
        vibArrUtil8.setIv_1st(id_longshort);
        vibArrUtil8.setIv_2nd(id_shortlong);
        vibArrUtil8.setIv_3rd(id_longlong);
        vibArrUtil8.setIv_4th(id_shortshort);
        list.add(vibArrUtil8);

        VibArrUtil vibArrUtil9 = new VibArrUtil();
        vibArrUtil9.setIv_1st(id_longshort);
        vibArrUtil9.setIv_2nd(id_shortlong);
        vibArrUtil9.setIv_3rd(id_shortshort);
        vibArrUtil9.setIv_4th(id_longlong);
        list.add(vibArrUtil9);

        VibArrUtil vibArrUtil10 = new VibArrUtil();
        vibArrUtil10.setIv_1st(id_longshort);
        vibArrUtil10.setIv_2nd(id_shortshort);
        vibArrUtil10.setIv_3rd(id_longlong);
        vibArrUtil10.setIv_4th(id_shortlong);
        list.add(vibArrUtil10);

        VibArrUtil vibArrUtil11 = new VibArrUtil();
        vibArrUtil11.setIv_1st(id_longshort);
        vibArrUtil11.setIv_2nd(id_shortshort);
        vibArrUtil11.setIv_3rd(id_shortlong);
        vibArrUtil11.setIv_4th(id_longlong);
        list.add(vibArrUtil11);

        VibArrUtil vibArrUtil12 = new VibArrUtil();
        vibArrUtil12.setIv_1st(id_shortlong);
        vibArrUtil12.setIv_2nd(id_longlong);
        vibArrUtil12.setIv_3rd(id_longshort);
        vibArrUtil12.setIv_4th(id_shortshort);
        list.add(vibArrUtil12);

        VibArrUtil vibArrUtil13 = new VibArrUtil();
        vibArrUtil13.setIv_1st(id_shortlong);
        vibArrUtil13.setIv_2nd(id_longlong);
        vibArrUtil13.setIv_3rd(id_shortshort);
        vibArrUtil13.setIv_4th(id_longshort);
        list.add(vibArrUtil13);

        VibArrUtil vibArrUtil14 = new VibArrUtil();
        vibArrUtil14.setIv_1st(id_shortlong);
        vibArrUtil14.setIv_2nd(id_longshort);
        vibArrUtil14.setIv_3rd(id_longlong);
        vibArrUtil14.setIv_4th(id_shortshort);
        list.add(vibArrUtil14);

        VibArrUtil vibArrUtil15 = new VibArrUtil();
        vibArrUtil15.setIv_1st(id_shortlong);
        vibArrUtil15.setIv_2nd(id_longshort);
        vibArrUtil15.setIv_3rd(id_shortshort);
        vibArrUtil15.setIv_4th(id_longlong);
        list.add(vibArrUtil15);

        VibArrUtil vibArrUtil16 = new VibArrUtil();
        vibArrUtil16.setIv_1st(id_shortlong);
        vibArrUtil16.setIv_2nd(id_shortshort);
        vibArrUtil16.setIv_3rd(id_longlong);
        vibArrUtil16.setIv_4th(id_longshort);
        list.add(vibArrUtil16);

        VibArrUtil vibArrUtil17 = new VibArrUtil();
        vibArrUtil17.setIv_1st(id_shortlong);
        vibArrUtil17.setIv_2nd(id_shortshort);
        vibArrUtil17.setIv_3rd(id_longshort);
        vibArrUtil17.setIv_4th(id_longlong);
        list.add(vibArrUtil17);

        VibArrUtil vibArrUtil18 = new VibArrUtil();
        vibArrUtil18.setIv_1st(id_shortshort);
        vibArrUtil18.setIv_2nd(id_longlong);
        vibArrUtil18.setIv_3rd(id_longshort);
        vibArrUtil18.setIv_4th(id_shortlong);
        list.add(vibArrUtil18);

        VibArrUtil vibArrUtil19 = new VibArrUtil();
        vibArrUtil19.setIv_1st(id_shortshort);
        vibArrUtil19.setIv_2nd(id_longlong);
        vibArrUtil19.setIv_3rd(id_shortlong);
        vibArrUtil19.setIv_4th(id_longshort);
        list.add(vibArrUtil19);

        VibArrUtil vibArrUtil20 = new VibArrUtil();
        vibArrUtil20.setIv_1st(id_shortshort);
        vibArrUtil20.setIv_2nd(id_longshort);
        vibArrUtil20.setIv_3rd(id_longlong);
        vibArrUtil20.setIv_4th(id_shortlong);
        list.add(vibArrUtil20);

        VibArrUtil vibArrUtil21 = new VibArrUtil();
        vibArrUtil21.setIv_1st(id_shortshort);
        vibArrUtil21.setIv_2nd(id_longshort);
        vibArrUtil21.setIv_3rd(id_shortlong);
        vibArrUtil21.setIv_4th(id_longlong);
        list.add(vibArrUtil21);

        VibArrUtil vibArrUtil22 = new VibArrUtil();
        vibArrUtil22.setIv_1st(id_shortshort);
        vibArrUtil22.setIv_2nd(id_shortlong);
        vibArrUtil22.setIv_3rd(id_longlong);
        vibArrUtil22.setIv_4th(id_longshort);
        list.add(vibArrUtil22);

        VibArrUtil vibArrUtil23 = new VibArrUtil();
        vibArrUtil23.setIv_1st(id_shortshort);
        vibArrUtil23.setIv_2nd(id_shortlong);
        vibArrUtil23.setIv_3rd(id_longshort);
        vibArrUtil23.setIv_4th(id_longlong);
        list.add(vibArrUtil23);



        vibArrAdapter.notifyDataSetChanged();
    }
}
