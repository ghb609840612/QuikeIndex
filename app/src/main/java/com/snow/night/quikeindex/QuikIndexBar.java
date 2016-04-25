package com.snow.night.quikeindex;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2016/4/25.
 */
public class QuikIndexBar extends View {
    private String[] indexArr = { "A", "B", "C", "D", "E", "F", "G", "H",
            "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
            "V", "W", "X", "Y", "Z" };
    private final int COLOR_DEFAULT= Color.WHITE;
    private  final  int COLOR_PRESS = Color.RED;
    private Paint paint;
    private int viewWidth;
    private float cellHeight;

    public QuikIndexBar(Context context) {
        super(context);
        init();
    }

    public QuikIndexBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public QuikIndexBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    public void init(){
        //初始化画笔
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(16);
        paint.setColor(COLOR_DEFAULT);
    }
    //初始化控件的宽高

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        viewWidth = getMeasuredWidth();
        cellHeight = getMeasuredHeight()*1.0f/indexArr.length;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float x = viewWidth/2;
        for (int i = 0; i <indexArr.length ; i++) {
            String text = indexArr[i];
            float y = cellHeight*i +cellHeight/2+gettextheight(text)/2;
            //判断当前绘制的和index是否一致
            paint.setColor(i==index?COLOR_PRESS:COLOR_DEFAULT);
            canvas.drawText(text,x,y,paint);
        }
    }

    private int gettextheight(String text) {
        Rect bounds = new Rect();
        paint.getTextBounds(text,0,text.length(),bounds);
        return  bounds.height();
    }
        private int index = -1;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                float eventY = event.getY();
                if(index != eventY /cellHeight){
                    index = (int) (eventY /cellHeight);
                    if(index >0 && index<indexArr.length){
                        String letter = indexArr[index];
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                index = -1;
                break;
        }
        invalidate();
        return true;
    }
}
