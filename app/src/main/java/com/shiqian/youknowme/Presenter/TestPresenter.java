package com.shiqian.youknowme.Presenter;

import com.shiqian.youknowme.BaseApp.BasePresenter;
import com.shiqian.youknowme.model.DbModel.DbModelInterface.DbUtilInterface;
import com.shiqian.youknowme.ViewImpl.TestActivityView;
import com.shiqian.youknowme.model.DbModel.DbUtil;

/**
 * Created by chenzd on 17-12-21.
 */
public class TestPresenter extends BasePresenter<TestActivityView>{

    DbUtilInterface util = new DbUtil();
    TestActivityView testViewImpl;

    public TestPresenter(TestActivityView testViewImpl){
        this.testViewImpl = testViewImpl;
    }

    public void setText(){
        String text = util.getText();
        testViewImpl.setText(text);
    }

    public String getText(){
        return testViewImpl.getText();
    }


}
