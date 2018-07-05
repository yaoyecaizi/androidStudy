package xyz.xiaoyaoyou.androidstudy12;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        1.check选择监听
//        RadioGroup radgroup = (RadioGroup)findViewById(R.id.radioGroup);
//        radgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
//                RadioButton radbtn = (RadioButton)findViewById(i);
//                Toast.makeText(getApplicationContext(), "按钮值发生了变化，你选了" + radbtn.getText(), Toast.LENGTH_SHORT).show();
//            }
//        });
//        2.button点击监听
        Button btnchange = (Button)findViewById(R.id.btnpost);
        final RadioGroup radgroup = (RadioGroup)findViewById(R.id.radioGroup);

        btnchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i = 0;i < radgroup.getChildCount();i++) {
                    RadioButton rd = (RadioButton)radgroup.getChildAt(i);
                    if(rd.isChecked()) {
                        Toast.makeText(getApplicationContext(),"点击提交按钮，获取你选择的是：" + rd.getText(),Toast.LENGTH_LONG).show();
                        break;
                    }
                }
            }
        });
    }
}
