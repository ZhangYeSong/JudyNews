package com.song.judynews.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.song.judynews.R;
import com.song.judynews.entity.JokeEntity;

import java.util.List;

/**
 * Created by judy on 2017/6/30.
 */

public class JokeAdapter extends RecyclerView.Adapter<JokeAdapter.JokeHolder> {
    private Context mContext;
    private List<JokeEntity.NewslistBean> mData;

    public JokeAdapter(Context context, List<JokeEntity.NewslistBean> data) {
        mContext = context;
        mData = data;
    }

    static class JokeHolder extends RecyclerView.ViewHolder {

        private final TextView mTitle;
        private final TextView mContent;

        public JokeHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.tv_title);
            mContent = (TextView) itemView.findViewById(R.id.tv_content);
        }
    }

    @Override
    public JokeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new JokeHolder(View.inflate(mContext, R.layout.item_joke, null));
    }

    @Override
    public void onBindViewHolder(JokeHolder holder, int position) {
        JokeEntity.NewslistBean bean = mData.get(position);
        holder.mTitle.setText(bean.getTitle());
        holder.mContent.setText(contentFormat(bean.getContent()));
    }

    private String contentFormat(String content) {
        return content.replace("<br/>", "");
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

}
