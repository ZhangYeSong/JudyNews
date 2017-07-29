package com.song.judynews.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.song.judynews.R;
import com.song.judynews.fragment.BaseFragment;
import com.song.judynews.fragment.JokeFragment;
import com.song.judynews.fragment.NewsFragment;
import com.song.judynews.fragment.LiveFragment;
import com.song.judynews.presenter.HomePresenter;
import com.song.judynews.util.Constants;

import java.util.ArrayList;

public class HomeActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {
    private FrameLayout mFlHome;
    private BottomNavigationBar mBnbHome;

    private HomePresenter mPresenter;
    private NewsFragment mNewsFragment;
    private JokeFragment mJokeFragment;
    private LiveFragment mLiveFragment;
    private BaseFragment mCurrentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new HomePresenter(this);
        mPresenter.initData();
        initFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initViews() {
        Toolbar toolBar = (Toolbar) findViewById(R.id.tool_bar);
        mFlHome = (FrameLayout) findViewById(R.id.fl_home);
        mBnbHome = (BottomNavigationBar) findViewById(R.id.bnb_home);
        setSupportActionBar(toolBar);
        initBottomNavigationBar();
    }

    private void initFragment() {
        mNewsFragment = new NewsFragment();
        mJokeFragment = new JokeFragment();
        mLiveFragment = new LiveFragment();
        switchFragment(mNewsFragment);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.module:
                Bundle bundle = mPresenter.toEditModule();
                startActivityForResult(EditModuleActivity.class, bundle, Constants.REQUEST_SELECT);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initBottomNavigationBar() {
        BottomNavigationItem news = new BottomNavigationItem(R.mipmap.news, Constants.TITLES[0]);
        BottomNavigationItem joke = new BottomNavigationItem(R.mipmap.joke, Constants.TITLES[1]);
        BottomNavigationItem setting = new BottomNavigationItem(R.mipmap.setting, Constants.TITLES[2]);
        mBnbHome.addItem(news);
        mBnbHome.addItem(joke);
        mBnbHome.addItem(setting);

        mBnbHome.setActiveColor(R.color.colorPrimary);
        mBnbHome.setInActiveColor(R.color.divider);
        mBnbHome.setTabSelectedListener(this);
        mBnbHome.initialise();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constants.REQUEST_SELECT || resultCode == Constants.RESULT_SELECT) {
            ArrayList<String> showList = data.getStringArrayListExtra(Constants.SHOW_SET);
            ArrayList<String> hideList = data.getStringArrayListExtra(Constants.HIDE_SET);
            mPresenter.saveData(showList, hideList);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onTabSelected(int position) {
        switch (position) {
            case 0:
                switchFragment(mNewsFragment);
                break;
            case 1:
                switchFragment(mJokeFragment);
                break;
            case 2:
                switchFragment(mLiveFragment);
                break;
        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    private void switchFragment(BaseFragment targetFragment) {
        Log.d(TAG, "switchFragment: " + targetFragment.getTag());
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        if (mCurrentFragment == null) {
            mCurrentFragment = targetFragment;
        }

        if (!targetFragment.isAdded()) {
            transaction
                    .hide(mCurrentFragment)
                    .add(R.id.fl_home, targetFragment, targetFragment.getClass().getSimpleName())
                    .show(targetFragment)
                    .commit();
        } else {
            transaction
                    .hide(mCurrentFragment)
                    .show(targetFragment)
                    .commit();
        }
        mCurrentFragment = targetFragment;
    }

    public ArrayList<String> getShowList() {
        return mPresenter.getShowList();
    }

}
