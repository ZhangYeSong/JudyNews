package com.song.judynews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.song.judynews.R;
import com.song.judynews.presenter.LivePresenter;

import java.util.ArrayList;

/**
 * Created by Judy on 2017/6/25.
 */

public class LiveFragment extends BaseFragment implements XRecyclerView.LoadingListener {

    private LivePresenter mPresenter;
    private ArrayList<Object> mData;
    private XRecyclerView mRecyclerView;

    @Override
    protected void getPresenter() {
        mPresenter = new LivePresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_live;
    }

    @Override
    protected void reconnect() {

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        mPresenter.loadDataFromNet();
    }

    private void initView(View view) {
        mData = new ArrayList<>();
        mRecyclerView = (XRecyclerView) view.findViewById(R.id.rv_live);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mRecyclerView.setLoadingListener(this);
        refreshRecyclerView();
    }

    private void refreshRecyclerView() {
        // TODO: 2017/7/29  
    }

    @Override
    public void onRefresh() {
        mPresenter.loadDataFromNet();
    }

    @Override
    public void onLoadMore() {

    }
}
