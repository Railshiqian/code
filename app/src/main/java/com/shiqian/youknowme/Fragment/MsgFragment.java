package com.shiqian.youknowme.Fragment;

import android.app.Fragment;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.shiqian.youknowme.AppUtils.ToastUtil;
import com.shiqian.youknowme.R;

import java.util.ArrayList;

/**
 * Created by chenzd on 18-1-5.
 */
public class MsgFragment extends Fragment {

    private View view;
    private SwipeRefreshLayout refreshLayout;
    private RecyclerView mRecyclerView;
    private ArrayList<String> list;
    private MyAdapter adapter;
    private SwipeRefreshLayout.OnRefreshListener refreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            list.clear();
            for (int i = 0;i<15;i++){
                list.add((int)(Math.random()*100)+"");
            }
            mRecyclerView.postDelayed(new Runnable() {
                @Override
                public void run() {
                    adapter.notifyDataSetChanged();
                    refreshLayout.setRefreshing(false);
                }
            },2000);
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_msg, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.fragment_msg_swiperefreshlayout);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.fragment_msg_recycleview);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        list = new ArrayList<>();
        for (int i = 0;i<15;i++){
            list.add((int)(Math.random()*100)+"");
        }
        adapter = new MyAdapter(list);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),RecyclerView.VERTICAL));

        refreshLayout.setOnRefreshListener(refreshListener);


    }

    private class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        private ArrayList<String> list;

        public MyAdapter(ArrayList<String> list) {
            this.list = list;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            final View v = LayoutInflater.from(getActivity()).inflate(R.layout.layout_fragment_msg_item, null);
            return new MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {
            holder.tv.setText(list.get(position));

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ToastUtil.toast(getActivity(),position+"",Toast.LENGTH_SHORT);
                }
            });

        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tv;
        public View itemView;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tv = (TextView) itemView.findViewById(R.id.fragment_msg_recycleview_item_tv);
        }
    }

}
