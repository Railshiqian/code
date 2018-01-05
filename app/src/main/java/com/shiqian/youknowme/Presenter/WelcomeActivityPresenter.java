package com.shiqian.youknowme.Presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;

import com.shiqian.youknowme.BannerActivity;
import com.shiqian.youknowme.BaseApp.BasePresenter;
import com.shiqian.youknowme.ViewImpl.WelcomeActivityView;
import com.shiqian.youknowme.WelcomeActivity;

/**
 * Created by chenzd on 17-12-25.
 */
public class WelcomeActivityPresenter extends BasePresenter<WelcomeActivityView> {

    private WelcomeActivityView view;
    private WelcomeHandler handler;

    public WelcomeActivityPresenter(WelcomeActivityView view){
        this.view = view;
        handler = new WelcomeHandler();
    }

    public void goToBannerActivity(){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                view.goToBannerActivity();
            }
        },2000);
    };

    public void cancelHandler(){
        if(handler!=null){
            handler.removeCallbacksAndMessages(null);
        }
    }

    private static class WelcomeHandler extends Handler{
    }

}
