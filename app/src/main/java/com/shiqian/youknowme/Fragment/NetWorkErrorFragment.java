package com.shiqian.youknowme.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.shiqian.youknowme.R;

/**
 * Created by chenzd on 18-1-5.
 */
public class NetWorkErrorFragment extends Fragment {

    private View view;
    private TextView tvMsg;
    private Button btnOk;
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            getActivity().finish();
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_network_error, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvMsg = (TextView) view.findViewById(R.id.fragment_network_error_tv_msg);
        btnOk = (Button) view.findViewById(R.id.fragment_network_error_btn_ok);

        btnOk.setOnClickListener(listener);
        tvMsg.setText("版本更新检测，网络异常!");

    }


}
