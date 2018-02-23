package com.shiqian.youknowme.BaseApp;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.shiqian.youknowme.model.DbModel.DbUtil;

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
    }
}
