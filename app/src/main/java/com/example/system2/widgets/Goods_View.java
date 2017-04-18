package com.example.system2.widgets;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

import static android.view.View.MeasureSpec.makeMeasureSpec;

/**
 * Created by 学伟 on 2017/4/17.
 */

public class Goods_View extends RecyclerView {
    public Goods_View(Context context) {
        super(context);
    }
    public Goods_View(Context context, AttributeSet attrs) {
        super(context,attrs);
    }
    public Goods_View(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
