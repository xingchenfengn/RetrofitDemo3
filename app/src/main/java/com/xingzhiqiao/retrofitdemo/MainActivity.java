package com.xingzhiqiao.retrofitdemo;

import android.os.Bundle;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.xingzhiqiao.retrofitdemo.bean.DailyListBean;
import com.xingzhiqiao.retrofitdemo.http.HttpDataListner;
import com.xingzhiqiao.retrofitdemo.http.HttpServer;
import com.xingzhiqiao.retrofitdemo.http.ProgressSubscriber;
import com.xingzhiqiao.retrofitdemo.response.BaseResponse;
import com.xingzhiqiao.retrofitdemo.response.DirectShowChannelResponse;
import com.xingzhiqiao.retrofitdemo.response.PlayInfoResponse;

import java.util.HashMap;

import rx.Subscription;

public class MainActivity extends AppCompatActivity implements HttpDataListner<BaseResponse> {

    public String TAG = MainActivity.class.getName();

    private Subscription subscription;
    private TextView textView, texview2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "thread" + Process.myTid());


        textView = (TextView) findViewById(R.id.text1);
        texview2 = (TextView) findViewById(R.id.text2);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });
        texview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPlayInfo();
            }
        });

    }

    private void getData() {

        HashMap<String, String> params = new HashMap<>();
        params.put("channelName", "央视");
        params.put("userId", "78");
        params.put("userType", "0");
        HttpServer.getDirectShow(params, new ProgressSubscriber<DirectShowChannelResponse>(this, MainActivity.this, false));
    }


    private void getPlayInfo() {
//        HttpServer.getPlayInfo(false, "1", "0", "70", "0", new ProgressSubscriber<PlayInfoResponse>(this, MainActivity.this, true));
//        HttpServer.getNavInfo(new ProgressSubscriber<BaseResponse>(this, MainActivity.this, true));
        HttpServer.getDaily("http://news-at.zhihu.com/api/4/stories/latest", new ProgressSubscriber<DailyListBean>(this, MainActivity.this, true));
    }

    @Override
    public void onNext(BaseResponse response) {
//        textView.setText(response.getStatus().getMsgToShow());
        if (response instanceof DirectShowChannelResponse) {
            DirectShowChannelResponse response1 = (DirectShowChannelResponse) response;
            Log.d(TAG, response1.getStatus().getMsgToShow());
            textView.setText(response1.getDirectProgramList().get(0).getImgUrl());
        }
        if (response instanceof PlayInfoResponse) {
            PlayInfoResponse playInfoResponse = (PlayInfoResponse) response;
            Log.d(TAG, "获取播放信息成功");
            Log.d(TAG, playInfoResponse.getProgramName());
            texview2.setText(playInfoResponse.getProgramName());
        }
        if (response instanceof DailyListBean) {
            Log.d(TAG, "获取成功");
            texview2.setText(((DailyListBean) response).getDate());
        }
    }

    @Override
    public void onError(Throwable t) {
        Log.d(TAG, t.getLocalizedMessage());
    }

    @Override
    public void onCompleted() {
        Log.d(TAG, "onCompleted");
    }
}
