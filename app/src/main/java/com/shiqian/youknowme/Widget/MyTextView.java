package com.shiqian.youknowme.Widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.shiqian.youknowme.R;

/**
 * Created by chenzd on 17-12-12.
 */
public class MyTextView extends View {

    private String textTitle;
    private int textColor = Color.BLACK;
    private int textSize;

    private Rect textBound;
    private Paint paint;

    public MyTextView(Context context) {
        this(context, null);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.myview, defStyleAttr, 0);
        int indexCount = arr.length();
        for (int i = 0; i < indexCount; i++) {
            int tempIndex = arr.getIndex(i);
            switch (tempIndex) {
                case R.styleable.myview_textColor:
                    textColor = arr.getColor(tempIndex, Color.BLACK);
                    break;
                case R.styleable.myview_textSize:
                    textSize = arr.getDimensionPixelSize(tempIndex, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
                    break;
                case R.styleable.myview_textTitle:
                    textTitle = arr.getString(tempIndex);
                    break;
            }
        }
        arr.recycle();

        paint = new Paint();
        paint.setTextSize(textSize);
        textBound = new Rect();
        paint.getTextBounds(textTitle, 0, textTitle.length(), textBound);

        setOnClickListener(new OnClickListener() {


            @Override
            public void onClick(View v) {
                textTitle = getRandomString();
                invalidate();
            }
        });

    }

    private String getRandomString() {
        String temp =  (int)(Math.random()*10000)+"";
        int length = temp.length();
        switch (length){
            case 0:
            case 1:
            case 2:
            case 3:
                temp =  getRandomString();
                break;
        }
        return temp;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int heightMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(widthMeasureSpec);

        int width;
        int height;

        if(widthMode == MeasureSpec.EXACTLY){
            width = widthSize;
        }else{
            paint.setTextSize(textSize);
            paint.getTextBounds(textTitle, 0, textTitle.length(), textBound);
            width = textBound.width()+getPaddingLeft()+getPaddingRight();
        }

        if(heightMode == MeasureSpec.EXACTLY){
            height = heightSize;
        }else{
            paint.setTextSize(textSize);
            paint.getTextBounds(textTitle, 0, textTitle.length(), textBound);
            height = textBound.height()+getPaddingTop()+getPaddingBottom();
        }

        setMeasuredDimension(width,height);

//        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
//        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
//        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
//        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
//        int width;
//        int height ;
//        if (widthMode == MeasureSpec.EXACTLY)
//        {
//            width = widthSize;
//        } else
//        {
//            paint.setTextSize(textSize);
//            paint.getTextBounds(textTitle, 0, textTitle.length(), textBound);
//            float textWidth = textBound.width();
//            int desired = (int) (getPaddingLeft() + textWidth + getPaddingRight());
//            width = desired;
//        }
//
//        if (heightMode == MeasureSpec.EXACTLY)
//        {
//            height = heightSize;
//        } else
//        {
//            paint.setTextSize(textSize);
//            paint.getTextBounds(textTitle, 0, textTitle.length(), textBound);
//            float textHeight = textBound.height();
//            int desired = (int) (getPaddingTop() + textHeight + getPaddingBottom());
//            height = desired;
//        }
//
//        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //draw bg
        paint.setColor(Color.YELLOW);
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),paint);

        //draw text
        paint.setColor(textColor);
        canvas.drawText(textTitle,getMeasuredWidth()/2-textBound.width()/2,getMeasuredHeight()/2+textBound.height()/2,paint);


    }
}
