package com.shiqian.youknowme.AppUtils;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenzd on 18-2-24.
 */

public class EncryptUtil {

    private static final String LOG_TAG = "EncryptUtil";

    public static String encryptData(HashMap<String, Object> map) {

        String temp = mapToString(map);
        LogUtil.d(LOG_TAG,temp);
        return temp;
    }

    private static String mapToString(HashMap<String, Object> map) {
        JSONObject obj = new JSONObject(map);
        return obj.toString();
//
//            if(entry.getKey()!=null&&entry.getValue()!=null){
//                temp+=entry.getKey()+"="+entry.getValue()
//            }
//
//            System.out.println("key= "+entry.getKey()+" and value= "+entry.getValue());
//
//        }

    }


}
