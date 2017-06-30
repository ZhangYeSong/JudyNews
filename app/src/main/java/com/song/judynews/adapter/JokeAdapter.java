package com.song.judynews.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by judy on 2017/6/30.
 */

public class JokeAdapter extends RecyclerView.Adapter<JokeAdapter.JokeHolder> {


    public JokeAdapter() {

    }

    static class JokeHolder extends RecyclerView.ViewHolder {
        public JokeHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public JokeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(JokeHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

}
