package com.example.brand.ilovezappos;

import android.util.Log;

import com.squareup.otto.Produce;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;

/**
 * Created by brand on 2/8/2017.
 */

public class Connector {

    private static final String serverURL = "https://api.zappos.com/";
    private static final String key = "b743e26728e16b81da139182bb2094357c31d331";

    public void getSearchInfo(String term){

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(loggingInterceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(serverURL)
                .build();

        APIHandler handler = retrofit.create(APIHandler.class);
        Call<Products> call = handler.productList(term, key);

        call.enqueue(new Callback<Products>() {
            @Override
            public void onResponse(Call<Products> call, Response<Products> response) {
                BusProvider.getInstance().post(new ProductsResponse(response.body()));
            }

            @Override
            public void onFailure(Call<Products> call, Throwable t) {
            }
        });

    }

    @Produce
    public ProductsResponse produceEvent(Products products) {
        return new ProductsResponse(products);
    }



}
