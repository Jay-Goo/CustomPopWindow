package jaygoo.custompopwindow.demo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import jaygoo.widget.cpw.ClickableTextView;
import jaygoo.widget.cpw.CustomPopWindow;
import jaygoo.widget.cpw.OnPopItemClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.click_me).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClickableTextView itemTop = new ClickableTextView(MainActivity.this,"这是自定义显示一些内容，你可以自定义它的任何属性，" +
                        "类似微博的效果类似微博的效果类似微博的效果类似微博的效果类似微博的效果",12);

//                itemTop.setHeight(100);
                //自适应
                itemTop.setWrapContent();
                itemTop.setPadding(20);
                itemTop.setTextColor(Color.parseColor("#999999"));

                new CustomPopWindow.Builder(MainActivity.this)
                        .build()
                        .addItem(itemTop, null)
                        .addDivider(Color.parseColor("#dedede"))
                        .addItem(new ClickableTextView(MainActivity.this,"选项一"), new OnPopItemClickListener() {
                            @Override
                            public void onClick(View view) {
                                super.onClick(view);
                                Toast.makeText(getApplicationContext(),"选项一",Toast.LENGTH_LONG).show();
                            }
                        })
                        .addDivider(Color.parseColor("#dedede"))
                        .addItem(new ClickableTextView(MainActivity.this,"选项二"), new OnPopItemClickListener() {
                            @Override
                            public void onClick(View view) {
                                super.onClick(view);
                                Toast.makeText(getApplicationContext(),"选项二",Toast.LENGTH_LONG).show();
                            }
                        })
                        .addDivider(Color.parseColor("#f0f0f0"),8)
                        .addItem(new ClickableTextView(MainActivity.this,"取消"), new OnPopItemClickListener() {
                            @Override
                            public void onClick(View view) {
                                super.onClick(view);
                                Toast.makeText(getApplicationContext(),"取消",Toast.LENGTH_LONG).show();
                            }
                        })
                        .show(findViewById(R.id.bottom));
            }
        });

    }
}
