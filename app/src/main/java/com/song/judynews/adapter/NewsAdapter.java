package com.song.judynews.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.song.judynews.R;
import com.song.judynews.activity.HomeActivity;
import com.song.judynews.activity.WebViewActivity;
import com.song.judynews.entity.NewsEntity;

import java.util.List;

/**
 * Created by judy on 2017/7/1.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {
    private Context mContext;
    private List<NewsEntity.NewslistBean> mData;

    public NewsAdapter(Context context, List<NewsEntity.NewslistBean> data) {
        mContext = context;
        mData = data;
    }

    static class NewsHolder extends RecyclerView.ViewHolder {
        private ImageView mIvPic;
        private TextView mTvTitle;
        private TextView mTvDes;
        private TextView mTvDate;

        public NewsHolder(View itemView) {
            super(itemView);
            mIvPic = (ImageView) itemView.findViewById(R.id.iv_pic);
            mTvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            mTvDes = (TextView) itemView.findViewById(R.id.tv_des);
            mTvDate = (TextView) itemView.findViewById(R.id.tv_date);
        }
    }

    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewsHolder(View.inflate(mContext, R.layout.item_news, null));
    }

    @Override
    public void onBindViewHolder(NewsHolder holder, int position) {
        final NewsEntity.NewslistBean bean = mData.get(position);
        Glide.with(mContext).load(bean.getPicUrl()).
                error(R.mipmap.ic_launcher).
                diskCacheStrategy(DiskCacheStrategy.RESULT).
                into(holder.mIvPic);
        holder.mTvTitle.setText(bean.getTitle());
        holder.mTvDes.setText(bean.getDescription());
        holder.mTvDate.setText(bean.getCtime());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("url", bean.getUrl());
                ((HomeActivity)mContext).startActivity(WebViewActivity.class, bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setData(List<NewsEntity.NewslistBean> data) {
        mData.clear();
        mData.addAll(data);
    }

    public void addData(List<NewsEntity.NewslistBean> data) {
        mData.addAll(data);
    }

}
