package com.song.judynews.presenter;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

import com.song.judynews.activity.PlayActivity;
import com.song.judynews.component.APIService;
import com.song.judynews.component.RetrofitManager;
import com.song.judynews.entity.RoomIdEntity;
import com.song.judynews.util.Urls;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by judy on 2017/7/29.
 */

public class PlayPresenter {
    private static final String TAG = "PlayPresenter";
    private PlayActivity mActivity;
    private String mRoomId;
    private String mHls_url;

    public PlayPresenter(PlayActivity playActivity) {
        mActivity = playActivity;
    }

    public void initData() {
        Intent intent = mActivity.getIntent();
        mRoomId = intent.getStringExtra("room_id");
        if (mRoomId!=null && !TextUtils.isEmpty(mRoomId)) {
            getLiveUrl();
        }
    }

    private void getLiveUrl() {
        APIService apiService = RetrofitManager.getInstance(mActivity).
                create(APIService.class);

        Observable<RoomIdEntity> roomIdEntity = apiService.getRoomIdEntity(Urls.DouyuRoomUrl, mRoomId);

        roomIdEntity.subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Observer<RoomIdEntity>() {
                    //简化处理
                    @Override
                    public void onSubscribe(@NonNull Disposable disposable) {

                    }

                    @Override
                    public void onNext(@NonNull RoomIdEntity roomIdEntity) {
                        Log.d(TAG, "onNext: "+roomIdEntity.toString());
                        mHls_url = roomIdEntity.getData().getHls_url();
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
