package com.zhognong.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.zhognong.R;
import com.zhognong.inter.MyItemClickListener;
import com.zhognong.inter.MyItemLongClickListener;

import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */
public class LeftMenuAdapter  extends RecyclerView.Adapter<LeftMenuAdapter.MyViewHolder>{
    private Context context;
    private MyItemClickListener mItemClickListener;
    private MyItemLongClickListener mItemLongClickListener;
    private List<String> panel_lists;
    public LeftMenuAdapter(Context context,List<String> panel_lists){
        this.context=context;
        this.panel_lists=panel_lists;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                context).inflate(R.layout.item_menu, parent,
                false),mItemClickListener,mItemLongClickListener);
        if(viewType==0){
            holder.sw_local.setVisibility(View.VISIBLE);
        } else if(viewType==panel_lists.size()-1){
            holder.sw_local.setVisibility(View.GONE);
            holder.tv_menu.setVisibility(View.GONE);
            holder.iv_icon.setVisibility(View.GONE);
            holder.bu_login.setVisibility(View.VISIBLE);
        }
        return holder;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tv_menu.setText(panel_lists.get(position));
        if(position==panel_lists.size()-1){
            holder.bu_login.setText(panel_lists.get(position));
        }
    }

    /**
     * 设置Item点击监听
     * @param listener
     */
    public void setOnItemClickListener(MyItemClickListener listener){
        this.mItemClickListener = listener;
    }

    public void setOnItemLongClickListener(MyItemLongClickListener listener){
        this.mItemLongClickListener = listener;
    }

    @Override
    public int getItemCount() {
        return panel_lists.size();
    }



    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener
    {
        private TextView tv_menu;
        private MyItemClickListener mListener;
        private Switch sw_local;
        private ImageView iv_icon;
        private Button bu_login;
        private MyItemLongClickListener mLongClickListener;
        public MyViewHolder(View view, MyItemClickListener listener, MyItemLongClickListener longClickListener)
        {
            super(view);
            this.mListener = listener;
            this.mLongClickListener = longClickListener;
            tv_menu= (TextView) view.findViewById(R.id.tv_menu);
            sw_local= (Switch) view.findViewById(R.id.sw_local);
            iv_icon= (ImageView) view.findViewById(R.id.iv_icon);
            bu_login= (Button) view.findViewById(R.id.bu_login);
            view.setOnClickListener(this);
            view.setOnLongClickListener(this);
        }
        @Override
        public void onClick(View v) {
            if(mListener != null){
                mListener.onItemClick(v,getPosition());
            }
        }

        @Override
        public boolean onLongClick(View v) {
            if(mLongClickListener != null){
                mLongClickListener.onItemLongClick(v, getPosition());
            }
            return true;
        }
    }
}
