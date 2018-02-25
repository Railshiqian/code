package com.shiqian.youknowme;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import com.shiqian.youknowme.AppUtils.LogUtil;
import com.shiqian.youknowme.BaseApp.MVPBaseActivity;
import com.shiqian.youknowme.Fragment.FriendsFragment;
import com.shiqian.youknowme.Fragment.HasNewVersionFragment;
import com.shiqian.youknowme.Fragment.MsgFragment;
import com.shiqian.youknowme.Fragment.NetWorkErrorFragment;
import com.shiqian.youknowme.Fragment.NoNewVersionFragment;
import com.shiqian.youknowme.Fragment.ProfileFragment;
import com.shiqian.youknowme.Presenter.VersionUpdateActivityPresenter;
import com.shiqian.youknowme.Presenter.WelcomeActivityPresenter;
import com.shiqian.youknowme.ViewImpl.VersionUpdateActivityView;
import com.shiqian.youknowme.ViewImpl.WelcomeActivityView;

/**
 * Created by chenzd on 17-12-25.
 */
public class VersionUpdateActivity extends MVPBaseActivity<VersionUpdateActivityView, VersionUpdateActivityPresenter> implements VersionUpdateActivityView {

    private VersionUpdateActivityPresenter presenter;
    private HasNewVersionFragment mHasNewVersionFragment;
    private NoNewVersionFragment mNoNewVersionFragment;
    private NetWorkErrorFragment mNetworkErrorFragment;
    private FragmentManager fragmentmManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_version_update);
        doOnCreate(getIntent());
    }

    @Override
    protected VersionUpdateActivityPresenter creatPresenter() {
        presenter = new VersionUpdateActivityPresenter(this);
        return presenter;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        doOnCreate(intent);
    }

    private void doOnCreate(Intent intent) {
        setFinishOnTouchOutside(false);
        presenter.init(intent);
    }

    @Override
    public void initFragment(Intent intent) {
        int hasNewVersion = intent.getIntExtra("hasNewVersion", -1);
        LogUtil.d("hasNewVersion is:" + hasNewVersion);
        fragmentmManager = getFragmentManager();
        fragmentTransaction = fragmentmManager.beginTransaction();
        switch (hasNewVersion) {
            case 1:
                hideFragment(mHasNewVersionFragment);
                hideFragment(mNetworkErrorFragment);
                showFragment(1);
                break;
            case 2:
                hideFragment(mHasNewVersionFragment);
                hideFragment(mNetworkErrorFragment);
                showFragment(2);
                break;
            case 3:
                hideFragment(mHasNewVersionFragment);
                hideFragment(mNoNewVersionFragment);
                showFragment(3);
                break;
            default:
                finish();
                fragmentTransaction.commit();
                return;
        }
        fragmentTransaction.commit();
    }

    private void hideFragment(Fragment hideFragment) {
        if (hideFragment != null) {
            fragmentTransaction.hide(hideFragment);
        }
    }

    private void showFragment(int flag) {
        if (flag == 1) {
            if (mHasNewVersionFragment == null) {
                mHasNewVersionFragment = new HasNewVersionFragment();
                fragmentTransaction.add(R.id.version_update_framelayout, mHasNewVersionFragment);
            } else {
                fragmentTransaction.show(mHasNewVersionFragment);
            }
            return;
        }
        if (flag == 2) {
            if (mNoNewVersionFragment == null) {
                mNoNewVersionFragment = new NoNewVersionFragment();
                fragmentTransaction.add(R.id.version_update_framelayout, mNoNewVersionFragment);
            } else {
                fragmentTransaction.show(mNoNewVersionFragment);
            }
            return;
        }
        if (flag == 3) {
            if (mNetworkErrorFragment == null) {
                mNetworkErrorFragment = new NetWorkErrorFragment();
                fragmentTransaction.add(R.id.version_update_framelayout, mNetworkErrorFragment);
            } else {
                fragmentTransaction.show(mNetworkErrorFragment);
            }
            return;
        }
    }

    @Override
    public void onBackPressed() {
        //do nothing
    }
}
