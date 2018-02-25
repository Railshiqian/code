package com.shiqian.youknowme.AppUtils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by chenzd on 18-2-24.
 */

public class ToastUtil {

    public static void toast(Context context, String msg, int length){
        Toast.makeText(context,msg,length).show();
    }
}
