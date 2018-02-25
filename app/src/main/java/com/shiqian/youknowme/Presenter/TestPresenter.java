package com.shiqian.youknowme.Presenter;

import com.shiqian.youknowme.BaseApp.BasePresenter;
import com.shiqian.youknowme.model.DbModel.DbModelInterface.DbUtilInterface;
import com.shiqian.youknowme.ViewImpl.TestActivityView;
import com.shiqian.youknowme.model.DbModel.DbUtil;

/**
 * Created by chenzd on 17-12-21.
 */
public class TestPresenter extends BasePresenter<TestActivityView>{

    TestActivityView testViewImpl;

    public TestPresenter(TestActivityView testViewImpl){
        this.testViewImpl = testViewImpl;
    }


}
