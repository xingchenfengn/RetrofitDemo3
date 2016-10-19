package com.xingzhiqiao.retrofitdemo.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.xingzhiqiao.retrofitdemo.DemoApplication;

/**
 * 网络工具类
 */
public class NetWorkUtil {

    private NetWorkUtil() {

    }

    public static boolean isNetworkConnected() {

        if (DemoApplication.getInstance() != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) DemoApplication.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    public static boolean isWifiConnected() {

        if (DemoApplication.getInstance() != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) DemoApplication.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mWiFiNetworkInfo = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            if (mWiFiNetworkInfo != null) {
                return mWiFiNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    public static boolean isMobileConnected() {

        if (DemoApplication.getInstance() != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) DemoApplication.getInstance()
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mMobileNetworkInfo = mConnectivityManager
                    .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if (mMobileNetworkInfo != null) {
                return mMobileNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    public static int getConnectedType() {

        if (DemoApplication.getInstance() != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) DemoApplication.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null && mNetworkInfo.isAvailable()) {
                return mNetworkInfo.getType();
            }
        }
        return -1;
    }
}
