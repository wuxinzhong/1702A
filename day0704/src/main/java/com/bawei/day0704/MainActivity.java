package com.bawei.day0704;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bawei.bean.Beans;
import com.bawei.service.MyService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textName;
    private ProgressBar bar;
    private Button btnStop;
    private Button btnStart;
    private Beans beans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        textName = (TextView) findViewById(R.id.textName);
        bar = (ProgressBar) findViewById(R.id.bar);
        btnStop = (Button) findViewById(R.id.btnStop);
        btnStart = (Button) findViewById(R.id.btnStart);

        btnStop.setOnClickListener(this);
        btnStart.setOnClickListener(this);
        //创建文件信息对象
        beans = new Beans(0,"http://blog.zhaoliang5156.cn/zixunnew/image/banner1.jpeg",
                            "image/banner1.jpeg",0,0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStop:
                //通过Intent传递参数给Service
                Intent intent = new Intent(MainActivity.this, MyService.class);
                intent.setAction(MyService.ACTION_START);
                intent.putExtra("beans",beans);
                startService(intent);
                break;
            case R.id.btnStart:
                //通过Intent传递参数给Service
                Intent intent1 = new Intent(MainActivity.this, MyService.class);
                intent1.setAction(MyService.ACTION_STOP);
                intent1.putExtra("beans",beans);
                startService(intent1);
                break;
        }
    }
}
