package com.song.judynews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.song.judynews.R;
import com.song.judynews.presenter.JokePresenter;

/**
 * Created by Judy on 2017/6/25.
 */

public class JokeFragment extends BaseFragment {

    private JokePresenter mPresenter;

    @Override
    protected void getPresenter() {
        mPresenter = new JokePresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_joke;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //showLoading();
    }
}
