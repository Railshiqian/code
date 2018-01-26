package com.shiqian.youknowme.model.WebModel;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Created by chenzd on 18-1-23.
 */
public interface WebInterface {

    public void doGet(Context context,HashMap<String, Objects> map);

    public void doPost(Context context,HashMap<String,Objects> map);

    public void uploadFile(Context context,String filePath);

    public void uploadFiles(Context context,ArrayList<String> filePathList);


}
