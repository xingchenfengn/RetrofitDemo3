package com.xingzhiqiao.retrofitdemo.http;

import com.xingzhiqiao.retrofitdemo.bean.DailyListBean;
import com.xingzhiqiao.retrofitdemo.response.BaseResponse;
import com.xingzhiqiao.retrofitdemo.response.DirectShowChannelResponse;
import com.xingzhiqiao.retrofitdemo.response.PlayInfoResponse;

import java.util.HashMap;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by xingzhiqiao on 16/10/17.
 */

public class HttpServer {


    /**
     * 获取直播节目
     *
     * @param hashMap
     * @param subscriber
     */
    public static void getDirectShow(HashMap hashMap, Subscriber<DirectShowChannelResponse> subscriber) {


        Observable<DirectShowChannelResponse> directShowRespone = HttpManger.getmInstance().getCnrRequest().getDirectShowRespone(hashMap);
        HttpManger.getmInstance().doRequest(directShowRespone, subscriber);

    }

    public static void getPlayInfo(boolean ht_type, String playId, String playType, String userId, String userType, Subscriber<PlayInfoResponse> subscriber) {
//
//        RetrofitHelper helper = RetrofitHelper.builder();
//
//
//        CnrApi cnrApi = helper.getCnrApi();
//        Observable<PlayInfoResponse> playInfoResponse = cnrApi.getPlayInfoResponse(ht_type, playId, playType, userId, userType);
//        helper.doRequest(playInfoResponse, subscriber);


        Observable<PlayInfoResponse> playInfoResponse = HttpManger.getmInstance().getCnrRequest().getPlayInfoResponse(ht_type, playId, playType, userId, userType);
        HttpManger.getmInstance().doRequest(playInfoResponse, subscriber);

    }

    public static void getNavInfo(Subscriber<BaseResponse> subscriber) {
        Observable<BaseResponse> navResponse = HttpManger.getmInstance().getCnrRequest().getNavResponse();
        HttpManger.getmInstance().doRequest(navResponse, subscriber);
    }

    public static void getDaily(String url, Subscriber<DailyListBean> subscriber) {
        Observable<DailyListBean> dailyListBeanObservable = HttpManger.getmInstance().getCnrRequest().getDailayResponse(url);
        HttpManger.getmInstance().doRequest(dailyListBeanObservable, subscriber);
    }


}
