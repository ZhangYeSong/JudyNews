package com.song.judynews.component;

import com.song.judynews.entity.JokeEntity;
import com.song.judynews.entity.LiveEntity;
import com.song.judynews.entity.NewsEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by judy on 2017/6/28.
 */

public interface APIService {

    @Headers("Cache-Control: public, max-age=10")
    @GET("txapi/joke")
    Observable<JokeEntity> getJokeEntity(@Query("key") String key, @Query("num") int num);

    @Headers("Cache-Control: public, max-age=10")
    @GET
    Observable<NewsEntity> getNewsEntity(@Url String url, @Query("key") String key,
                                         @Query("num") int num, @Query("page") int page);

    @GET
    Observable<LiveEntity> getLiveEntity(@Url String url, @Query("limit") int limit);

}
