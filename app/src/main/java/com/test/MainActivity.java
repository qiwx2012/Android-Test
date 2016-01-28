package com.test;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;

import com.test.view.CustomView;
import com.test.view.LogicView;
import com.test.view.MyTest;


public class MainActivity extends Activity {

    EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView my = new MyView(this);
//        CustomView view=new CustomView(this);
//        LogicView view=new LogicView(this);
      /*  MyTest view = new MyTest(this);
        view.setBackgroundColor(Color.WHITE);*/

      /*  MyTextView tv = new MyTextView(this);
        tv.setPadding(100,100,100,100);
        tv.setText("你好么的地方的说法是否");
//        setContentView(R.layout.activity_main);
        setContentView(tv);*/
        setContentView(R.layout.activity_main);
        edt = (EditText) findViewById(R.id.edt);
        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TranslateAnimation ts = new TranslateAnimation(0, 10, 0, 0);
                ts.setInterpolator(new CycleInterpolator(10));
                ts.setDuration(500);
                edt.startAnimation(ts);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
