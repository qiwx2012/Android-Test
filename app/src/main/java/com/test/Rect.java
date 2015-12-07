package com.test;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by qiwx on 2015/12/3.
 */
public class Rect extends Contanier {
    private Paint paint = null;

    public Rect() {
        paint = new Paint();
        paint.setColor(Color.RED);
    }

    @Override
    public void childrenView(Canvas canvas) {
        canvas.drawRect(0, 0, 100, 100, paint);
        this.setY(this.getY()+1);
    }
}
