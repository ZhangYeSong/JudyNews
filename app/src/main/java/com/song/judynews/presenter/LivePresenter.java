package com.song.judynews.presenter;

import android.util.Log;

import com.song.judynews.component.APIService;
import com.song.judynews.component.RetrofitManager;
import com.song.judynews.entity.LiveEntity;
import com.song.judynews.fragment.LiveFragment;
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

public class LivePresenter {
    private static final String TAG = "LivePresenter";
    private LiveFragment mFragment;

    public LivePresenter(LiveFragment liveFragment) {
        mFragment = liveFragment;
    }

    public void loadDataFromNet() {
        APIService apiService = RetrofitManager.getInstance(mFragment.mActivity).
                create(APIService.class);

        Observable<LiveEntity> liveEntity = apiService.getLiveEntity(Urls.DouyuUrl, 20);

        liveEntity.subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<LiveEntity>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable disposable) {
                        mFragment.showLoading();
                    }

                    @Override
                    public void onNext(@NonNull LiveEntity liveEntity) {
                        Log.d(TAG, "onNext: " + liveEntity.toString());
                        mFragment.onDataLoaded(liveEntity);
                    }

                    @Override
                    public void onError(@NonNull Throwable throwable) {
                        Log.d(TAG, "onError: " + throwable.toString());
                        mFragment.showNetworkError();
                    }

                    @Override
                    public void onComplete() {
                        mFragment.hideNoNetwork();
                        mFragment.cancelLoading();
                    }
                });
    }
}
