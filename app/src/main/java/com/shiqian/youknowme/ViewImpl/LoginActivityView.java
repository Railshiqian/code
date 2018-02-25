package com.shiqian.youknowme.ViewImpl;

/**
 * Created by chenzd on 17-12-21.
 */
public interface LoginActivityView {

    public void initView();

    public String getPhoneNumberText();

    public String getPswdText();

    public void setFocusView(int id);

    public void showDialog();

    public void dismissDialog();

}
