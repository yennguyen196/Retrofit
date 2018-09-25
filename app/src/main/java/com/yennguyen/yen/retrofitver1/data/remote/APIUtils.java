package com.yennguyen.yen.retrofitver1.data.remote;

public class APIUtils {
    private APIUtils(){}
    private static final String base_URL = "http://jsonplaceholder.typicode.com/";
    public static APIService getService(){
        return RetrofitClient.getClient(base_URL).create(APIService.class);
    }
}
