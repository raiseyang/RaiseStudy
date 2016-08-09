package com.raise.raisestudy.viewpagerroll.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.raise.raisestudy.R;

/**
 * Created by raise.yang on 2016/07/16.
 */
public class DescText extends View {

    private static final int DIRECTION_LEFT = 1;
    private static final int DIRECTION_RIGHT = 2;
    private static final int DIRECTION_NONE = 3;

    private int m_direction;// 半圆方向

    private Paint m_paint;// 画笔

    private String m_desc;// text显示的文字

    public DescText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DescText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        m_direction = DIRECTION_RIGHT;

        m_paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.DescText, defStyleAttr, 0);
        m_desc = ta.getString(ta.getIndex(R.styleable.DescText_android_text));
        ta.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawColor(getResources().getColor(android.R.color.holo_red_dark));
    }
}
