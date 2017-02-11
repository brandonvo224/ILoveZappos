package com.example.brand.ilovezappos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by brand on 2/8/2017.
 */

public interface APIHandler {

    @GET("Search")
    Call<Products> productList(@Query("term") String term, @Query("key") String key);

}
