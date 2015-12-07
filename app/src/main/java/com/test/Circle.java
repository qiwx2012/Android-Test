package com.test;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by qiwx on 2015/12/3.
 */
public class Circle extends Contanier {
    private Paint paint=null;

    public Circle() {
        paint=new Paint();
        paint.setColor(Color.BLUE);
    }

    @Override
    public void childrenView(Canvas canvas) {
        canvas.drawCircle(120,120,100,paint);
        this.setY(this.getY()+1);
    }
}
