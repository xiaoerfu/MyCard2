package com.example.mycard.application;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.mycard.gen.DaoMaster;
import com.example.mycard.gen.DaoSession;

/**
 * Created by lijianfu on 2017/4/13.
 */
public class MyApplication extends Application{

    private DaoMaster.DevOpenHelper dbHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    public static MyApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        init();
        initDatabass();
    }
    public static MyApplication getInstance(){
        return instance;
    }
    private void initDatabass() {
        //这里之后会修改，关于升级数据库
        dbHelper = new DaoMaster.DevOpenHelper(this, "card-db", null);
        db = dbHelper.getWritableDatabase();
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }
    public DaoSession getSession(){
        return mDaoSession;
    }
    public SQLiteDatabase getDb(){
        return db;
    }
    private void init() {
        instance = this;
    }
}
