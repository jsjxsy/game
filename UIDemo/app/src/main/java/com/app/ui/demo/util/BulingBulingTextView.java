package com.app.ui.demo.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by wheat7 on 28/04/2017.
 */

public class BulingBulingTextView extends AppCompatTextView {

    private Paint mPaint;
    private Paint mPaint1;
    private Paint mPaint2;
    private float mViewWidth;
    private LinearGradient mLinearGradient;
    private Matrix mGradientMatrix;
    private float mTranslate;

    public BulingBulingTextView(Context context) {
        super(context);
    }

    public BulingBulingTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BulingBulingTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mGradientMatrix != null){
            mTranslate += mViewWidth / 5;
            if (mTranslate > 2 * mViewWidth){
                mTranslate = -mViewWidth;
            }
            mGradientMatrix.setTranslate(mTranslate, 0);
            mLinearGradient.setLocalMatrix(mGradientMatrix);
            postInvalidateDelayed(500);
        }
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (mViewWidth == 0) {
            mViewWidth = getMeasuredWidth();
            if (mViewWidth > 0) {
                mPaint = getPaint();
                mLinearGradient = new LinearGradient(
                        0,
                        0,
                        mViewWidth,
                        0,
                        new int[]{
                                Color.DKGRAY, 0xffffffff,
                                Color.DKGRAY
                        },
                        null,
                        Shader.TileMode.CLAMP);
                mPaint.setShader(mLinearGradient);
                mGradientMatrix = new Matrix();

            }
        }
    }
}
