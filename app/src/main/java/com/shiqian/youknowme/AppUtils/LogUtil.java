package com.shiqian.youknowme.AppUtils;

import android.util.Log;

import com.shiqian.youknowme.Property.Property;

/**
 * Created by chenzd on 17-12-26.
 */
public class LogUtil {

    public void v(String TAG, String msg) {
        if (Property.LOG_SWITCH) {
            Log.v(TAG, msg);
        }
    }

    public void d(String TAG, String msg) {
        if (Property.LOG_SWITCH) {
            Log.d(TAG, msg);
        }
    }

    public void i(String TAG, String msg) {
        if (Property.LOG_SWITCH) {
            Log.i(TAG, msg);
        }
    }

    public void w(String TAG, String msg) {
        if (Property.LOG_SWITCH) {
            Log.w(TAG, msg);
        }
    }

    public void e(String TAG, String msg) {
        if (Property.LOG_SWITCH) {
            Log.e(TAG, msg);
        }
    }

    public void p(String TAG, String msg) {
        if (Property.LOG_SWITCH) {
            Log.w(TAG, msg, new Exception());
        }
    }

}
