package com.song.judynews.presenter;

import android.util.Log;

import com.song.judynews.component.APIService;
import com.song.judynews.component.RetrofitManager;
import com.song.judynews.entity.JokeEntity;
import com.song.judynews.fragment.JokeFragment;
import com.song.judynews.util.Urls;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Judy on 2017/6/25.
 */

public class JokePresenter {
    private static final String TAG = "JokePresenter";
    private JokeFragment mFragment;
    private final int REQUEST_NUM = 10;

    public JokePresenter(JokeFragment jokeFragment) {
        mFragment = jokeFragment;
    }

    public void loadDataFromNet() {
        APIService apiService = RetrofitManager.getInstance().create(APIService.class);
        Observable<JokeEntity> jokeObservable = apiService.getJokeEntity(Urls.APIKEY, REQUEST_NUM);
        jokeObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JokeEntity>() {
            @Override
            public void onSubscribe(@NonNull Disposable disposable) {

            }

            @Override
            public void onNext(@NonNull JokeEntity jokeEntity) {
                Log.d(TAG, "onNext: "+jokeEntity.toString());
                mFragment.onDataLoaded(jokeEntity);
            }

            @Override
            public void onError(@NonNull Throwable throwable) {
                Log.d(TAG, "onError: "+throwable.toString());
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
