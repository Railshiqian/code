package com.shiqian.youknowme.Services;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.shiqian.youknowme.VersionUpdateActivity;
import com.shiqian.youknowme.model.VersionModel.VersionUpdateUtil;

/**
 * Created by chenzd on 18-2-25.
 */

public class VersionUpdateService extends IntentService {

    public VersionUpdateService() {
        super("");
    }

    public VersionUpdateService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        VersionUpdateUtil.checkVersionUpdate(VersionUpdateService.this, new VersionUpdateUtil.VersionUpdateCallBack() {
            @Override
            public void onNewVersionChecked(String msg) {
                gotoVersionUpdateActivity(1);
            }

            @Override
            public void isLatestVersion() {
                gotoVersionUpdateActivity(2);
            }

            @Override
            public void onNetWorkError() {
                gotoVersionUpdateActivity(3);
            }
        });
    }

    private void gotoVersionUpdateActivity(int flag) {
        Intent intent = new Intent(VersionUpdateService.this, VersionUpdateActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.putExtra("hasNewVersion", flag);
        startActivity(intent);
    }

}
