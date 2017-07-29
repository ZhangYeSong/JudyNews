package com.song.judynews.activity;

import android.net.Uri;
import android.os.Bundle;

import com.song.judynews.R;
import com.song.judynews.presenter.PlayPresenter;

import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.VideoView;

public class PlayActivity extends BaseActivity {
    private PlayPresenter mPresenter;
    private VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Vitamio.isInitialized(this);
        mPresenter = new PlayPresenter(this);
        mPresenter.initData();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_play;
    }

    @Override
    protected void initViews() {
        mVideoView = (VideoView) findViewById(R.id.vitamio);
    }

    public void onUrlLoaded(String hls_url) {
        mVideoView.setVideoURI(Uri.parse(hls_url));
        mVideoView.start();
    }
}
