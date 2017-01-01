package com.example.dumin.zsc.databasedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    @ViewInject(R.id.tv)
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }

    /**
     * 单击事件
     * type默认View.OnClickListener.class，故此处可以简化不写，@Event(R.id.bt_main)
     */
    @Event(value = {R.id.tv})  //多个value的话用数组的形式存放
    private void TextViewClick(View v) {
        textView.setText("TextView.OnClickListener");
    }

    /**
     * 长按事件
     */
    @Event(value = R.id.tv,type = View.OnLongClickListener.class)
    private boolean TextViewLongClick(View v) {
        textView.setText("TextView.OnLongClickListener");
        return true;
    }
}
