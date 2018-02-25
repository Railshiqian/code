package com.shiqian.youknowme.ViewImpl;

/**
 * Created by chenzd on 17-12-25.
 */
public interface RegisterActivityView {

    public String getNickNameText();

    public String getPhoneNumText();

    public String getPSWDText();

    public void showToast(String msg);

    public void setFocusedView(int viewId);

    public void showDialog();

    public void dismissDialog();

}
