package com.bawei.service;

import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

import com.bawei.bean.Beans;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * <p>文件描述：<p>
 * <p>作者：吴新仲<p>
 * <p>创建时间：2019/7/4/004<p>
 * <p>更改时间：2019/7/4/004<p>
 */
public class MyService extends Service {
    public static final String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/downloads";
    public static final String ACTION_START = "ACTION_START";
    public static final String ACTION_STOP = "ACTION_STOP";
    public static final int init = 0;
    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case init:
                    Beans beans = (Beans) msg.obj;
                    Log.i("aaa", "beans" + beans);
                    break;
            }
        }
    };
    private HttpURLConnection mH;
    private RandomAccessFile mFile2;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //获得Activity传过来的参数
        if (ACTION_START.equals(intent.getAction())) {
            Beans b = (Beans) intent.getSerializableExtra("beans");
            Log.i("aaa", "start" + b.toString());
            //启动初始化线程
            new BeansThread(b).start();
        } else if (ACTION_STOP.equals(intent.getAction())) {
            Beans b = (Beans) intent.getSerializableExtra("beans");
            Log.i("aaa", "stop" + b.toString());
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    //初始化子线程
    class BeansThread extends Thread {
        private Beans bean = null;

        public BeansThread(Beans bean) {
            this.bean = bean;
        }

        @Override
        public void run() {
            try {
                URL url = new URL(bean.getUrl());
                mH = (HttpURLConnection) url.openConnection();
                mH.setRequestMethod("GET");
                mH.setConnectTimeout(3000);
                int code = mH.getResponseCode();
                int length = -1;
                if (code == 200) {
                    length = mH.getContentLength();
                }
                if (length <= 0) {
                    return;
                }
                File file = new File(path);
                if (file.exists()) {
                    file.mkdir();
                }
                //在本地创建文件
                File file1 = new File(file, bean.getFileName());
                mFile2 = new RandomAccessFile(file1, "rwd");
                //设置长度
                mFile2.setLength(length);

                bean.setLength(length);
                handler.obtainMessage(init, bean).sendToTarget();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    mFile2.close();
                    mH.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
