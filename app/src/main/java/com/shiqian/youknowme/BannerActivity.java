package com.shiqian.youknowme;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;

import com.shiqian.youknowme.BaseApp.MVPBaseActivity;
import com.shiqian.youknowme.Fragment.FriendsFragment;
import com.shiqian.youknowme.Fragment.MsgFragment;
import com.shiqian.youknowme.Fragment.ProfileFragment;
import com.shiqian.youknowme.Presenter.BannerActivityPresenter;
import com.shiqian.youknowme.ViewImpl.BannerActivityView;

public class BannerActivity extends MVPBaseActivity<BannerActivityView, BannerActivityPresenter> implements BannerActivityView, OnClickListener {

    private BannerActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        presenter.setCurrentBanner(R.id.banner_radiobtn_1);
        presenter.setButtonClickListener();

    }

    @Override
    protected BannerActivityPresenter creatPresenter() {
        presenter = new BannerActivityPresenter(this);
        return presenter;
    }

    @Override
    public void setCurrentBannerStyle(int id) {
        ((RadioButton) findViewById(id)).setSelected(true);
    }

    @Override
    public void setButtonListener() {
        findViewById(R.id.banner_radiobtn_1).setOnClickListener(this);
        findViewById(R.id.banner_radiobtn_2).setOnClickListener(this);
        findViewById(R.id.banner_radiobtn_3).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.banner_radiobtn_1:
            case R.id.banner_radiobtn_2:
            case R.id.banner_radiobtn_3:
                presenter.setCurrentBanner(view.getId());
                break;
        }
    }

    @Override
    public void onBackPressed() {
//        goToHome();
        moveTaskToBack(false);
    }

    //abandon
    private void goToHome() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_TASK_ON_HOME);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }
}
