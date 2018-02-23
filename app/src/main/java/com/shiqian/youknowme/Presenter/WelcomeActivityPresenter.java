package com.shiqian.youknowme.Presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

import com.shiqian.youknowme.BannerActivity;
import com.shiqian.youknowme.BaseApp.BasePresenter;
import com.shiqian.youknowme.LoginActivity;
import com.shiqian.youknowme.ViewImpl.WelcomeActivityView;
import com.shiqian.youknowme.WelcomeActivity;
import com.shiqian.youknowme.model.DbModel.DbUtil;

/**
 * Created by chenzd on 17-12-25.
 */
public class WelcomeActivityPresenter extends BasePresenter<WelcomeActivityView> {

    private WelcomeActivityView view;
    private WelcomeHandler handler;
    private Context context;

    public WelcomeActivityPresenter(WelcomeActivityView view) {
        this.view = view;
        context = (Context) view;
        handler = new WelcomeHandler();
    }

    public void goToLoginOrBannerActivity() {
        if (isLogin()) {
            goToBannerActivity();
        } else {
            goToLoginActivity();
        }
    }

    public void goToBannerActivity() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(context, BannerActivity.class);
                context.startActivity(intent);
                ((Activity)view).finish();
            }
        }, 2000);
    }

    public void goToLoginActivity() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(context, LoginActivity.class);
                context.startActivity(intent);
                ((Activity)view).finish();
            }
        }, 2000);
    }

    public boolean isLogin() {
        return DbUtil.getInstance().getRealId() != null;
    }


    public void cancelHandler() {
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    private static class WelcomeHandler extends Handler {
    }

}
