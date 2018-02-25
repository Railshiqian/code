package com.shiqian.youknowme.AppUtils;

import android.util.Log;

import com.shiqian.youknowme.Property.Property;

/**
 * Created by chenzd on 17-12-26.
 */
public class LogUtil {

    private static final String DEBUG_TAG = "CHENZD_DEBUG";

    public static void v(String TAG, String msg) {
        if (Property.LOG_SWITCH) {
            Log.v(TAG, msg);
        }
    }

    public static void d(String TAG, String msg) {
        if (Property.LOG_SWITCH) {
            Log.d(TAG, msg);
        }
    }

    public static void d(String msg) {
        if (Property.LOG_SWITCH) {
            Log.d(DEBUG_TAG, msg);
        }
    }

    public static void i(String TAG, String msg) {
        if (Property.LOG_SWITCH) {
            Log.i(TAG, msg);
        }
    }

    public static void w(String TAG, String msg) {
        if (Property.LOG_SWITCH) {
            Log.w(TAG, msg);
        }
    }

    public static void e(String TAG, String msg) {
        if (Property.LOG_SWITCH) {
            Log.e(TAG, msg);
        }
    }

    public static void p(String TAG, String msg) {
        if (Property.LOG_SWITCH) {
            Log.w(TAG, msg, new Exception());
        }
    }

}
