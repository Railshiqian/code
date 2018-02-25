package com.shiqian.youknowme.model.WebModel;

import android.content.Context;

import com.shiqian.youknowme.AppUtils.EncryptUtil;
import com.shiqian.youknowme.Property.Property;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by chenzd on 18-1-23.
 */
public class WebUtil{

    public void register(HashMap<String,Object> data,StringCallback callback){
        doPost(Property.SERVER_URL_REGISTER,data,callback);
    }

    public void login(HashMap<String,Object> data,StringCallback callback){
        doPost(Property.SERVER_URL_LOGIN,data,callback);
    }

    public void checkUpdate(HashMap<String,Object> data,StringCallback callback){
        doPost(Property.SERVER_URL_CHECK_UPDATE,data,callback);
    }


    private void doPost(String url , HashMap<String,Object> data,StringCallback callback){
        OkHttpUtils.post().url(url).addParams("data", EncryptUtil.encryptData(data)).build().execute(callback);
    }

}
