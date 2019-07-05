package com.bawei.wuxinzhong.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.wuxinzhong.R;
import com.bawei.wuxinzhong.bean.BannerBean;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * <p>文件描述：Xlist的适配器<p>
 * <p>作者：吴新仲<p>
 * <p>创建时间：2019/7/3/003<p>
 * <p>更改时间：2019/7/3/003<p>
 */
public class XlistAdapter extends BaseAdapter {
    private List<BannerBean.DataBean.NewsBean> list;
    private Context context;

    public XlistAdapter(List<BannerBean.DataBean.NewsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).type.equals("news")) {
            return 0;
        } else if (list.get(position).type.equals("topnews")) {
            return 1;
        }
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        ViewHolder1 holder1;
        int type = getItemViewType(position);
        switch (type) {
            case 0:
                if (convertView == null) {
                    convertView = View.inflate(context, R.layout.layout_left, null);
                    holder = new ViewHolder();
                    holder.title = convertView.findViewById(R.id.title);
                    holder.publishAt = convertView.findViewById(R.id.publishAt);
                    holder.imageUrl = convertView.findViewById(R.id.imageUrl);
                    convertView.setTag(holder);
                } else {
                    holder = (ViewHolder) convertView.getTag();
                }
                holder.publishAt.setText(list.get(position).publishAt);
                holder.title.setText(list.get(position).title);
                Glide.with(context).load("http://blog.zhaoliang5156.cn/zixunnew/" + list.get(position).imageUrl).into(holder.imageUrl);
                break;
            case 1:
                if (convertView == null) {
                    convertView = View.inflate(context, R.layout.layout_right, null);
                    holder1 = new ViewHolder1();
                    holder1.title1 = convertView.findViewById(R.id.title1);
                    holder1.publishAt1 = convertView.findViewById(R.id.publishAt1);
                    holder1.imageUrl1 = convertView.findViewById(R.id.imageUrl1);
                    convertView.setTag(holder1);
                } else {
                    holder1 = (ViewHolder1) convertView.getTag();
                }
                holder1.publishAt1.setText(list.get(position).publishAt);
                holder1.title1.setText(list.get(position).title);
                Glide.with(context).load("http://blog.zhaoliang5156.cn/zixunnew/" + list.get(position).imageUrl).into(holder1.imageUrl1);
                break;
        }

        return convertView;
    }

    class ViewHolder {
        private ImageView imageUrl;
        private TextView title, publishAt;
    }

    class ViewHolder1 {
        private ImageView imageUrl1;
        private TextView title1, publishAt1;
    }
}
