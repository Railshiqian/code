package com.shiqian.youknowme.Presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.shiqian.youknowme.AppUtils.ToastUtil;
import com.shiqian.youknowme.BannerActivity;
import com.shiqian.youknowme.BaseApp.BasePresenter;
import com.shiqian.youknowme.LoginActivity;
import com.shiqian.youknowme.LoginOrRegisterActivity;
import com.shiqian.youknowme.R;
import com.shiqian.youknowme.RegisterActivity;
import com.shiqian.youknowme.ViewImpl.LoginOrRegisterActivityView;
import com.shiqian.youknowme.ViewImpl.WelcomeActivityView;
import com.shiqian.youknowme.model.DbModel.DbUtil;

/**
 * Created by chenzd on 17-12-25.
 */
public class LoginOrRegisterActivityPresenter extends BasePresenter<LoginOrRegisterActivityView> implements View.OnClickListener {

    private LoginOrRegisterActivityView view;
    private Context context;

    public LoginOrRegisterActivityPresenter(LoginOrRegisterActivityView view) {
        this.view = view;
        context = (Context) view;
    }

    public void addButtonClickListener() {
        ((Activity) view).findViewById(R.id.login_or_register_btn_login).setOnClickListener(this);
        ((Activity) view).findViewById(R.id.login_or_register_btn_register).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_or_register_btn_login:
                gotoLoginActivity();
                break;
            case R.id.login_or_register_btn_register:
                gotoRegisterActivity();
                break;
        }
    }

    private void gotoLoginActivity() {
        Intent intent = new Intent(context, LoginActivity.class);
        ((Activity)view).startActivityForResult(intent,1);
//        context.startActivity(intent);
    }

    private void gotoRegisterActivity() {
        Intent intent = new Intent(context, RegisterActivity.class);
        ((Activity)view).startActivityForResult(intent,2);
//        context.startActivity(intent);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode!=Activity.RESULT_OK)return;
        if(requestCode == 1){
            ToastUtil.toast((Context) view,context.getResources().getString(R.string.login_success), Toast.LENGTH_SHORT);
            gotoBannerActivity();
            ((Activity)view).finish();
        }

        if(requestCode == 2){
            ToastUtil.toast((Context) view,context.getResources().getString(R.string.register_success), Toast.LENGTH_SHORT);
            gotoLoginActivity();
        }


    }

    private void gotoBannerActivity() {
        Intent intent = new Intent(context, BannerActivity.class);
        ((Activity)view).startActivity(intent);
    }


}
