package xyz.xiaoyaoyou.androidstudy5_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout frame = (FrameLayout)findViewById(R.id.mylayout);
        final MeziView mezi = new MeziView(MainActivity.this);

        mezi.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                mezi.bitmapX = motionEvent.getX() - 150;
                mezi.bitmapY = motionEvent.getY() - 150;

                mezi.invalidate();
                return true;
            }
        });
        frame.addView(mezi);
    }
}
