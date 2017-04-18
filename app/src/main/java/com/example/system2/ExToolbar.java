package com.example.system2;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

/**
 * Created by 学伟 on 2017/1/12.
 */

public class ExToolbar extends Toolbar {
    private float lastX;
    private float lastY;
    public static PopupWindow popupWindow = new PopupWindow();
    public ExToolbar(Context context) {
        super(context);
    }
    public ExToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public ExToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float currentX = event.getX();
        float currentY = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastX = currentX;
                lastY = currentY;
                break;
            case MotionEvent.ACTION_MOVE :
                int biasX = (int)(currentX - lastX);
                int biasY = (int)(currentY - lastY);
                layout(getLeft() + biasX,getTop() + biasY,getRight() + biasX,getBottom() + biasY);
                break;
            case MotionEvent.ACTION_UP:
                popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.setContentView(LayoutInflater.from(this.getContext()).inflate(R.layout.pop_style,null));
                popupWindow.showAsDropDown(this);
                popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
                popupWindow.setOutsideTouchable(false);
                popupWindow.setFocusable(false);
                break;

        }
        return true;
    }
}
