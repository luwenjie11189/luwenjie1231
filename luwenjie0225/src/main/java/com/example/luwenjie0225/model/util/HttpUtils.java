package com.example.luwenjie0225.model.util;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @Auther: 努力
 * @Date: 2019/2/25 08:52:${卢文杰}
 * @Description:
 */
public class HttpUtils<T> {

    private final OkHttpClient okHttpClient;

    private HttpUtils() {
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .build();
    }

    private CallBackData callBackData;

    public static HttpUtils getInstance() {
        return getHttpUtilsInstance.httpUtils;
    }

    private static class getHttpUtilsInstance {
        public static HttpUtils httpUtils = new HttpUtils();
    }

    public void getData(String url, final Class<T> tClass, CallBackData callBackData) {
        this.callBackData = callBackData;
        Request request = new Request
                .Builder()
                .url(url)
                .get()
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Message message = handler.obtainMessage();
                message.what = -1;
                message.obj = e.getMessage();
                handler.sendMessage(message);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                T t = gson.fromJson(string, tClass);
                Message message = handler.obtainMessage();
                message.what = 1;
                message.obj = t;
                handler.sendMessage(message);
            }
        });

    }

    public void postData(String url, final Class<T> tClass, HashMap<String, String> hashMap, CallBackData callBackData) {
        this.callBackData = callBackData;
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, String> stringStringEntry : hashMap.entrySet()) {
            String key = stringStringEntry.getKey();
            String value = stringStringEntry.getValue();
            builder.add(key, value);
        }
        FormBody build = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(build)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Message message = handler.obtainMessage();
                message.what = -1;
                message.obj = e.getMessage();
                handler.sendMessage(message);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                T t = gson.fromJson(string, tClass);
                Message message = handler.obtainMessage();
                message.what = 1;
                message.obj = t;
                handler.sendMessage(message);
            }
        });
    }

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    T t = (T) msg.obj;
                    callBackData.onResponse(t);
                    break;
                case -1:
                    String err = (String) msg.obj;
                    callBackData.onFail(err);
                    break;
            }
        }
    };

    public interface CallBackData<D> {
        public void onResponse(D d);

        public void onFail(String err);
    }

}
