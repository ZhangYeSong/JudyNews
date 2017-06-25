package com.song.judynews.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.song.judynews.R;
import com.song.judynews.presenter.HomePresenter;
import com.song.judynews.util.Constants;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private HomePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mPresenter = new HomePresenter(this);

        //进行各种初始化
        initView();
        mPresenter.initData();
    }

    private void initView() {
        Toolbar toolBar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolBar);
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
                Intent intent = mPresenter.toEditModule();
                startActivityForResult(intent, Constants.REQUEST_SELECT);
                break;
        }
        return super.onOptionsItemSelected(item);
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
}
