package com.wu.voice.utils;

import com.wu.voice.model.user.User;

/**
 * 单例管理登录用户信息
 */
public class UserManager {

    private static UserManager mInstance = null;
    private User mUser = null;

    public static UserManager getInstance() {
        if (mInstance == null) {
            synchronized (UserManager.class) {
                if (mInstance == null) {
                    mInstance = new UserManager();
                }
            }
        }
        return mInstance;
    }

    /**
     * init the user
     */
    public void setUser(User user) {
        mUser = user;
    }

    public boolean hasLogined() {
        return mUser == null ? false : true;
    }


    /**
     * has user info
     */
    public User getUser() {

        return mUser;
    }

    /**
     * remove the user info
     */
    public void removeUser() {
        mUser = null;
    }

}
