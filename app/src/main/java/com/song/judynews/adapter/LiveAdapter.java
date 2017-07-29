package com.song.judynews.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.song.judynews.R;
import com.song.judynews.activity.HomeActivity;
import com.song.judynews.entity.LiveEntity;

import java.util.ArrayList;

/**
 * Created by judy on 2017/7/29.
 */

public class LiveAdapter extends RecyclerView.Adapter<LiveAdapter.LiveHolder>{
    private Context mContext;
    private ArrayList<LiveEntity.DataBean> mData;

    public LiveAdapter(HomeActivity activity, ArrayList<LiveEntity.DataBean> data) {
        mContext = activity;
        mData = data;
    }

    static class LiveHolder extends RecyclerView.ViewHolder {
        private final ImageView mIvPreview;
        private final TextView mRoomName;
        private final TextView mGameName;
        private final TextView mNickName;
        private final TextView mOnlineNum;

        public LiveHolder(View itemView) {
            super(itemView);
            mIvPreview = (ImageView) itemView.findViewById(R.id.iv_preview);
            mRoomName = (TextView) itemView.findViewById(R.id.room_name);
            mGameName = (TextView) itemView.findViewById(R.id.game_name);
            mNickName = (TextView) itemView.findViewById(R.id.nick_name);
            mOnlineNum = (TextView) itemView.findViewById(R.id.online_num);
        }
    }

    @Override
    public LiveHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LiveHolder(View.inflate(mContext, R.layout.item_live, null));
    }

    @Override
    public void onBindViewHolder(LiveHolder holder, int position) {
        LiveEntity.DataBean bean = mData.get(position);
        Glide.with(mContext).load(bean.getRoom_src()).into(holder.mIvPreview);
        holder.mRoomName.setText(bean.getRoom_name());
        holder.mGameName.setText(bean.getGame_name());
        holder.mNickName.setText(bean.getNickname());
        holder.mOnlineNum.setText(formateOnlineNum(bean.getOnline()));
    }

    private String formateOnlineNum(int online) {
        if (online < 10000) {
            return online+"";
        } else {
            return Math.round(online/10000)+"万";
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }



}
