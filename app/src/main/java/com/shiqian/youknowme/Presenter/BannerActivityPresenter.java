package com.shiqian.youknowme.Presenter;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.View;

import com.shiqian.youknowme.BannerActivity;
import com.shiqian.youknowme.BaseApp.BasePresenter;
import com.shiqian.youknowme.Fragment.FriendsFragment;
import com.shiqian.youknowme.Fragment.MsgFragment;
import com.shiqian.youknowme.Fragment.ProfileFragment;
import com.shiqian.youknowme.R;
import com.shiqian.youknowme.ViewImpl.BannerActivityView;

/**
 * Created by chenzd on 18-1-5.
 */
public class BannerActivityPresenter extends BasePresenter<BannerActivityView> {

    private BannerActivityView view;

    private FriendsFragment mFriendsFragment;
    private MsgFragment mMsgFragment;
    private ProfileFragment mProfileFragment;
    private FragmentManager fragmentmManager;
    private FragmentTransaction fragmentTransaction;

    private static final int FRAG_MSG = 1;
    private static final int FRAG_PROFILE = 2;
    private static final int FRAG_FRIENDS = 3;

    private int currentID = -1;

    public BannerActivityPresenter(BannerActivityView view) {
        this.view = view;
        fragmentmManager = view.getFragmentManager();
    }

    public void setCurrentBanner(int buttonID) {
        if (currentID == buttonID) return;
        fragmentTransaction = fragmentmManager.beginTransaction();
        switch (buttonID) {
            case R.id.banner_radiobtn_1:
                if (mProfileFragment != null) {
                    fragmentTransaction.hide(mProfileFragment);
                }

                if (mFriendsFragment != null) {
                    fragmentTransaction.hide(mFriendsFragment);
                }

                if (mMsgFragment == null) {
                    mMsgFragment = new MsgFragment();
                    fragmentTransaction.add(R.id.banner_framelayout, mMsgFragment);
                } else {
                    fragmentTransaction.show(mMsgFragment);
                }

                break;
            case R.id.banner_radiobtn_2:
                if (mProfileFragment != null) {
                    fragmentTransaction.hide(mProfileFragment);
                }

                if (mMsgFragment != null) {
                    fragmentTransaction.hide(mMsgFragment);
                }

                if (mFriendsFragment == null) {
                    mFriendsFragment = new FriendsFragment();
                    fragmentTransaction.add(R.id.banner_framelayout, mFriendsFragment);
                } else {
                    fragmentTransaction.show(mFriendsFragment);
                }

                break;
            case R.id.banner_radiobtn_3:
                if (mMsgFragment != null) {
                    fragmentTransaction.hide(mMsgFragment);
                }

                if (mFriendsFragment != null) {
                    fragmentTransaction.hide(mFriendsFragment);
                }

                if (mProfileFragment == null) {
                    mProfileFragment = new ProfileFragment();
                    fragmentTransaction.add(R.id.banner_framelayout, mProfileFragment);
                } else {
                    fragmentTransaction.show(mProfileFragment);
                }
                break;
        }
        fragmentTransaction.commit();
        view.setCurrentBannerStyle(buttonID);
        currentID = buttonID;
    }

    public void setButtonClickListener() {
        view.setButtonListener();
    }

}
