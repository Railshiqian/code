package com.shiqian.youknowme;

import android.os.Bundle;
import android.widget.TextView;

import com.shiqian.youknowme.BaseApp.MVPBaseActivity;
import com.shiqian.youknowme.Presenter.TestPresenter;
import com.shiqian.youknowme.ViewImpl.TestActivityView;

public class TestActivity extends MVPBaseActivity<TestActivityView,TestPresenter> implements TestActivityView{

    private TestPresenter p;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        tv = (TextView) findViewById(R.id.tv);
        p.setText();

    }

    @Override
    protected TestPresenter creatPresenter() {
        p = new TestPresenter(this);
        return p;
    }

    @Override
    public void setText(String text) {
        tv.setText(text);
    }

    @Override
    public String getText() {
        return tv.getText().toString();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
