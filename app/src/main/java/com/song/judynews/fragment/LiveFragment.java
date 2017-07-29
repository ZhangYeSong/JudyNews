package com.song.judynews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.song.judynews.R;
import com.song.judynews.adapter.LiveAdapter;
import com.song.judynews.entity.LiveEntity;
import com.song.judynews.presenter.LivePresenter;

import java.util.ArrayList;

/**
 * Created by Judy on 2017/6/25.
 */

public class LiveFragment extends BaseFragment implements XRecyclerView.LoadingListener {

    private LivePresenter mPresenter;
    private ArrayList<LiveEntity.DataBean> mData;
    private XRecyclerView mRecyclerView;
    private LiveAdapter mAdapter;

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
        mPresenter.loadDataFromNet();
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
        mRecyclerView.setLayoutManager(new GridLayoutManager(mActivity, 2));
        mRecyclerView.setLoadingListener(this);
        refreshRecyclerView();
    }

    private void refreshRecyclerView() {
        if (mAdapter == null) {
            mAdapter = new LiveAdapter(mActivity, mData);
            mRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
            mRecyclerView.refreshComplete();
        }
    }

    public void onDataLoaded(LiveEntity liveEntity) {
        if (liveEntity.getError() == 0) {
            mData.clear();
            mData.addAll(liveEntity.getData());
            refreshRecyclerView();
        } else {
            mActivity.showToast("错误码：" + liveEntity.getError());
        }
    }

    @Override
    public void onRefresh() {
        mPresenter.loadDataFromNet();
    }

    @Override
    public void onLoadMore() {
        //后端接口暂不支持
        mRecyclerView.loadMoreComplete();
    }

}
