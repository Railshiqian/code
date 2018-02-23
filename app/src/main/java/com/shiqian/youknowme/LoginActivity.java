package com.shiqian.youknowme;

import android.content.Intent;
import android.os.Bundle;

import com.shiqian.youknowme.BaseApp.MVPBaseActivity;
import com.shiqian.youknowme.Presenter.WelcomeActivityPresenter;
import com.shiqian.youknowme.ViewImpl.WelcomeActivityView;

/**
 * Created by chenzd on 17-12-25.
 */
public class LoginActivity extends MVPBaseActivity<WelcomeActivityView,WelcomeActivityPresenter> implements WelcomeActivityView {

    private WelcomeActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected WelcomeActivityPresenter creatPresenter() {
        presenter = new WelcomeActivityPresenter(this);
        return presenter;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        setIntent(getIntent());
        presenter.goToBannerActivity();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.cancelHandler();
    }

//    @Override
//    public void goToBannerActivity() {
//        Intent intent = new Intent(this, BannerActivity.class);
//        startActivity(intent);
//        finish();
//    }
}
