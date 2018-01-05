package com.shiqian.youknowme;

import android.os.Bundle;
import android.util.EventLog;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.shiqian.youknowme.BaseApp.MVPBaseActivity;
import com.shiqian.youknowme.Presenter.TestPresenter;
import com.shiqian.youknowme.ViewImpl.TestActivityView;

public class TestActivity extends MVPBaseActivity<TestActivityView, TestPresenter> implements TestActivityView {

    private TestPresenter p;
    private TextView tv;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        tv = (TextView) findViewById(R.id.tv);
        p.setText();

        lv = findViewById(R.id.lv);
        String[] arr = new String[]{"aaa", "sss", "ddd", "fff", "ggg", "hhh","iii","jjj","kkk","lll"};
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(TestActivity.this, android.R.layout.simple_list_item_1, arr);

        lv.setAdapter(adapter);

        lv.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                switch (i) {
                    case KeyEvent.KEYCODE_DPAD_UP:
                    case KeyEvent.KEYCODE_DPAD_DOWN:

                        if (keyEvent.getAction() == KeyEvent.ACTION_UP) {
                            if (lv.hasFocus()) {
                                Log.d("TEST", lv.hasFocus() + "," + lv.getSelectedItemPosition()+","+(String)(lv.getSelectedItem()));
                                int pos = lv.getSelectedItemPosition();
                                Toast.makeText(TestActivity.this, pos + "", Toast.LENGTH_SHORT).show();
                            }
                        }

                        break;

                }
                return false;
            }
        });


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
