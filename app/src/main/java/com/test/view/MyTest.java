package com.test.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

import java.util.Random;

/**
 * Created by qiwx on 2015/12/4.
 */
public class MyTest extends BaseView {
    private Paint paint = new Paint();
    private float rx = 0;
    MyThread thread;
    RectF rectF = new RectF(0, 60, 100, 160);
    float sweepAngle = 0;
    public MyTest(Context context) {
        super(context);
    }

    public MyTest(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void logic() {
        Random rand = new Random();
        rx = rx + 3;
        if (rx > getWidth()) {
            rx = 0 - paint.measureText("LogicView");
        }
        sweepAngle++;
        if (sweepAngle >= 360) {
            sweepAngle = 0;
        }
        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);
        paint.setARGB(100, r, g, b);

    }

    @Override
    protected void drawSub(Canvas canvas) {
        canvas.drawText("adsfjaskdfasdfasdafa",rx,30,paint);
//        canvas.drawArc(rectF,0,sweepAngle,true,paint);
        canvas.drawRect(rectF,paint);

    }
}
