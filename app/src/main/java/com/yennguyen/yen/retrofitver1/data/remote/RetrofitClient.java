package com.yennguyen.yen.retrofitver1.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit sRetrofit;
    public static Retrofit getClient(String baseUrl){
        if(sRetrofit == null){
            sRetrofit = new Retrofit.Builder().baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create()).build();

        }
        return sRetrofit;
    }
}
