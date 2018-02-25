package com.shiqian.youknowme.model.VersionModel;

import android.content.Context;

import com.shiqian.youknowme.AppUtils.LogUtil;
import com.shiqian.youknowme.model.WebModel.WebUtil;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.HashMap;

import okhttp3.Call;

/**
 * Created by chenzd on 18-2-25.
 */

public class VersionUpdateUtil {

    public interface VersionUpdateCallBack {

        public void onNewVersionChecked(String msg);

        public void isLatestVersion();

        public void onNetWorkError();

    }

    public static void checkVersionUpdate(Context context, final VersionUpdateCallBack callBack) {
        HashMap<String, Object> data = new HashMap<>();
        data.put("current_version", "1");
        new WebUtil().checkUpdate(data, new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                e.printStackTrace();
                callBack.onNetWorkError();
            }

            @Override
            public void onResponse(String response, int id) {
                LogUtil.d("VersionUpdateUtil",response);
                if (1 == 1) {
                    callBack.onNewVersionChecked(response);
                } else {
                    callBack.isLatestVersion();
                }

            }
        });
    }

}
