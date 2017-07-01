package com.song.judynews.component;

import com.song.judynews.util.Urls;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by judy on 2017/6/28.
 */

public class RetrofitManager {
    private static Retrofit sRetrofit;

    private RetrofitManager() {}

    public synchronized static Retrofit getInstance() {
        if (sRetrofit == null) {
            OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
            httpClientBuilder.connectTimeout(5000, TimeUnit.MILLISECONDS);

            sRetrofit = new Retrofit.Builder()
                    .client(httpClientBuilder.build())
                    .baseUrl(Urls.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return sRetrofit;
    }
}
