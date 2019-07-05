package com.bawei.wuxinzhong.xlist;

import android.content.Context;
import android.provider.MediaStore;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * <p>文件描述：<p>
 * <p>作者：吴新仲<p>
 * <p>创建时间：2019/7/3/003<p>
 * <p>更改时间：2019/7/3/003<p>
 */
public class Xlist extends ListView {
    public Xlist(Context context) {
        super(context);
    }

    public Xlist(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Xlist(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
