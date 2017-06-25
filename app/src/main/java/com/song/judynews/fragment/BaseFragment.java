package com.song.judynews.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.song.judynews.R;
import com.song.judynews.activity.HomeActivity;

/**
 * Created by Judy on 2017/6/25.
 */

public abstract class BaseFragment extends Fragment {

    protected HomeActivity mActivity;
    protected View mRootView;
    private Dialog mLoaing;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getPresenter();
        mActivity = (HomeActivity) getActivity();
        mRootView = inflater.inflate(getLayoutId(), container, false);
        return mRootView;
    }

    protected abstract void getPresenter();

    protected abstract int getLayoutId();

    protected void showLoading() {
        if (mLoaing == null) {
            mLoaing = new Dialog(mActivity);
            mLoaing.setContentView(R.layout.loading);
            ImageView ivLoading = (ImageView) mLoaing.findViewById(R.id.iv_loading);
            Animation animation = AnimationUtils.loadAnimation(mActivity, R.anim.loading);
            ivLoading.setAnimation(animation);
        }
        mLoaing.show();
    }

    protected void showNetworkError() {

    }

    protected void showshowEmpty() {

    }

    protected void cancelLoaing() {
        if(mLoaing != null) {
            mLoaing.dismiss();
        }
    }
}
