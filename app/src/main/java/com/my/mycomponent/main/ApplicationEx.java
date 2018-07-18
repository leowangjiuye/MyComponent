package com.my.mycomponent.main;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author WangJY
 * create at 2018/7/14
 */
public class ApplicationEx extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }
}
