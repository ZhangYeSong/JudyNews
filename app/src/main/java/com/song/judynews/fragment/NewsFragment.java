package com.song.judynews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.song.judynews.R;
import com.song.judynews.adapter.NewsPagerAdapter;
import com.song.judynews.presenter.NewsPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Judy on 2017/6/25.
 */

public class NewsFragment extends BaseFragment {
    private static final String TAG = "NewsFragment";
    private TabLayout mTlNews;
    private ViewPager mVpNews;
    private NewsPagerAdapter mPagerAdapter;
    private List<Fragment> mFragments;
    private List<String> mTitles;

    private NewsPresenter mPresenter;

    @Override
    protected void getPresenter() {
        mPresenter = new NewsPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);

    }

    private void initView(View view) {
        mTlNews = (TabLayout) view.findViewById(R.id.tl_news);
        mVpNews = (ViewPager) view.findViewById(R.id.vp_news);
        mTlNews.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTlNews.setSmoothScrollingEnabled(true);

        refreshViewPager();
    }

    private void refreshViewPager() {
        mTitles = mActivity.getShowList();
        Log.d(TAG, "initView: "+mTitles.toString());
        if (mFragments == null) {
            mFragments = new ArrayList<>();
        } else {
            mFragments.clear();
        }

        for (String title : mTitles) {
            SubTabFragment tabFragment = new SubTabFragment();
            tabFragment.setUrl(title);
            mFragments.add(tabFragment);
        }

        if (mPagerAdapter == null) {
            mPagerAdapter = new NewsPagerAdapter(getChildFragmentManager(),
                    mFragments, mTitles);
            mVpNews.setAdapter(mPagerAdapter);
            mTlNews.setupWithViewPager(mVpNews, true);
        } else {
            mPagerAdapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void reconnect() {

    }
}
