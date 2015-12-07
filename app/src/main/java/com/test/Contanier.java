package com.test;

import android.graphics.Canvas;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiwx on 2015/12/3.
 * 容器
 */
public class Contanier {
    private List<Contanier> children=null;
    private float x=0,y=0;
    public  Contanier(){
        children=new ArrayList<Contanier>();
    }

    public void draw(Canvas canvas){
        canvas.save();
        canvas.translate(getX(), getY());
        childrenView(canvas);
        Log.i("dd","dddd");
        for(Contanier c:children){
            c.draw(canvas);
        }
        canvas.restore();
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void childrenView(Canvas canvas){

    }
    public void addChildView(Contanier child){
        children.add(child);
    }
    public void removeChildView(Contanier child){
        child.removeChildView(child);
    }

}
