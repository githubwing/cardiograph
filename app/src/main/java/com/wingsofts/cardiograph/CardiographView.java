package com.wingsofts.cardiograph;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by wing on 16/3/30.
 */
public class CardiographView extends View {
    //画笔
    protected Paint mPaint;
    //折现的颜色
    protected int mLineColor = Color.parseColor("#76f112");
    //网格颜色
    protected int mGridColor = Color.parseColor("#1b4200");

    //小网格颜色
    protected int mSGridColor = Color.parseColor("#092100");
    //背景颜色
    protected int mBackgroundColor = Color.BLACK;
    //自身的大小
    protected int mWidth,mHeight;

    //网格宽度
    protected int mGridWidth = 50;
    //小网格的宽度
    protected int mSGridWidth = 10;

    //心电图折现
    protected Path mPath ;

    public CardiographView(Context context) {
        this(context,null);
    }

    public CardiographView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CardiographView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPath = new Path();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        mWidth = w;
        mHeight = h;
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        initBackground(canvas);
    }


    //绘制背景
    private void initBackground(Canvas canvas) {

        canvas.drawColor(mBackgroundColor);
        //画小网格

        //竖线个数
        int vSNum = mWidth /mSGridWidth;

        //横线个数
        int hSNum = mHeight/mSGridWidth;
        mPaint.setColor(mSGridColor);
        mPaint.setStrokeWidth(2);
        //画竖线
        for(int i = 0;i<vSNum+1;i++){
            canvas.drawLine(i*mSGridWidth,0,i*mSGridWidth,mHeight,mPaint);
        }
        //画横线
        for(int i = 0;i<hSNum+1;i++){

            canvas.drawLine(0,i*mSGridWidth,mWidth,i*mSGridWidth,mPaint);
        }

        //竖线个数
        int vNum = mWidth / mGridWidth;
        //横线个数
        int hNum = mHeight / mGridWidth;
        mPaint.setColor(mGridColor);
        mPaint.setStrokeWidth(2);
        //画竖线
        for(int i = 0;i<vNum+1;i++){
            canvas.drawLine(i*mGridWidth,0,i*mGridWidth,mHeight,mPaint);
        }
        //画横线
        for(int i = 0;i<hNum+1;i++){
            canvas.drawLine(0,i*mGridWidth,mWidth,i*mGridWidth,mPaint);
        }


    }
}
