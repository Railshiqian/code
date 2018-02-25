package com.shiqian.youknowme.Presenter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.shiqian.youknowme.AppUtils.LogUtil;
import com.shiqian.youknowme.AppUtils.ToastUtil;
import com.shiqian.youknowme.BaseApp.BasePresenter;
import com.shiqian.youknowme.Bean.User;
import com.shiqian.youknowme.R;
import com.shiqian.youknowme.ViewImpl.LoginActivityView;
import com.shiqian.youknowme.ViewImpl.TestActivityView;
import com.shiqian.youknowme.model.DbModel.DbUtil;
import com.shiqian.youknowme.model.WebModel.WebUtil;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by chenzd on 17-12-21.
 */
public class LoginActivityPresenter extends BasePresenter<LoginActivityView> implements View.OnClickListener {

    LoginActivityView view;
    Activity act;

    public LoginActivityPresenter(LoginActivityView view){
        this.view = view;
        act = (Activity) view;
    }

    public void addButtonClickListener(){
        act.findViewById(R.id.login_btn_login).setOnClickListener(this);
    }

    public void initView(){
        view.initView();
    }

    @Override
    public void onClick(View v) {

        String mPhoneNum = view.getPhoneNumberText();
        String mPswd = view.getPswdText();

        if(TextUtils.isEmpty(mPhoneNum)){
            view.setFocusView(R.id.login_edittext_phonenum);
            ToastUtil.toast(act,act.getString(R.string.phonenum_is_null), Toast.LENGTH_SHORT);
            return;
        }

        if(TextUtils.isEmpty(mPswd)){
            view.setFocusView(R.id.login_edittext_pswd);
            ToastUtil.toast(act,act.getString(R.string.pswd_is_null), Toast.LENGTH_SHORT);
            return;
        }

        view.showDialog();

        HashMap<String,Object> data = new HashMap<>();
        data.put("phonenum",mPhoneNum);
        data.put("pswd",mPswd);

        DbUtil.getInstance().saveUserMessage(new User(1l, mPhoneNum,"zhangsan","man"));

        doLogin(data);
    }

    private void doLogin(HashMap<String,Object> data) {

        new WebUtil().login(data, new StringCallback() {

            @Override
            public void onError(Call call, Exception e, int id) {
                LogUtil.d("tag",""+e.getStackTrace());
                view.dismissDialog();
                act.setResult(Activity.RESULT_OK);
                act.finish();
            }

            @Override
            public void onResponse(String response, int id) {
                LogUtil.d("tag",""+response);
                view.dismissDialog();
                act.setResult(Activity.RESULT_OK);
                act.finish();
            }

        });

    }
}
