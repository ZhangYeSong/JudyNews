package com.song.judynews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.song.judynews.R;
import com.song.judynews.adapter.NewsAdapter;
import com.song.judynews.entity.NewsEntity;
import com.song.judynews.presenter.SubTabPresenter;
import com.song.judynews.util.Urls;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by judy on 2017/7/1.
 */

public class SubTabFragment extends BaseFragment implements XRecyclerView.LoadingListener {

    private static final String TAG = "SubTabFragment";
    private SubTabPresenter mPresenter;
    private XRecyclerView mRecyclerView;
    private List<NewsEntity.NewslistBean> mData;
    private NewsAdapter mAdapter;
    private String mUrl;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        mPresenter.loadDataFromNet(mRecyclerView);
    }

    private void initView(View view) {
        mData = new ArrayList<>();
        mRecyclerView = (XRecyclerView) view.findViewById(R.id.rv_joke);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mRecyclerView.setLoadingListener(this);
        refreshRecyclerView();
    }

    private void refreshRecyclerView() {
        if (mAdapter == null) {
            mAdapter = new NewsAdapter(mActivity, mData);
            mRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    public void onDataLoaded(NewsEntity newsEntity) {
        if (newsEntity.getCode() == 200) {
            mData.clear();
            mData.addAll(newsEntity.getNewslist());
            refreshRecyclerView();
        } else {
            mActivity.showToast(newsEntity.getMsg());
        }
    }

    @Override
    protected void getPresenter() {
        mPresenter = new SubTabPresenter(this, mUrl);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_sub_tab;
    }

    @Override
    protected void reconnect() {
        mPresenter.loadDataFromNet(mRecyclerView);
    }

    @Override
    public void onRefresh() {
        mPresenter.loadDataFromNet(mRecyclerView);
    }

    @Override
    public void onLoadMore() {
        //上拉加载更多后段暂不支持
        mRecyclerView.loadMoreComplete();
    }

    public void setUrl(String url) {
        mUrl = Urls.getUrlByTitle(url);
    }
}
