package com.bawei.wuxinzhong.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * <p>文件描述：工具类<p>
 * <p>作者：吴新仲<p>
 * <p>创建时间：2019/7/3/003<p>
 * <p>更改时间：2019/7/3/003<p>
 */
public class Utils {
    //单例懒汉
    public Utils() {
    }

    private static Utils obj;

    public synchronized static Utils getInstance() {
        if (obj == null) {
            obj = new Utils();
        }
        return obj;
    }

    //网络判断
    public boolean pan(Context context) {
        if (context != null) {
            ConnectivityManager c = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = c.getActiveNetworkInfo();
            if (networkInfo != null) {
                return networkInfo.isAvailable();
            }
        }
        return false;
    }

    //获取网络数据
    public String inputStream(String s) {
        try {
            URL url = new URL(s);
            HttpURLConnection h = (HttpURLConnection) url.openConnection();
            h.setRequestMethod("GET");
            h.setConnectTimeout(5000);
            h.setReadTimeout(5000);
            int code = h.getResponseCode();
            if (code == 200) {
                InputStream stream = h.getInputStream();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer stringBuffer = new StringBuffer();
                String str = "";
                while ((str = bufferedReader.readLine()) != null) {
                    stringBuffer.append(str);
                }
                bufferedReader.close();
                h.disconnect();
                return stringBuffer.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //获取网络数据,图片
    public String input(String s) {
        try {
            URL url = new URL(s);
            HttpURLConnection h = (HttpURLConnection) url.openConnection();
            h.setRequestMethod("GET");
            h.setConnectTimeout(5000);
            h.setReadTimeout(5000);
            int code = h.getResponseCode();
            if (code == 200) {
                InputStream stream = h.getInputStream();
                BitmapFactory bitmap = new BitmapFactory();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
