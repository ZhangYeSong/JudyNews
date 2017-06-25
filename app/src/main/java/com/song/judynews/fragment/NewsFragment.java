package com.song.judynews.fragment;

import com.song.judynews.R;
import com.song.judynews.presenter.NewsPresenter;

/**
 * Created by Judy on 2017/6/25.
 */

public class NewsFragment extends BaseFragment {

    private NewsPresenter mPresenter;

    @Override
    protected void getPresenter() {
        mPresenter = new NewsPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news;
    }
}
