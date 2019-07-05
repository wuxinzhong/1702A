package com.bawei.wuxinzhong.bean;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：吴新仲<p>
 * <p>创建时间：2019/7/3/003<p>
 * <p>更改时间：2019/7/3/003<p>
 */
public class BannerBean {
    public int code;
    public DataBean data;
    public String msg;

    public static class DataBean {
        public List<NewsBean> news;
        public List<NewsBean> topnews;

        public static class NewsBean {

            public boolean comment;
            public int id;
            public String imageUrl;
            public String publishAt;
            public String title;
            public String type;
            public String url;
        }
    }
}
