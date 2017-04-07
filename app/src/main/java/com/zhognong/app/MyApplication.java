package com.zhognong.app;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.zhognong.dao.DaoMaster;
import com.zhognong.dao.DaoSession;

import org.xutils.x;

/**
 * Created by Administrator on 2017/4/7.
 */

public class MyApplication extends Application{
    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    public static MyApplication instances;
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        instances = this;
        setDatabase();
    }
    public static MyApplication getInstances(){
        return instances;
    }
    private void setDatabase() {
        mHelper = new DaoMaster.DevOpenHelper(this, "zhonggong-db", null);
        db = mHelper.getWritableDatabase();
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }
    public DaoSession getDaoSession() {
        return mDaoSession;
    }
    public SQLiteDatabase getDb() {
        return db;
    }
}
