package com.example.helloworld;


import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {

    @POST("/noAuth/serviceInfo/list")
    Call<Data<Info>> getJsonData();
}
