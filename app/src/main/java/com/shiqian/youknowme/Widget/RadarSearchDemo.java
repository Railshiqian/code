package com.shiqian.youknowme.Widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import com.shiqian.youknowme.R;

/**
 * Created by chenzd on 17-12-13.
 */
public class RadarSearchDemo extends View {

    private Paint mPaint;

    private int progress = -90;
    private int speed = 10;

    private Context context;
    private Bitmap bitmap;
    private Drawable drawable;

    public RadarSearchDemo(Context context) {
        this(context, null);
    }

    public RadarSearchDemo(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RadarSearchDemo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        this.context = context;
        drawable = context.getResources().getDrawable(R.drawable.ratar_bg_green);

        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true){

                    progress = progress+2;
                    if(progress>=360)progress = 0;

                    try {
                        Thread.sleep(speed);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    postInvalidate();
                }


            }
        }).start();

    }


    @Override
    protected void onDraw(Canvas canvas) {

        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.parseColor("#00000000"));
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),mPaint);

//        bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.ratar_bg_green);
//        if(bitmap!=null) {
//            canvas.drawBitmap(bitmap,0,0,mPaint);
//        }
        canvas.rotate(progress,getMeasuredWidth()/2,getMeasuredHeight()/2);
        drawable.setBounds(0,0,getMeasuredWidth(),getMeasuredHeight());
        drawable.draw(canvas);

        canvas.rotate(-progress,getMeasuredWidth()/2,getMeasuredHeight()/2);
        mPaint.setColor(Color.GREEN);
        canvas.drawLine(0,getMeasuredHeight()/2,getMeasuredWidth(),getMeasuredHeight()/2,mPaint);
        canvas.drawLine(getMeasuredWidth()/2,0,getMeasuredWidth()/2,getMeasuredHeight(),mPaint);

        for (int i=1;i<=5;i++){
            mPaint.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(getMeasuredWidth()/2,getMeasuredHeight()/2,getMeasuredWidth()/10*i,mPaint);
        }

        //画弧
//        RectF f = new RectF();
//        mPaint.setStyle(Paint.Style.FILL);
//        mPaint.setAlpha(70);
//        f.set(0,0,getMeasuredWidth(),getMeasuredHeight());
//        canvas.drawArc(f,progress,45,true,mPaint);

//        mPaint.setColor(Color.BLUE);
//        mPaint.setAntiAlias(true);
//        mPaint.setStrokeWidth(getMeasuredWidth()/2);
//        mPaint.setStyle(Paint.Style.STROKE);
//
//        canvas.drawCircle(getMeasuredWidth()/2,getMeasuredHeight()/2,1f,mPaint);





    }

    private interface Point{

        public int getPosition();

        public int getColor();

    }

    private final class PointFactory{

        public PointFactory(){

        };




    }

}
