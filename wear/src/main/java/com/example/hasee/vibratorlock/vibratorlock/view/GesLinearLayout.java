package com.example.hasee.vibratorlock.vibratorlock.view;
/*
 *Created by haseeon 2018/10/1.
 */


import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.example.hasee.vibratorlock.vibratorlock.util.ToastManager;

public class GesLinearLayout extends LinearLayout implements View.OnTouchListener,GestureDetector.OnGestureListener{
    private float mPosX, mPosY, mCurPosX, mCurPosY;//记录mListViewDevice 滑动的位置
    private static final int FLING_MIN_DISTANCE = 20;//mListView  滑动最小距离
    private static final int FLING_MIN_VELOCITY = 200;//mListView 滑动最大速度
    private Context context;
    GestureDetector mygesture ;
    public GesLinearLayout(Context context) {
        super(context);
        this.context=context;
        this.setOnTouchListener(this);
        this.setLongClickable(true);
    }

    public GesLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
    }

    public GesLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr, Context context1) {
        super(context, attrs, defStyleAttr);
        this.context = context1;

    }


    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e1.getX() - e2.getX() > FLING_MIN_DISTANCE){
//                     && Math.abs(velocityX) > FLING_MIN_VELOCITY) {
                ToastManager.showShortToast(context,"left"+String.valueOf(e1.getX() - e2.getX()));
            }
            //向上
            if (e2.getX() - e1.getX() > FLING_MIN_DISTANCE
                    && Math.abs(velocityX) > FLING_MIN_VELOCITY) {
                ToastManager.showShortToast(context,String.valueOf(e1.getX() - e2.getX()));
            }
            return  false;
        }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return mygesture.onTouchEvent(event);
    }
}
