package com.shiqian.youknowme;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.shiqian.youknowme.BaseApp.MVPBaseActivity;
import com.shiqian.youknowme.Presenter.TestPresenter;
import com.shiqian.youknowme.ViewImpl.TestActivityView;

import java.util.ArrayList;

public class TestActivity extends MVPBaseActivity<TestActivityView, TestPresenter> implements TestActivityView {

    private TestPresenter p;
    private RecyclerView rlv;
    private LinearLayoutManager mLinearLayoutManager;
    private MyAdapter mAdapter;
    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Button btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        rlv = (RecyclerView) findViewById(R.id.rlv);

        mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        list = new ArrayList<String>();
        mAdapter = new MyAdapter(list);


    }

    @Override
    protected TestPresenter creatPresenter() {
        p = new TestPresenter(this);
        return p;
    }

    @Override
    public void setText(String text) {
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private class MyAdapter extends BaseAdapter {

        ArrayList<String> list;

        public MyAdapter(ArrayList<String> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            return null;
        }
    }

}
