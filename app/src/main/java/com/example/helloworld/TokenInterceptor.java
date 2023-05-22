package com.example.helloworld;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 2020 7 22
 * lhm
 */
public class TokenInterceptor implements Interceptor{
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        Request.Builder rBuilder = request.newBuilder();

//        String userAgent = request.header("UserAgent");
        rBuilder.addHeader("Content-Type","application/json;charset=UTF-8");
        request = rBuilder.build();

        Response response;
        response = chain.proceed(request);
        return response;
    }
}
