package xyz.xiaoyaoyou.androidstudy10_3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.SystemClock;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ImageButton;

/**
 * Created by Administrator on 2018/7/5 0005.
 */

public class myButton extends AppCompatImageButton {

    private static final int INVALIDATE_DURATION = 15;
    private static int DIFFUSE_GAP = 10;
    private static int TAP_TIMEOUT;

    private int viewWidth,viewHeight;
    private int pointX,pointY;
    private int maxRadio;
    private int shaderRadio;

    private Paint bottomPaint,colorPaint;
    private boolean isPushButton;

    private int eventX,eventY;
    private long downTiem = 0;

    public myButton(Context context, AttributeSet attrs) {
        super(context,attrs);
        initPaint();
        TAP_TIMEOUT = ViewConfiguration.getLongPressTimeout();
    }

    private void initPaint() {
        colorPaint = new Paint();
        bottomPaint = new Paint();
        colorPaint.setColor(getResources().getColor(R.color.reveal_color));
        bottomPaint.setColor(getResources().getColor(R.color.bottom_color));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if(downTiem == 0) downTiem = SystemClock.elapsedRealtime();
                eventX = (int)event.getX();
                eventY = (int)event.getY();

                countMaxRadio();
                isPushButton = true;
                postInvalidateDelayed(INVALIDATE_DURATION);
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                if(SystemClock.elapsedRealtime() - downTiem < TAP_TIMEOUT) {
                    DIFFUSE_GAP = 30;
                    postInvalidate();
                }else{
                    clearData();
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if(!isPushButton) return;

        canvas.drawRect(pointX,pointY,pointX + viewWidth,pointY + viewHeight,bottomPaint);
        canvas.save();

        canvas.clipRect(pointX,pointY,pointX + viewWidth,pointY + viewHeight);
        canvas.drawCircle(eventX,eventY,shaderRadio,colorPaint);
        canvas.restore();

        if(shaderRadio < maxRadio) {
            postInvalidateDelayed(INVALIDATE_DURATION,pointX,pointY,pointX + viewWidth,pointY + viewHeight);
            shaderRadio += DIFFUSE_GAP;
        }else{
            clearData();
        }
    }

    private void countMaxRadio() {
        if(viewWidth > viewHeight) {
            if(eventX < viewWidth/2) {
                maxRadio = viewWidth - eventX;
            }else {
                maxRadio = viewWidth/2 + eventX;
            }
        }else {
            if(eventY < viewHeight/2) {
                maxRadio = viewHeight - eventY;
            }else{
                maxRadio = viewHeight/2 + eventY;
            }
        }
    }

    private void clearData() {
        downTiem = 0;
        DIFFUSE_GAP = 10;
        isPushButton = false;
        shaderRadio = 0;
        postInvalidate();
    }

    @Override
    protected void onSizeChanged(int w,int h,int oldw,int oldh) {
        super.onSizeChanged(w,h,oldw,oldh);
        this.viewWidth = w;
        this.viewHeight = h;
    }
}
