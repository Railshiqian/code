package com.shiqian.youknowme.BaseApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by chenzd on 17-12-21.
 */
public abstract class MVPBaseActivity<V, T extends BasePresenter<V>> extends Activity {

    protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = creatPresenter();
        mPresenter.attachView((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (mPresenter == null) mPresenter = creatPresenter();
        mPresenter.attachView((V) this);
    }

    protected abstract T creatPresenter();
}
