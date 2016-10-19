package com.xingzhiqiao.retrofitdemo.http;

/**
 * Created by xingzhiqiao on 16/10/17.
 */

public interface HttpDataListner<T> {

    void onNext(T t);

    void onError(Throwable t);

    void onCompleted();
}
