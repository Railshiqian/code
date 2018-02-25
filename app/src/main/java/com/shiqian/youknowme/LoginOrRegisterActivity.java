package com.shiqian.youknowme;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;

import com.shiqian.youknowme.BaseApp.MVPBaseActivity;
import com.shiqian.youknowme.Presenter.LoginOrRegisterActivityPresenter;
import com.shiqian.youknowme.ViewImpl.LoginOrRegisterActivityView;

public class LoginOrRegisterActivity extends MVPBaseActivity<LoginOrRegisterActivityView,LoginOrRegisterActivityPresenter> implements LoginOrRegisterActivityView {

    private LoginOrRegisterActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_or_register);
        presenter.addButtonClickListener();
    }

    @Override
    protected LoginOrRegisterActivityPresenter creatPresenter() {
        presenter = new LoginOrRegisterActivityPresenter(this);
        return presenter;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        presenter.onActivityResult(requestCode,resultCode,data);
    }
}
