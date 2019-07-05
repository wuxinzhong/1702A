package com.bawei.wuxinzhong.fragment;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.bawei.wuxinzhong.R;
import com.bawei.wuxinzhong.adapter.XlistAdapter;
import com.bawei.wuxinzhong.base.BaseFragment;
import com.bawei.wuxinzhong.bean.BannerBean;
import com.bawei.wuxinzhong.util.Utils;
import com.bawei.wuxinzhong.xlist.Xlist;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：吴新仲<p>
 * <p>创建时间：2019/7/3/003<p>
 * <p>更改时间：2019/7/3/003<p>
 */
public class FengFragment extends BaseFragment {

    private Banner banner;
    private Xlist xlist;
    private PullToRefreshScrollView pull;
    private List<BannerBean.DataBean.NewsBean> mNews;
    private List<BannerBean.DataBean.NewsBean> maNews;
    private XlistAdapter mXlistAdapter;
    private List<BannerBean.DataBean.NewsBean> mList;

    @Override
    protected int initLayout1() {
        return R.layout.layout_feng;
    }

    @Override
    protected void initView(View view) {
        banner = view.findViewById(R.id.banner);
        xlist = view.findViewById(R.id.xlist);
        pull = view.findViewById(R.id.pull);
    }

    @Override
    protected void initData() {


        //网络判断
        if (Utils.getInstance().pan(getContext())) {
            Toast.makeText(getContext(), "有网", Toast.LENGTH_SHORT).show();

            pull.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
                AsyncTask<Void, Void, List<BannerBean.DataBean.NewsBean>> asyncTask = new AsyncTask<Void, Void, List<BannerBean.DataBean.NewsBean>>() {
                    @Override
                    protected List<BannerBean.DataBean.NewsBean> doInBackground(Void... voids) {
                        String s = Utils.getInstance().inputStream("http://blog.zhaoliang5156.cn/zixunnew/fengjing?page=1");
                        Gson gson = new Gson();
                        BannerBean bannerBean = gson.fromJson(s, BannerBean.class);
                        mNews = bannerBean.data.news;
                        return mNews;
                    }

                    @Override
                    protected void onPostExecute(List<BannerBean.DataBean.NewsBean> newsBean) {
                        super.onPostExecute(newsBean);
                        banner.setImages(mNews);
                        banner.setImageLoader(new ImageLoader() {
                            @Override
                            public void displayImage(Context context, Object path, ImageView imageView) {
                                BannerBean.DataBean.NewsBean b = (BannerBean.DataBean.NewsBean) path;
                                Glide.with(getContext()).load("http://blog.zhaoliang5156.cn/zixunnew/" + b.imageUrl).into(imageView);
                            }
                        });
                        banner.isAutoPlay(true);
                        banner.setDelayTime(2000);
                        banner.start();
                    }
                }.execute();

                //列表展示
                AsyncTask<Void, Void, List<BannerBean.DataBean.NewsBean>> asyncTask1 = new AsyncTask<Void, Void, List<BannerBean.DataBean.NewsBean>>() {
                    @Override
                    protected List<BannerBean.DataBean.NewsBean> doInBackground(Void... voids) {
                        String s = Utils.getInstance().inputStream("http://blog.zhaoliang5156.cn/zixunnew/fengjing?page=1");
                        Gson gson = new Gson();
                        BannerBean bannerBean = gson.fromJson(s, BannerBean.class);
                        mNews = bannerBean.data.news;
                        return mNews;
                    }

                    @Override
                    protected void onPostExecute(List<BannerBean.DataBean.NewsBean> newsBean) {
                        super.onPostExecute(newsBean);
                        //创建适配器
                        mXlistAdapter = new XlistAdapter(mNews, getContext());
                        xlist.setAdapter(mXlistAdapter);
                    }
                }.execute();

                @Override
                public void onPullDownToRefresh(PullToRefreshBase<ScrollView> pullToRefreshBase) {
                    //轮播图展示
                    AsyncTask<Void, Void, List<BannerBean.DataBean.NewsBean>> asyncTask = new AsyncTask<Void, Void, List<BannerBean.DataBean.NewsBean>>() {
                        @Override
                        protected List<BannerBean.DataBean.NewsBean> doInBackground(Void... voids) {
                            String s = Utils.getInstance().inputStream("http://blog.zhaoliang5156.cn/zixunnew/fengjing?page=1");
                            Gson gson = new Gson();
                            BannerBean bannerBean = gson.fromJson(s, BannerBean.class);
                            mNews = bannerBean.data.news;
                            return mNews;
                        }

                        @Override
                        protected void onPostExecute(List<BannerBean.DataBean.NewsBean> newsBean) {
                            super.onPostExecute(newsBean);
                            banner.setImages(mNews);
                            banner.setImageLoader(new ImageLoader() {
                                @Override
                                public void displayImage(Context context, Object path, ImageView imageView) {
                                    BannerBean.DataBean.NewsBean b = (BannerBean.DataBean.NewsBean) path;
                                    Glide.with(getContext()).load("http://blog.zhaoliang5156.cn/zixunnew/" + b.imageUrl).into(imageView);
                                }
                            });
                            banner.isAutoPlay(true);
                            banner.setDelayTime(2000);
                            banner.start();
                        }
                    }.execute();
                    //列表展示
                    AsyncTask<Void, Void, List<BannerBean.DataBean.NewsBean>> asyncTask1 = new AsyncTask<Void, Void, List<BannerBean.DataBean.NewsBean>>() {
                        @Override
                        protected List<BannerBean.DataBean.NewsBean> doInBackground(Void... voids) {
                            String s = Utils.getInstance().inputStream("http://blog.zhaoliang5156.cn/zixunnew/fengjing?page=1");
                            Gson gson = new Gson();
                            BannerBean bannerBean = gson.fromJson(s, BannerBean.class);
                            mNews = bannerBean.data.news;
                            return mNews;
                        }

                        @Override
                        protected void onPostExecute(List<BannerBean.DataBean.NewsBean> newsBean) {
                            super.onPostExecute(newsBean);
                            //创建适配器
                            mXlistAdapter = new XlistAdapter(mNews, getContext());
                            xlist.setAdapter(mXlistAdapter);
                        }
                    }.execute();
                    pull.onRefreshComplete();
                }

                @Override
                public void onPullUpToRefresh(PullToRefreshBase<ScrollView> pullToRefreshBase) {
                    AsyncTask<Void, Void, List<BannerBean.DataBean.NewsBean>> asyncTask = new AsyncTask<Void, Void, List<BannerBean.DataBean.NewsBean>>() {
                        @Override
                        protected List<BannerBean.DataBean.NewsBean> doInBackground(Void... voids) {
                            String s = Utils.getInstance().inputStream("http://blog.zhaoliang5156.cn/zixunnew/fengjing?page=1");
                            Gson gson = new Gson();
                            BannerBean bannerBean = gson.fromJson(s, BannerBean.class);
                            maNews = bannerBean.data.news;
                            return maNews;
                        }

                        @Override
                        protected void onPostExecute(List<BannerBean.DataBean.NewsBean> newsBean) {
                            super.onPostExecute(newsBean);
                            mNews.addAll(maNews);
                            mXlistAdapter.notifyDataSetChanged();
                        }
                    }.execute();

                    pull.onRefreshComplete();
                }
            });

        } else {
            Toast.makeText(getContext(), "没网", Toast.LENGTH_SHORT).show();
        }
    }

}
