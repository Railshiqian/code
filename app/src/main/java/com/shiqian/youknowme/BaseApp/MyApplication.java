package com.shiqian.youknowme.BaseApp;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.shiqian.youknowme.model.DbModel.DbUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.https.HttpsUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by chenzd on 17-12-25.
 */
public class MyApplication extends Application {

    private DbUtil dbUtil;

    @Override
    public void onCreate() {
        super.onCreate();

        /*init db*/
        dbUtil = DbUtil.getInstance();
        dbUtil.init(getApplicationContext());

        /* init ok http utils from hongyang*/
        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(null, null, null);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
                //其他配置
                .build();
        OkHttpUtils.initClient(okHttpClient);

    }
}
