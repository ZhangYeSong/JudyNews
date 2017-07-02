package com.song.judynews.presenter;

import android.util.Log;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.song.judynews.component.APIService;
import com.song.judynews.component.RetrofitManager;
import com.song.judynews.entity.NewsEntity;
import com.song.judynews.fragment.SubTabFragment;
import com.song.judynews.util.Urls;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by judy on 2017/7/1.
 */

public class SubTabPresenter {
    private static final String TAG = "SubTabPresenter";
    private SubTabFragment mFragment;
    private final int REQUEST_NUM = 30;

    public SubTabPresenter(SubTabFragment subTabFragment) {
        mFragment = subTabFragment;
    }

    public void loadDataFromNet(final XRecyclerView recyclerView) {
        APIService apiService = RetrofitManager.
                getInstance(mFragment.mActivity).
                create(APIService.class);

        Observable<NewsEntity> newsEntityObservable = apiService.getSocialEntity(Urls.APIKEY, REQUEST_NUM);
        newsEntityObservable.subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<NewsEntity>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable disposable) {
                        mFragment.showLoading();
                    }

                    @Override
                    public void onNext(@NonNull NewsEntity newsEntity) {
                        Log.d(TAG, "onNext: "+newsEntity.toString());
                        mFragment.onDataLoaded(newsEntity);
                    }

                    @Override
                    public void onError(@NonNull Throwable throwable) {
                        Log.d(TAG, "onError: "+throwable.toString());
                        mFragment.showNetworkError();
                        recyclerView.refreshComplete();
                    }

                    @Override
                    public void onComplete() {
                        mFragment.hideNoNetwork();
                        mFragment.cancelLoading();
                        recyclerView.refreshComplete();
                    }
                });

    }
}
