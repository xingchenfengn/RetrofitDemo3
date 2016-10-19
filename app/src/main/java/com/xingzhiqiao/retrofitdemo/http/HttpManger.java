package com.xingzhiqiao.retrofitdemo.http;

import android.util.Log;

import com.xingzhiqiao.retrofitdemo.DemoApplication;
import com.xingzhiqiao.retrofitdemo.response.BaseResponse;
import com.xingzhiqiao.retrofitdemo.response.DirectShowChannelResponse;
import com.xingzhiqiao.retrofitdemo.utils.NetWorkUtil;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by xingzhiqiao on 16/10/11.
 */

public class HttpManger {

    private static String TAG = HttpManger.class.getName();

    private static int cacheSize = 10 * 1024 * 1024;
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();

    public static String BASE_URL = "http://api.tv.test.cnrmobile.com/";
    private volatile static HttpManger mInstance;
    private static CnrApi cnrRequest;

    private HttpManger() {

        //设置Http缓存
        Cache cache = new Cache(new File(DemoApplication.getInstance().getCacheDir(), "HttpCache1"), 1024 * 1024 * 100);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.connectTimeout(30, TimeUnit.SECONDS);
        builder.cache(cache);
        builder.addInterceptor(mRewriteCacheControlInterceptor);
        builder.addInterceptor(new CommonIntercepter());
        builder.addInterceptor(interceptor);


        Retrofit retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        cnrRequest = retrofit.create(CnrApi.class);

        Call<DirectShowChannelResponse> directShowRespone1 = cnrRequest.getDirectShowRespone1(new HashMap<String, String>());
        directShowRespone1.enqueue(new Callback<DirectShowChannelResponse>() {
            @Override
            public void onResponse(Call<DirectShowChannelResponse> call, retrofit2.Response<DirectShowChannelResponse> response) {
                Log.d("TAG", response.code() + "onResponse");
            }

            @Override
            public void onFailure(Call<DirectShowChannelResponse> call, Throwable t) {

            }
        });
    }

    public CnrApi getCnrRequest() {
        return cnrRequest;
    }


    public static HttpManger getmInstance() {
        if (mInstance == null) {
            synchronized (HttpManger.class) {
                if (mInstance == null) {
                    mInstance = new HttpManger();
                }
            }
        }
        return mInstance;
    }


    public void doRequest(Observable<? extends BaseResponse> observable, Subscriber subscriber) {

        Observable observable1 = observable
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable1.subscribe(subscriber);

    }

    private Interceptor mRewriteCacheControlInterceptor = new Interceptor() {

        @Override
        public Response intercept(Chain chain) throws IOException {

            Request request = chain.request();
            if (!NetWorkUtil.isNetworkConnected()) {
                request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
            }
            Response originalResponse = chain.proceed(request);
            if (NetWorkUtil.isNetworkConnected()) {
                originalResponse = originalResponse.newBuilder().header("Cache-Control", "public, max-age=60").removeHeader("Pragma").build();
            } else {
                int maxStale = 60 * 60 * 24 * 28; // 无网络时，设置超时为4周
                originalResponse = originalResponse.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .removeHeader("Pragma")
                        .build();
            }
//            originalResponse.body().close();
            return originalResponse;
        }
    };


}