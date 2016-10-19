package com.xingzhiqiao.retrofitdemo;

import android.app.Application;

/**
 * Created by xingzhiqiao on 16/10/13.
 */

public class DemoApplication extends Application {


    private static DemoApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }


    public static DemoApplication getInstance() {
        return mInstance;
    }

}
