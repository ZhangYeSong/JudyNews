package com.song.judynews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.song.judynews.R;
import com.song.judynews.adapter.JokeAdapter;
import com.song.judynews.entity.JokeEntity;
import com.song.judynews.presenter.JokePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Judy on 2017/6/25.
 */

public class JokeFragment extends BaseFragment {

    private static final String TAG = "JokeFragment";
    private JokePresenter mPresenter;
    private RecyclerView mRecyclerView;
    private List<JokeEntity.NewslistBean> mData;
    private JokeAdapter mAdapter;

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
        initView(view);
        mPresenter.loadDataFromNet();
    }

    private void initView(View view) {
        mData = new ArrayList<>();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_joke);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        refreshRecyclerView();
    }

    private void refreshRecyclerView() {
        if (mAdapter == null) {
            mAdapter = new JokeAdapter(mActivity, mData);
            mRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    public void onDataLoaded(JokeEntity jokeEntity) {
        if (jokeEntity.getCode() == 200) {
            mData.clear();
            mData.addAll(jokeEntity.getNewslist());
            refreshRecyclerView();
        } else {
            mActivity.showToast(jokeEntity.getMsg());
        }
    }

    @Override
    protected void reconnect() {
        mPresenter.loadDataFromNet();
    }
}
