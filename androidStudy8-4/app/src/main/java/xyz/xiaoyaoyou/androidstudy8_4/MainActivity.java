package xyz.xiaoyaoyou.androidstudy8_4;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView txtZQD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtZQD = (TextView)findViewById(R.id.txtZQD);
        Drawable[] drawable = txtZQD.getCompoundDrawables();
//        数据下标0-3，依次代表：左上右下
        drawable[1].setBounds(100,0,200,300);
        txtZQD.setCompoundDrawables(drawable[0],drawable[1],drawable[2],drawable[3]);
    }
}


