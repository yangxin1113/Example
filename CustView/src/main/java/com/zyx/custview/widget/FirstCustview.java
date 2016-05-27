package com.zyx.custview.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.zyx.custview.util.MeasureUtil;

/**
 * Created by zyx on 2016/5/18.
 */
public class FirstCustview extends View {

    private Paint mPaint;// 画笔
    private Context mContext;// 上下文环境引用
    private int radiu;// 圆环半径

    public FirstCustview(Context context) {
        this(context, null);
    }
    public FirstCustview(Context context, AttributeSet attrs){
        super(context, attrs);

        this.mContext = context;
        // 初始化画笔  
        initPaint();
    }

    /**
     * 初始化画笔
     */
    private void initPaint() {
        // 实例化画笔并打开抗锯齿
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    /*
     * 设置画笔样式为描边，圆环嘛……当然不能填充不然就么意思了
     *
     * 画笔样式分三种：
     * 1.Paint.Style.STROKE：描边
     * 2.Paint.Style.FILL_AND_STROKE：描边并填充
     * 3.Paint.Style.FILL：填充
     */
        mPaint.setStyle(Paint.Style.STROKE);

        // 设置画笔颜色为浅灰色
        mPaint.setColor(Color.LTGRAY);

    /*
     * 设置描边的粗细，单位：像素px
     * 注意：当setStrokeWidth(0)的时候描边宽度并不为0而是只占一个像素
     */
        mPaint.setStrokeWidth(10);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 绘制圆环
        canvas.drawCircle(MeasureUtil.getScreenSize((Activity) mContext)[0] / 2,
                MeasureUtil.getScreenSize((Activity) mContext)[1] / 2, radiu, mPaint);
    }

    public synchronized void setRadiu(int radiu) {
        this.radiu = radiu;
        // 重绘
        invalidate();
    }
}
