package com.song.judynews.component;

import android.util.Log;

import com.song.judynews.activity.BaseActivity;
import com.song.judynews.util.Urls;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by judy on 2017/6/28.
 */

public class RetrofitManager {
    private static Retrofit sRetrofit;

    private RetrofitManager() {
    }

    public synchronized static Retrofit getInstance(final BaseActivity context) {
        if (sRetrofit == null) {
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.connectTimeout(5000, TimeUnit.MILLISECONDS);

            //给OKHttp设置缓存
            File cacheFile = new File(context.getCacheDir().getAbsolutePath(), "HttpCache");
            Cache cache = new Cache(cacheFile, 1024 * 1024 * 10);
            httpClient.cache(cache);

            //设置网络拦截器
            Interceptor interceptor = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();
                    if (!context.isNetworkReachable()) {
                        request = request.newBuilder()
                                .cacheControl(CacheControl.FORCE_CACHE)
                                .build();
                        Log.d("OkHttp", "网络不可用请求拦截");
                    } else {
                        request = request.newBuilder()
                                .cacheControl(CacheControl.FORCE_NETWORK)
                                .build();
                        Log.d("OkHttp", "网络可用请求拦截");
                    }

                    Response response = chain.proceed(request);
                    if (context.isNetworkReachable()) {
                        Log.d("OkHttp", "网络可用响应拦截");
                        response = response.newBuilder()
                                //覆盖服务器响应头的Cache-Control,用我们自己的,因为服务器响应回来的可能不支持缓存
                                .header("Cache-Control", "public,max-age=300")
                                .removeHeader("Pragma")
                                .build();
                    }

                    return response;
                }
            };

            httpClient.interceptors().add(interceptor);
            httpClient.networkInterceptors().add(interceptor);

            //添加log访问的日志
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClient.interceptors().add(logging);

            sRetrofit = new Retrofit.Builder()
                    .client(httpClient.build())
                    .baseUrl(Urls.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return sRetrofit;
    }
}
