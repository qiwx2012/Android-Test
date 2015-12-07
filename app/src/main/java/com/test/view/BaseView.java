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
public abstract class BaseView extends View {
    MyThread thread;
    private boolean runing = true;

    public BaseView(Context context) {
        super(context);
    }

    public BaseView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (thread == null) {
            thread = new MyThread();
            thread.start();
        } else {
            drawSub(canvas);
        }
    }

    //绘制业务
    protected abstract void logic();

    //逻辑业务
    protected abstract void drawSub(Canvas canvas);
    //离开屏幕执行
    @Override
    protected void onDetachedFromWindow() {
        runing=false;
        super.onDetachedFromWindow();
    }


    class MyThread extends Thread {

        @Override
        public void run() {
            super.run();
            while (runing) {
                logic();
                postInvalidate();
                try {
                    Thread.sleep(30);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }
    }

}
