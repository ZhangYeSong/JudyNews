package com.song.judynews.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.song.judynews.fragment.SubTabFragment;

import java.util.List;

/**
 * Created by judy on 2017/7/1.
 */

public class NewsPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments;
    private List<String> mTitles;

    public NewsPagerAdapter(FragmentManager fm, List<Fragment> fragments, List<String> titles) {
        super(fm);
        mFragments = fragments;
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        SubTabFragment fragment = (SubTabFragment) mFragments.get(position);
        return fragment;
    }

    @Override
    public int getCount() {
        return mTitles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    public void setTitles(List<String> titles) {
        mTitles.clear();
        mTitles.addAll(titles);
    }

    public void setFragments(List<Fragment> fragments) {
        mFragments.clear();
        mFragments.addAll(fragments);
    }
}
