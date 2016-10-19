package com.xingzhiqiao.retrofitdemo.http;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.xingzhiqiao.retrofitdemo.DemoApplication;
import com.xingzhiqiao.retrofitdemo.utils.NetWorkUtil;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * 用于在Http请求开始时，自动显示一个ProgressDialog
 * 在Http请求结束时，关闭ProgressDialog
 * 调用者自己对请求数据进行处理
 *
 * @param <T>
 */
public class ProgressSubscriber<T> extends Subscriber<T> implements ProgressCancelListener {

    private ProgressDialogHandler mProgressDialogHandler;

    private Context context;
    private HttpDataListner httpDataListner;

    public ProgressSubscriber(HttpDataListner httpDataListner, Context context, boolean show) {
        this.context = context;
        this.httpDataListner = httpDataListner;
        mProgressDialogHandler = new ProgressDialogHandler(context, this, true, show);
    }

    private void showProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.SHOW_PROGRESS_DIALOG).sendToTarget();
        }
    }

    private void dismissProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG).sendToTarget();
            mProgressDialogHandler = null;
        }
    }

    /**
     * 订阅开始时调用
     * 显示ProgressDialog
     */
    @Override
    public void onStart() {
        showProgressDialog();
    }

    /**
     * 完成，隐藏ProgressDialog
     */
    @Override
    public void onCompleted() {
        dismissProgressDialog();
        httpDataListner.onCompleted();
    }

    /**
     * 对错误进行统一处理
     * 隐藏ProgressDialog
     *
     * @param e
     */
    @Override
    public void onError(Throwable e) {

        if (context == null) {
            return;
        }
        if (e instanceof HttpException) {
            Log.d("TAG", "HttpException");
            HttpException exception = (HttpException) e;
            Log.d("TAG", "HttpException" + exception.code());
        }
//        if (e instanceof SocketTimeoutException) {
//            Toast.makeText(context, "网络中断，请检查您的网络状态", Toast.LENGTH_SHORT).show();
//        } else if (e instanceof ConnectException) {
//            Toast.makeText(context, "网络中断，请检查您的网络状态", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(context, "错误" + e.getMessage(), Toast.LENGTH_SHORT).show();
//        }
        httpDataListner.onError(e);
        dismissProgressDialog();
    }


    /**
     * 将onNext方法中的返回结果交给Activity或Fragment自己处理
     *
     * @param t 创建Subscriber时的泛型类型
     */
    @Override
    public void onNext(T t) {
        if (!NetWorkUtil.isNetworkConnected()) {
            Toast.makeText(DemoApplication.getInstance(), "网络异常,请查看你的网络连接", 1).show();
        }
        httpDataListner.onNext(t);
    }

    /**
     * 取消ProgressDialog的时候，取消对observable的订阅，同时也取消了http请求
     */
    @Override
    public void onCancelProgress() {
        if (!this.isUnsubscribed()) {
            this.unsubscribe();
        }
    }

}