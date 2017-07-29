package com.song.judynews.activity;

import android.os.Bundle;

import com.song.judynews.R;
import com.song.judynews.presenter.PlayPresenter;

public class PlayActivity extends BaseActivity {
    private PlayPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new PlayPresenter(this);
        mPresenter.initData();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_play;
    }

    @Override
    protected void initViews() {

    }
}
