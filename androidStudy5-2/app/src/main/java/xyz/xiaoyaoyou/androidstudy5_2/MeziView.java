package xyz.xiaoyaoyou.androidstudy5_2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by Administrator on 2018/7/3 0003.
 */

public class MeziView extends View {
    public float bitmapX;
    public float bitmapY;

    public MeziView(Context context) {
        super(context);

        bitmapX = 0;
        bitmapY = 200;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();

        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),R.drawable.s_jump);

        canvas.drawBitmap(bitmap,bitmapX,bitmapY,paint);

        if(bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }
}
