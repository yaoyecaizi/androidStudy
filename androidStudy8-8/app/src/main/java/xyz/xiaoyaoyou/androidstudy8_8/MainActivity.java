package xyz.xiaoyaoyou.androidstudy8_8;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.graphics.Typeface.BOLD;
import static android.graphics.Typeface.BOLD_ITALIC;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView t1 = (TextView)findViewById(R.id.txtOne);
        TextView t2 = (TextView)findViewById(R.id.txtTwo);
        SpannableString span = new SpannableString("红色打电话斜体删除线绿色下划线图片：.");
//        1.设置背景色，setSpan时需要指定的flag，Spanned.SPAN_EXCLUSIVE_EXCLUSIVE(前后都不包括)
        span.setSpan(new ForegroundColorSpan(Color.RED),0,2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        2.用超链接标记文本
        span.setSpan(new URLSpan("tel:4155551212"),2,5,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        3.用样式标记文本（斜体）
        span.setSpan(new StyleSpan(Typeface.BOLD_ITALIC),5,7,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        4.用删除线标记文本
        span.setSpan(new StrikethroughSpan(),7,10,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        5.用下划线标记文本
        span.setSpan(new UnderlineSpan(),10,16,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        6.用颜色标记
        span.setSpan(new ForegroundColorSpan(Color.GREEN),10,13,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

//        7.获取Drawable
        Drawable d = getResources().getDrawable(R.drawable.icon);
        d.setBounds(0,0,d.getIntrinsicWidth(),d.getIntrinsicHeight());

//        8.创建ImageSpan，然后利用ImageSpan来替换文本
        ImageSpan imgspan = new ImageSpan(d,ImageSpan.ALIGN_BASELINE);
        span.setSpan(imgspan,18,19, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        t1.setText(span);
    }
}
