package com.example.hasee.vibratorlock.vibratorlock.util;
/*
 *Created by haseeon 2018/9/16.
 */


import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class VibArrUtil implements Serializable {
    private int iv_1st,iv_2nd,iv_3rd,iv_4th;
    private boolean isClick=false;

    public VibArrUtil() {
    }

    protected VibArrUtil(Parcel in) {
        iv_1st = in.readInt();
        iv_2nd = in.readInt();
        iv_3rd = in.readInt();
        iv_4th = in.readInt();
        isClick = in.readByte() != 0;
    }

//    public static final Creator<VibArrUtil> CREATOR = new Creator<VibArrUtil>() {
//        @Override
//        public VibArrUtil createFromParcel(Parcel in) {
//            return new VibArrUtil(in);
//        }
//
//        @Override
//        public VibArrUtil[] newArray(int size) {
//            return new VibArrUtil[size];
//        }
//    };

    public boolean isClick() {
        return isClick;
    }

    public void setClick(boolean click) {
        isClick = click;
    }

    public int getIv_1st() {
        return iv_1st;
    }

    public void setIv_1st(int iv_1st) {
        this.iv_1st = iv_1st;
    }

    public int getIv_2nd() {
        return iv_2nd;
    }

    public void setIv_2nd(int iv_2nd) {
        this.iv_2nd = iv_2nd;
    }

    public int getIv_3rd() {
        return iv_3rd;
    }

    public void setIv_3rd(int iv_3rd) {
        this.iv_3rd = iv_3rd;
    }

    public int getIv_4th() {
        return iv_4th;
    }

    public void setIv_4th(int iv_4th) {
        this.iv_4th = iv_4th;
    }

//    @Override
//    public int describeContents() {
//        return 0;
//    }

//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeInt(iv_1st);
//        dest.writeInt(iv_2nd);
//        dest.writeInt(iv_3rd);
//        dest.writeInt(iv_4th);
//        dest.writeByte((byte) (isClick ? 1 : 0));
//    }
}
