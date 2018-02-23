package com.shiqian.youknowme.model.DbModel;

import android.app.Application;
import android.content.Context;

import com.shiqian.youknowme.Bean.DaoMaster;
import com.shiqian.youknowme.Bean.DaoMaster.DevOpenHelper;
import com.shiqian.youknowme.Bean.DaoSession;
import com.shiqian.youknowme.Bean.User;
import com.shiqian.youknowme.Property.Property;
import com.shiqian.youknowme.model.DbModel.DbModelInterface.DbUtilInterface;

import org.greenrobot.greendao.database.Database;


/**
 * Created by chenzd on 17-12-21.
 */

public class DbUtil implements DbUtilInterface {

    private DaoMaster daoMaster;
    private DaoSession daoSession;

    private DbUtil(){
    }

    private static DbUtil dbUtil = new DbUtil();

    public static DbUtil getInstance(){
        return dbUtil;
    }

    public void init(Context context){
        DevOpenHelper helper = new DevOpenHelper(context, Property.ENCRYPTED ? "youknowme-db-encrypted" : "youknowme-db");
        Database db = Property.ENCRYPTED ? helper.getEncryptedWritableDb(Property.DATABASE_PSWD) : helper.getWritableDb();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }


    @Override
    public String getRealId() {
        User tempUser = getUser();
        if(tempUser == null){
            return null;
        }else{
            return tempUser.getRealId();
        }
    }

    @Override
    public User getUser() {
        return daoSession.getUserDao().loadByRowId(1l);
    }
}
