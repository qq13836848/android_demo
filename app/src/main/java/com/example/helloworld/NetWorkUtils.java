package com.example.helloworld;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pengod on 2021/8/16
 * mail:haiming.li@neusoft.com
 */
public class NetWorkUtils {
    private static NetWorkUtils instance;
    private final Api api;
    public Api getApi(){
        return api;
    }
    private NetWorkUtils(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BuildConfig.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getClient())
                .build();
        api = retrofit.create(Api.class);
    }
    public static NetWorkUtils getInstance(){
        if(instance==null){
            instance = new NetWorkUtils();
        }
        return instance;
    }

    public OkHttpClient getClient(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(15, TimeUnit.SECONDS);
                builder.readTimeout(15, TimeUnit.SECONDS);
                builder.writeTimeout(15, TimeUnit.SECONDS);
        if(BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.interceptors().add(loggingInterceptor);
        }
        builder.interceptors().add(new TokenInterceptor());
        return builder.build();
    }
}
