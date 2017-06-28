package com.song.judynews.component;

import com.song.judynews.entity.JokeEntity;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by judy on 2017/6/28.
 */

public interface APIService {

    @GET("txapi/joke")
    Observable<JokeEntity> getJokeEntity(@Query("key") String key, @Query("num") int num);
}
