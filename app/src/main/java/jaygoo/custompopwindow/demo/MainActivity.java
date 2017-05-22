package jaygoo.custompopwindow.demo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import jaygoo.widget.cpw.ClickableTextView;
import jaygoo.widget.cpw.CustomPopWindow;
import jaygoo.widget.cpw.DensityUtils;
import jaygoo.widget.cpw.OnItemClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.click_me).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClickableTextView itemTop = new ClickableTextView(MainActivity.this,"这是自定义显示一些内容，你可以自定义它的任何属性，" +
                        "类似微博的效果",12);
                itemTop.setTextColor(Color.parseColor("#999999"));
                itemTop.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                int padding = DensityUtils.dip2px(20,getApplication());
                itemTop.setPadding(padding,padding,padding,padding);
                new CustomPopWindow.Builder(MainActivity.this)
                        .build()
                        .addItem(itemTop, new OnItemClickListener() {
                            @Override
                            public void onClick(ClickableTextView view) {
                                super.onClick(view);
                                Toast.makeText(getApplicationContext(),"选项一",Toast.LENGTH_LONG).show();
                            }
                        })
                        .addItem(new ClickableTextView(MainActivity.this,"选项一"), new OnItemClickListener() {
                            @Override
                            public void onClick(ClickableTextView view) {
                                super.onClick(view);
                                Toast.makeText(getApplicationContext(),"选项一",Toast.LENGTH_LONG).show();
                            }
                        })
                        .addItem(new ClickableTextView(MainActivity.this,"选项二"), new OnItemClickListener() {
                            @Override
                            public void onClick(ClickableTextView view) {
                                super.onClick(view);
                                Toast.makeText(getApplicationContext(),"点击了2",Toast.LENGTH_LONG).show();
                            }
                        })
                        .show(findViewById(R.id.bottom));
            }
        });

    }
}
