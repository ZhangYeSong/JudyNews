package com.song.judynews.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.song.judynews.R;
import com.song.judynews.presenter.EditModulePresenter;
import com.song.judynews.util.Constants;
import com.song.judynews.widget.DragableGridLayout;

public class EditModuleActivity extends BaseActivity {
    private EditModulePresenter mPresenter;
    private DragableGridLayout mGlMain;
    private DragableGridLayout mGlHide;
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIntent = getIntent();
        mPresenter = new EditModulePresenter(this);
        mPresenter.initData(mGlMain, mGlHide, mIntent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_edit_module;
    }

    @Override
    protected void initViews() {
        mGlMain = (DragableGridLayout) findViewById(R.id.gl_main);
        mGlHide = (DragableGridLayout) findViewById(R.id.gl_hide);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        mPresenter.saveModule(mGlMain, mGlHide, mIntent);
        setResult(Constants.RESULT_SELECT, mIntent);
        finish();
    }
}
