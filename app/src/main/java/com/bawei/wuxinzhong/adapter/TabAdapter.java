package com.bawei.wuxinzhong.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * <p>文件描述：TabLayout的适配器<p>
 * <p>作者：吴新仲<p>
 * <p>创建时间：2019/7/3/003<p>
 * <p>更改时间：2019/7/3/003<p>
 */
public class TabAdapter extends FragmentPagerAdapter {
    private ArrayList<String> title;
    private ArrayList<Fragment> list;

    public TabAdapter(FragmentManager fm, ArrayList<String> title, ArrayList<Fragment> list) {
        super(fm);
        this.title = title;
        this.list = list;
    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
