package com.xingzhiqiao.retrofitdemo.http;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by xingzhiqiao on 16/10/12.
 */

public class CommonIntercepter implements Interceptor {


    @Override
    public Response intercept(Chain chain) throws IOException {


        Request oldRequest = chain.request();


        //添加新的参数
        HttpUrl.Builder authorizedUrlBuilder = oldRequest.url()
                .newBuilder()
                .scheme(oldRequest.url().scheme())
                .host(oldRequest.url().host());

        Request newRequest;
        Request.Builder newBuilder = oldRequest.newBuilder();
        newBuilder.url(authorizedUrlBuilder.build());
        newBuilder.addHeader("Content-type", "application/json");

        if (oldRequest.method().equals("GET")) {
            newRequest = newBuilder.method(oldRequest.method(), oldRequest.body()).build();
        } else if (oldRequest.method().equals("POST")) {
            newRequest = newBuilder.method(oldRequest.method(), addParmasToFormBody((FormBody) oldRequest.body())).build();
        } else {
            newRequest = newBuilder.build();
        }


        return chain.proceed(newRequest);
    }


    private RequestBody addParmasToFormBody(FormBody formBody) {

        FormBody.Builder builder = new FormBody.Builder();
        if (formBody == null) {
            return builder.build();
        }

        //公共参数
        String sn = "C5024BBE53BC70B4556F584F53039144";
        String platform = "0";
        String sid = "1";
        String channelId = "CNRL010001";
        String imei = "353490060825359";
        String nodeId = "216";
        String isCity = "0";
        String nodeType = "0";
        String startPage = "0";


        builder.add("sn", sn);
        builder.add("platform", platform);
        builder.add("sid", sid);
        builder.add("channelId", channelId);
        builder.add("imei", imei);
        builder.add("nodeId", nodeId);
        builder.add("isCity", isCity);
        builder.add("nodeType", nodeType);
        builder.add("startPage", startPage);
        builder.add("userId", "78");
        builder.add("userType", "0");

        for (int i = 0; i < formBody.size(); i++) {
            builder.add(formBody.name(i), formBody.value(i));
        }

        return builder.build();


    }


}
