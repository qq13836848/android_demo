package com.example.helloworld;

import android.util.Log;

public class Application extends android.app.Application {

    private static String TAG = "Application";

    @Override
    public void onCreate() {
        super.onCreate();
        if (Installation.isFirstInstall(this)) {
            Installation.id(this);
            // 调用安装埋点接口
            Log.d(TAG, "调用安装接口");
        }
        // 调用启动app埋点接口
        Log.d(TAG, "调用启动app接口");

    }
}
