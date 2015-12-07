package com.test.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * Created by qiwx on 2015/12/4.
 */
public class LogicView extends BaseView {
    private Paint paint = new Paint();
    private float rx = 0;
    MyThread thread;
    RectF rectF = new RectF(0, 60, 100, 160);
    float sweepAngle = 0;

    public LogicView(Context context) {
        super(context);
    }

    public LogicView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setTextSize(30);
        drawSub(canvas);
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
        paint.setARGB(255, r, g, b);
    }

    @Override
    protected void drawSub(Canvas canvas) {
        paint.setTextSize(30);
        canvas.drawText("LogicView", rx, 30, paint);
        canvas.drawArc(rectF,0,sweepAngle,true,paint);
    }

}
