package com.bawei.wuxinzhong.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.wuxinzhong.R;
import com.bawei.wuxinzhong.adapter.TabAdapter;
import com.bawei.wuxinzhong.base.BaseActivity;
import com.bawei.wuxinzhong.fragment.FengFragment;
import com.bawei.wuxinzhong.fragment.MeiFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>文件描述：侧滑菜单的打开以及关闭,tabLayout的展示及联动,与ViewPager<p>
 * <p>作者：吴新仲<p>
 * <p>创建时间：2019/7/3/003<p>
 * <p>更改时间：2019/7/3/003<p>
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {

    private ImageView img;
    private TabLayout tab;
    private ViewPager view_page;
    private TextView text1, text5, text3, text4;
    private DrawerLayout draw;
    private ArrayList<String> title = new ArrayList<>();
    private ArrayList<Fragment> list = new ArrayList<>();

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    protected void initView() {
        img = (ImageView) findViewById(R.id.img);
        tab = (TabLayout) findViewById(R.id.tab);
        view_page = (ViewPager) findViewById(R.id.view_page);
        text1 = (TextView) findViewById(R.id.text1);
        text5 = (TextView) findViewById(R.id.text5);
        text3 = (TextView) findViewById(R.id.text3);
        text4 = (TextView) findViewById(R.id.text4);
        draw = (DrawerLayout) findViewById(R.id.draw);

        img.setOnClickListener(this);
        text1.setOnClickListener(this);
        text5.setOnClickListener(this);
        text3.setOnClickListener(this);
        text4.setOnClickListener(this);

    }

    @Override
    protected void initData() {
        //添加TabLayout的数据
        title.add("风景");
        title.add("美女");
        title.add("动漫卡通");
        title.add("娱乐明星");
        title.add("体育");
        title.add("竞技");
        title.add("国足");
        //添加Fragment
        list.add(new FengFragment());
        list.add(new MeiFragment());
        list.add(new MeiFragment());
        list.add(new MeiFragment());
        list.add(new MeiFragment());
        list.add(new MeiFragment());
        list.add(new MeiFragment());

        //创建适配器
        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager(), title, list);
        //设置适配器
        view_page.setAdapter(tabAdapter);
        //绑定
        tab.setupWithViewPager(view_page);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img:
                draw.openDrawer(Gravity.LEFT);
                break;
            case R.id.text1:
                draw.closeDrawer(Gravity.LEFT);
                break;
            case R.id.text3:
                draw.closeDrawer(Gravity.LEFT);
                break;
            case R.id.text4:
                draw.closeDrawer(Gravity.LEFT);
                break;
            case R.id.text5:
                draw.closeDrawer(Gravity.LEFT);
                break;
        }
    }
}
