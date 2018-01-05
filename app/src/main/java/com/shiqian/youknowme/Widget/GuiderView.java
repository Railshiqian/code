package com.shiqian.youknowme.Widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by chenzd on 17-12-25.
 * wanna to show a persistent draw text ,to be done
 */
public class GuiderView extends View {

    public GuiderView(Context context) {
        this(context, null);
    }

    public GuiderView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GuiderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);



    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


    }
}
