package xyz.xiaoyaoyou.androidstudy3_3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Administrator on 2018/6/27 0027.
 */

public class AdActivity extends Activity {

    private ImageView imgCancle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad);
        imgCancle = (ImageView)findViewById(R.id.imgCancle);
        imgCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
