package com.shiqian.youknowme.ViewImpl;

import android.app.FragmentManager;
import android.view.View;

/**
 * Created by chenzd on 18-1-5.
 */
public interface BannerActivityView {

    public void setCurrentBannerStyle(int id);

    public FragmentManager getFragmentManager();

    public void setButtonListener();

}
