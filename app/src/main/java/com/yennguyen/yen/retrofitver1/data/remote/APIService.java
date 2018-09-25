package com.yennguyen.yen.retrofitver1.data.remote;

import com.yennguyen.yen.retrofitver1.data.model.Post;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface APIService {

    @POST("/posts")
    @FormUrlEncoded
    Call<Post> savePost(@Field("title") String title,
                        @Field("body") String body,
                        @Field("userId") long userId);

    @PUT("/posts/{id}")
    @FormUrlEncoded
    Call<Post> updatePost(@Field("title") String title,
                          @Field("body") String body,
                          @Field("userId") long userId);


}
