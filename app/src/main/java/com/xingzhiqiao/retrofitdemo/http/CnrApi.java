package com.xingzhiqiao.retrofitdemo.http;

import com.xingzhiqiao.retrofitdemo.bean.CnrBean;
import com.xingzhiqiao.retrofitdemo.bean.DailyListBean;
import com.xingzhiqiao.retrofitdemo.response.BaseResponse;
import com.xingzhiqiao.retrofitdemo.response.DirectShowChannelResponse;
import com.xingzhiqiao.retrofitdemo.response.PlayInfoResponse;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by xingzhiqiao on 16/10/11.
 */

public interface CnrApi {


    @POST("/mobileapi/getlivelist")
    @FormUrlEncoded
    Observable<DirectShowChannelResponse> getDirectShowRespone(@FieldMap Map<String, String> params);


    @POST("/program/playinfo")
    @FormUrlEncoded
    Observable<PlayInfoResponse> getPlayInfoResponse(@Field("ht_type") boolean ht_type, @Field("playId")
            String playId, @Field("playType") String playType, @Field("userId") String userId, @Field("userType") String userType);

    @GET("/mobileapi/main")
    Call<BaseResponse> getMainResponse();

    @GET("found/top")
    Call<List<CnrBean>> getTop();


    @POST("/mobileapi/getlivelist")
    @FormUrlEncoded
    Call<DirectShowChannelResponse> getDirectShowRespone1(@FieldMap Map<String, String> params);

    @GET("/channel/navChannel")
    Observable<BaseResponse> getNavResponse();

    @GET
    Observable<DailyListBean> getDailayResponse(@Url String url);


}
