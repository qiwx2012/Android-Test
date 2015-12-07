package com.test;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by qiwx on 2015/12/3.
 */
public class MyView extends SurfaceView implements SurfaceHolder.Callback {

    private Paint paint;//画笔
    private Contanier contanier = null;
    private Rect rect = null;
    private Circle circle = null;


    public MyView(Context context) {
        super(context);
        contanier = new Contanier();
        rect = new Rect();
        circle = new Circle();
        paint = new Paint();
        contanier.addChildView(rect);
        contanier.addChildView(circle);
        paint.setColor(Color.RED);
        getHolder().addCallback(this);
    }

    public void draw() {
        //绘制图形前是锁定画布
        Canvas canvas = getHolder().lockCanvas();
        canvas.drawColor(Color.WHITE);
        contanier.draw(canvas);
       /* canvas.save();
        canvas.rotate(90, getWidth() / 2, getHeight() / 2);
        canvas.drawRect(0, 0, 100, 100, paint);
        canvas.drawLine(0, getHeight() / 2, getWidth(), getHeight(), paint);
        canvas.restore();
        canvas.drawLine(0,getHeight()/2+100,getWidth(),getHeight()+100,paint);*/
        //执行完后解锁画布
        getHolder().unlockCanvasAndPost(canvas);

    }

    private Timer timer = null;
    private TimerTask task;

    public void startTimer() {
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                draw();
            }
        };
        timer.schedule(task, 100, 100);

    }

    public void stopTimer() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }

    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        startTimer();

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        stopTimer();
    }
}
