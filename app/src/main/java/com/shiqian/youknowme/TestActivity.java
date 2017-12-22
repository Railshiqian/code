package com.shiqian.youknowme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.shiqian.youknowme.Presenter.TestPresenter;
import com.shiqian.youknowme.ViewImpl.TestActivityView;

public class TestActivity extends AppCompatActivity implements TestActivityView{

    private TestPresenter p;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        p = new TestPresenter(this);

        tv = (TextView) findViewById(R.id.tv);

        p.setText();

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
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.onResume();


    }
}
