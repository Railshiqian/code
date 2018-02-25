package com.shiqian.youknowme;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.shiqian.youknowme.BaseApp.MVPBaseActivity;
import com.shiqian.youknowme.Presenter.LoginActivityPresenter;
import com.shiqian.youknowme.Presenter.WelcomeActivityPresenter;
import com.shiqian.youknowme.ViewImpl.LoginActivityView;
import com.shiqian.youknowme.ViewImpl.WelcomeActivityView;

/**
 * Created by chenzd on 17-12-25.
 */
public class LoginActivity extends MVPBaseActivity<LoginActivityView,LoginActivityPresenter> implements LoginActivityView {

    private LoginActivityPresenter presenter;
    private EditText etPhoneNum,etPswd;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter.initView();
        presenter.addButtonClickListener();
    }

    @Override
    protected LoginActivityPresenter creatPresenter() {
        presenter = new LoginActivityPresenter(this);
        return presenter;
    }

    @Override
    public void initView() {
        etPhoneNum = (EditText) findViewById(R.id.login_edittext_phonenum);
        etPswd = (EditText) findViewById(R.id.login_edittext_pswd);
    }

    @Override
    public String getPhoneNumberText() {
        return etPhoneNum.getText().toString().trim();
    }

    @Override
    public String getPswdText() {
        return etPswd.getText().toString().trim();
    }

    @Override
    public void setFocusView(int id) {
        findViewById(id).requestFocus();
    }

    @Override
    public void showDialog() {
        if(dialog==null){
            dialog = new AlertDialog.Builder(this).setMessage(getString(R.string.loading)).setCancelable(false).create();
        }
        dialog.show();
    }

    @Override
    public void dismissDialog() {
        if(dialog!=null){
            dialog.dismiss();
        }
    }

}
