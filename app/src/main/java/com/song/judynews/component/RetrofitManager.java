package com.song.judynews.component;

import com.song.judynews.util.Constants;
import com.song.judynews.util.Urls;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by judy on 2017/6/28.
 */

public class RetrofitManager {
    private RetrofitManager() {}

    public Retrofit getInstance() {
        return new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
