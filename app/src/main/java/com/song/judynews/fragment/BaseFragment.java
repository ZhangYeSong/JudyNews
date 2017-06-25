package com.song.judynews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.song.judynews.activity.HomeActivity;

/**
 * Created by Judy on 2017/6/25.
 */

public abstract class BaseFragment extends Fragment {

    protected HomeActivity mActivity;
    protected View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mActivity = (HomeActivity) getActivity();
        mRootView = inflater.inflate(getLayoutId(), container, false);
        return mRootView;
    }

    protected abstract int getLayoutId();
}
