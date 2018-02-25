package com.shiqian.youknowme.Presenter;

import android.app.Activity;
import android.content.Intent;

import com.shiqian.youknowme.BaseApp.BasePresenter;
import com.shiqian.youknowme.ViewImpl.VersionUpdateActivityView;

/**
 * Created by chenzd on 17-12-21.
 */
public class VersionUpdateActivityPresenter extends BasePresenter<VersionUpdateActivityView>{

    private VersionUpdateActivityView view;
    private Activity act;


    public VersionUpdateActivityPresenter(VersionUpdateActivityView view){
        this.view = view;
        act = (Activity) view;
    }

    public void init(Intent intent){
        view.initFragment(intent);
    }

}
