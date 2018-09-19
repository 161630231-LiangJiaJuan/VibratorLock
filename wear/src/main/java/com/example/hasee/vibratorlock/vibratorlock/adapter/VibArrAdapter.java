package com.example.hasee.vibratorlock.vibratorlock.adapter;
/*
 *Created by haseeon 2018/9/18.
 */


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.hasee.vibratorlock.R;
import com.example.hasee.vibratorlock.vibratorlock.util.VibArrUtil;

import java.util.ArrayList;
import java.util.List;

public class VibArrAdapter extends RecyclerView.Adapter {
    private List<VibArrUtil> data;

    private Context context;
    private MOnClickListener mOnClickListener;
    public VibArrAdapter(List<VibArrUtil> data, Context context) {
        this.data = data;
        this.context = context;
        for (int i=0;i<data.size();i++){
            data.get(i).setClick(false);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vib_array,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder1, final int position) {
        if (holder1 instanceof ViewHolder){
            ViewHolder holder=(ViewHolder)holder1;
            holder.iv_1st.setImageResource(data.get(position).getIv_1st());
            holder.iv_2nd.setImageResource(data.get(position).getIv_2nd());
            holder.iv_3rd.setImageResource(data.get(position).getIv_3rd());
            holder.iv_4th.setImageResource(data.get(position).getIv_4th());
            holder.llt_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnClickListener.onClick(position);
                    for (int i=0;i<data.size();i++){
                        if (i==position){
                            data.get(i).setClick(true);
                        }
                        else {
                            data.get(i).setClick(false);
                        }
                    }
                    notifyDataSetChanged();
                }
            });
            if (data.get(position).isClick()){
                holder.llt_item.setBackgroundColor(0xff00a0e9);
            }
            else {
                holder.llt_item.setBackgroundColor(0xffffff);
            }
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_1st,iv_2nd,iv_3rd,iv_4th;
        private LinearLayout llt_item;
        public ViewHolder(View itemView) {
            super(itemView);
            iv_1st=itemView.findViewById(R.id.iv_1st);
            iv_2nd=itemView.findViewById(R.id.iv_2nd);
            iv_3rd=itemView.findViewById(R.id.iv_3rd);
            iv_4th=itemView.findViewById(R.id.iv_4th);
            llt_item=itemView.findViewById(R.id.llt_item);
        }
    }

    public interface MOnClickListener{
         void onClick(int position);
    }

    public void setmOnClickListener(MOnClickListener mOnClickListener){
        this.mOnClickListener=mOnClickListener;
    }
}
