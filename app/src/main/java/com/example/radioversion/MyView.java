package com.example.radioversion;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

class MyPoint {
    float x,y;
    int color;
    String shape;
    MyPoint(float x, float y, int c, String s) {
        this.x = x; this.y = y; this.color = c; this.shape = s;
    }
}

public class MyView extends View {
    private static final int R = 10;
    private ArrayList<MyPoint> mPoints = new ArrayList<>();
    private Paint mPaint = new Paint();

    private static int mCurColor = Color.RED;
    private static String shapes="사각형";


    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public static void setPaintColor(int color) {
        mCurColor = color;
    }

    public static void setPaintShape(String sh) { shapes = sh; }

    @Override
    protected void onDraw(Canvas canvas) {
        for (int i = 0; i < mPoints.size(); i += 1) {
            com.example.radioversion.MyPoint myPoint = mPoints.get(i);
            mPaint.setColor(myPoint.color);
            shapes = myPoint.shape;
            switch(shapes) {
                case "사각형":
                    canvas.drawRect(myPoint.x - R, myPoint.y - R, myPoint.x + R, myPoint.y + R, mPaint);
                    break;
                case "원":
                    canvas.drawCircle(myPoint.x - R, myPoint.y - R, R, mPaint);
                    break;
                case "얇은대각선":
                    canvas.drawLine(myPoint.x - R, myPoint.y - R, myPoint.x + R, myPoint.y + R, mPaint);
                    break;
                case "삼각형":
                    Path m_path = new Path();
                    m_path.moveTo(myPoint.x +3 * R / 2, myPoint.y);
                    m_path.lineTo(myPoint.x + 3 * R, myPoint.y + 3 * R);
                    m_path.lineTo(myPoint.x, myPoint.y + 3 * R);
                    m_path.lineTo(myPoint.x + 3 * R / 2, myPoint.y);
                    m_path.close();
                    canvas.drawPath(m_path, mPaint);
                    break;

            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                mPoints.add(new com.example.radioversion.MyPoint(event.getX(), event.getY(), mCurColor, shapes));
                invalidate();
                return true;
            case MotionEvent.ACTION_UP:
                return true;
        }
        return super.onTouchEvent(event);
    }
}