package com.shiqian.youknowme.Widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import com.shiqian.youknowme.R;

/**
 * Created by chenzd on 17-12-12.
 */
public class MyCircleView extends View {

    private final String Tag = "MyCircleView";

    private int mFirstColor;
    private int mSecondColor;

    private int mCircleWidth;
    private int speed;
    private int progress;

    private Paint paint;

    private boolean isNext = false;
    private boolean isAttachToWindow = false;
    private Object objLock = new Object();

    private Thread t;

    public MyCircleView(Context context) {
        this(context, null);
    }

    public MyCircleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyCircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray arr = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MyCircleView, defStyleAttr, 0);

        int n = arr.length();

        for (int i = 0; i < n; i++) {

            int tempIndex = arr.getIndex(i);

            switch (tempIndex) {

                case R.styleable.MyCircleView_firstColor:
                    mFirstColor = arr.getColor(tempIndex, Color.BLACK);
                    break;
                case R.styleable.MyCircleView_secondColor:
                    mSecondColor = arr.getColor(tempIndex, Color.BLACK);
                    break;
                case R.styleable.MyCircleView_speed:
                    speed = arr.getInt(tempIndex, 20);
                    break;
                case R.styleable.MyCircleView_circleWidth:
                    mCircleWidth = arr.getDimensionPixelSize(tempIndex, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 20, getResources().getDisplayMetrics()));
                    break;
            }
        }
        arr.recycle();

        paint = new Paint();

        t = new Thread(new Runnable() {
            @Override
            public void run() {
//                Log.d(Tag,"enter run");
                while (true) {
//                    Log.d(Tag,"while (true)");

                    synchronized (objLock){

                        if(!isAttachToWindow){
                            try {
                                objLock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        progress++;
                        if (progress >= 360) {
                            progress = 0;
                            isNext = !isNext;
                        }
//                        Log.d(Tag,"postInvalidate");
                        postInvalidate();

                        try {
                            Thread.sleep(speed);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        t.start();

    }

    @Override
    protected void onAttachedToWindow() {
        Log.d(Tag,"onAttachedToWindow");
        super.onAttachedToWindow();
        if(!isAttachToWindow){
            synchronized (objLock){
                isAttachToWindow = true;
                objLock.notifyAll();
            }
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        Log.d(Tag,"onDetachedFromWindow");
        super.onDetachedFromWindow();
        isAttachToWindow = false;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        int center = getMeasuredWidth() / 2;
        int radius = center - mCircleWidth / 2;

        paint.setStrokeWidth(mCircleWidth);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);

        RectF rect = new RectF(center - radius, center - radius, center + radius, center + radius);

        if (!isNext) {
            paint.setColor(mFirstColor);
            canvas.drawCircle(center, center, radius, paint);
            paint.setColor(mSecondColor);
            canvas.drawArc(rect, -90f, progress, false, paint);
        } else {
            paint.setColor(mSecondColor);
            canvas.drawCircle(center, center, radius, paint);
            paint.setColor(mFirstColor);
            canvas.drawArc(rect, -90f, progress, false, paint);
        }

    }
}
