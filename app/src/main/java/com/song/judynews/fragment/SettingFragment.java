package com.song.judynews.fragment;

import com.song.judynews.R;
import com.song.judynews.presenter.SettingPresenter;

/**
 * Created by Judy on 2017/6/25.
 */

public class SettingFragment extends BaseFragment {

    private SettingPresenter mPresenter;

    @Override
    protected void getPresenter() {
        mPresenter = new SettingPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_setting;
    }

    @Override
    protected void reconnect() {

    }
}
