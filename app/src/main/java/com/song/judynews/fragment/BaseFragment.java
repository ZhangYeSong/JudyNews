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
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.song.judynews.R;
import com.song.judynews.activity.HomeActivity;

/**
 * Created by Judy on 2017/6/25.
 */

public abstract class BaseFragment extends Fragment implements View.OnClickListener {

    public HomeActivity mActivity;
    protected View mRootView;
    private Dialog mLoading;
    private View mNoNetwork;
    private Button mReConnect;
    private FrameLayout mFrameLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getPresenter();
        if (mFrameLayout == null) {
            mActivity = (HomeActivity) getActivity();
            mRootView = inflater.inflate(getLayoutId(), container, false);
            mNoNetwork = inflater.inflate(R.layout.no_network, container, false);
            mReConnect = (Button) mNoNetwork.findViewById(R.id.bt_reconnect);
            mReConnect.setOnClickListener(this);
            mFrameLayout = new FrameLayout(mActivity);
            mFrameLayout.addView(mRootView);
            mFrameLayout.addView(mNoNetwork);
        }
        return mFrameLayout;
    }

    protected abstract void getPresenter();

    protected abstract int getLayoutId();

    public void showLoading() {
        if (mLoading == null) {
            mLoading = new Dialog(mActivity);
            mLoading.setContentView(R.layout.loading);
            ImageView ivLoading = (ImageView) mLoading.findViewById(R.id.iv_loading);
            Animation animation = AnimationUtils.loadAnimation(mActivity, R.anim.loading);
            ivLoading.setAnimation(animation);
        }
        mLoading.show();
    }

    public void showNetworkError() {
        mNoNetwork.setVisibility(View.VISIBLE);
        cancelLoading();
    }

    public void cancelLoading() {
        if(mLoading != null) {
            mLoading.dismiss();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_reconnect:
                reconnect();
        }
    }

    protected abstract void reconnect();

    public void hideNoNetwork() {
        mNoNetwork.setVisibility(View.GONE);
    }
}
