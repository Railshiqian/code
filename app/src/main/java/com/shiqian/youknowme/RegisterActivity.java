package com.shiqian.youknowme;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.shiqian.youknowme.AppUtils.ToastUtil;
import com.shiqian.youknowme.BaseApp.MVPBaseActivity;
import com.shiqian.youknowme.Presenter.RegisterActivityPresenter;
import com.shiqian.youknowme.ViewImpl.RegisterActivityView;

/**
 * Created by chenzd on 17-12-25.
 */
public class RegisterActivity extends MVPBaseActivity<RegisterActivityView,RegisterActivityPresenter> implements RegisterActivityView {

    private RegisterActivityPresenter presenter;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        presenter.addButtonClickListener();
    }

    @Override
    protected RegisterActivityPresenter creatPresenter() {
        presenter = new RegisterActivityPresenter(this);
        return presenter;
    }

    @Override
    public String getNickNameText() {
        return ((EditText)findViewById(R.id.register_edittext_nickname)).getText().toString().trim();
    }

    @Override
    public String getPhoneNumText() {
        return ((EditText)findViewById(R.id.register_edittext_phonenum)).getText().toString().trim();
    }

    @Override
    public String getPSWDText() {
        return ((EditText)findViewById(R.id.register_edittext_pswd)).getText().toString().trim();
    }

    @Override
    public void showToast(String msg) {
        ToastUtil.toast(this,msg,Toast.LENGTH_SHORT);
    }

    @Override
    public void setFocusedView(int viewId) {
        findViewById(viewId).requestFocus();
    }

    @Override
    public void showDialog() {
        if(dialog==null){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            dialog = builder.setMessage("Loading").setIcon(R.mipmap.ic_launcher).setCancelable(false).create();
        }
        dialog.show();
    }

    public void dismissDialog(){
        if(dialog!=null){
            dialog.dismiss();
        }
    }

}
