package com.lp.moveimageview;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends Activity {

    private int windowWidth;
    private int windowHeight;
    private LayoutParams layoutParams;
    private ImageView img;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        windowWidth = getWindowManager().getDefaultDisplay().getWidth();
        windowHeight = getWindowManager().getDefaultDisplay().getHeight();
        img = (ImageView) findViewById(R.id.imageView1);

        img.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
             layoutParams = (LayoutParams) img.getLayoutParams();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        break;
                    case MotionEvent.ACTION_MOVE:
                        int x_cord = (int) event.getRawX();
                        int y_cord = (int) event.getRawY();

                        if (x_cord > windowWidth) {
                            x_cord = windowWidth;
                        }
                        if (y_cord > windowHeight) {
                            y_cord = windowHeight;
                        }

                        layoutParams.leftMargin = x_cord - 20 ;
                        layoutParams.topMargin = y_cord - 65;

                        img.setLayoutParams(layoutParams);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }
}