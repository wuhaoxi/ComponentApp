package com.wu.voice.view.home.adapter;

import com.wu.voice.view.VideoFragment;
import com.wu.voice.view.discory.DiscoryFragment;
import com.wu.voice.view.friend.FriendFragment;
import com.wu.voice.model.CHANNEL;
import com.wu.voice.view.mine.MineFragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class HomePagerAdapter extends FragmentPagerAdapter {

    private CHANNEL[] mList;

    public HomePagerAdapter(FragmentManager fm, CHANNEL[] datas) {
        super(fm);
        mList = datas;
    }

    @Override
    public Fragment getItem(int position) {
        int type = mList[position].getValue();
        switch (type) {
            case CHANNEL.MINE_ID:
                return MineFragment.newInstance();
            case CHANNEL.DISCORY_ID:
                return DiscoryFragment.newInstance();
            case CHANNEL.FRIEND_ID:
                return FriendFragment.newInstance();
            case CHANNEL.VIDEO_ID:
                return VideoFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.length;
    }
}
