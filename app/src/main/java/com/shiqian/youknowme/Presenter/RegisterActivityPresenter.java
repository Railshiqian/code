package com.shiqian.youknowme.Presenter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;

import com.shiqian.youknowme.AppUtils.LogUtil;
import com.shiqian.youknowme.BaseApp.BasePresenter;
import com.shiqian.youknowme.R;
import com.shiqian.youknowme.ViewImpl.RegisterActivityView;
import com.shiqian.youknowme.model.WebModel.WebUtil;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.HashMap;

import okhttp3.Call;

/**
 * Created by chenzd on 18-02-24.
 */
public class RegisterActivityPresenter extends BasePresenter<RegisterActivityView> implements View.OnClickListener {

    private RegisterActivityView view;
    private Activity act;

    public RegisterActivityPresenter(RegisterActivityView view) {
        this.view = view;
        act = (Activity) view;
    }

    public void addButtonClickListener() {
        act.findViewById(R.id.register_btn_register).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        //register button clicked

        String mNickName = view.getNickNameText();
        String mPhoneNum = view.getPhoneNumText();
        String mPswd = view.getPSWDText();


        if (TextUtils.isEmpty(mNickName)) {
            view.showToast(act.getString(R.string.nickname_is_null));
            view.setFocusedView(R.id.register_edittext_nickname);
            return;
        }

        if (TextUtils.isEmpty(mPhoneNum)) {
            view.showToast(act.getString(R.string.phonenum_is_null));
            view.setFocusedView(R.id.register_edittext_phonenum);
            return;
        }

        if (TextUtils.isEmpty(mPswd)) {
            view.showToast(act.getString(R.string.pswd_is_null));
            view.setFocusedView(R.id.register_edittext_pswd);
            return;
        }

        HashMap<String, Object> data = new HashMap<>();
        data.put("nickname", mNickName);
        data.put("phoneNum", mPhoneNum);
        data.put("pswd", mPswd);
        view.showDialog();
        doRegister(data);
    }

    private void doRegister(HashMap<String, Object> data) {
        new WebUtil().register(data, new StringCallback() {

            @Override
            public void onError(Call call, Exception e, int id) {
                e.printStackTrace();
                LogUtil.d("tag", "onError" + call + e.getStackTrace() + ",id is:" + id);
                view.dismissDialog();
                ((Activity) view).setResult(Activity.RESULT_OK);
                ((Activity) view).finish();
            }

            @Override
            public void onResponse(String response, int id) {
                LogUtil.d("tag", "onResponse，response is :" + response + ",id is:" + id);
                view.dismissDialog();
                ((Activity) view).setResult(Activity.RESULT_OK);
                ((Activity) view).finish();
            }

        });
    }
}
