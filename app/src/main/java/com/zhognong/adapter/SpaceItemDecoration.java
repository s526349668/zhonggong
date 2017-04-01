package com.zhognong.adapter;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Administrator on 2017/3/30.
 */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    int bottom;
    int top;

    /**
     * @param bottom 传入的值
     */
    public SpaceItemDecoration(int bottom,int top) {
        this.bottom = bottom;
        this.top=top;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.bottom = bottom;
        outRect.top=top;


    }
}
