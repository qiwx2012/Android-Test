package com.test.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

import com.test.R;

/**
 * Created by qiwx on 2015/12/4.
 */
public class NumText extends BaseView {
    Paint paint = new Paint();
    private int lineNum = 10;
    private int mx;
    private boolean xScrool = false;//默认不滚动

    public NumText(Context context) {
        super(context);
    }

    public NumText(Context context, AttributeSet attrs) {
        super(context, attrs);
        //解析xml属性
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.numText);
        lineNum = ta.getInt(R.styleable.numText_lineNum, 5);
        xScrool=ta.getBoolean(R.styleable.numText_xScrool,false);
        //用完后释放资源
        ta.recycle();
    }

    @Override
    protected void logic() {
        if (xScrool) {
            mx += 3;
            if (mx > getWidth()) {
                mx = (int) -paint.measureText("极客学院");
            }
        }


    }

    @Override
    protected void drawSub(Canvas canvas) {
        for (int i = 0; i < lineNum; i++) {
            int textSize = 30 + i;
            paint.setTextSize(textSize);
            canvas.drawText("极客学院", mx, textSize + textSize * i, paint);
        }


    }
}
