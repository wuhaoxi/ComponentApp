package com.wu.lib_share.share;

import android.content.Context;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.tencent.qzone.QZone;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;

/**
 * @author wuhx
 * @function 分享功能统一入口，负责附送数据到指定平台，可以优化为一个单例模式
 *
 */
public class ShareManager {

    private static ShareManager mShareManager = new ShareManager();

    /**
     * 要分享到的平台
     */
    private Platform mCurrentPlatform;

    public static ShareManager getInstance() {
        return mShareManager;
    }

    /**
     * 第一个执行的方法，最好在程序入口执行
     * @param context
     */
    public static void init(Context context) {
        ShareSDK.initSDK(context);
    }

    /**
     * 分享数据到不同平台
     * @param shareData
     * @param listener
     */
    public void shareData(ShareData shareData, PlatformActionListener listener) {
        switch (shareData.mPlatformType) {
            case QQ:
                mCurrentPlatform = ShareSDK.getPlatform(QQ.NAME);
                break;
            case QZone:
                mCurrentPlatform = ShareSDK.getPlatform(QZone.NAME);
                break;
            case WeChat:
                mCurrentPlatform = ShareSDK.getPlatform(Wechat.NAME);
                break;
            case WechatMoments:
                mCurrentPlatform = ShareSDK.getPlatform(WechatMoments.NAME);
                break;
            default:
                break;
        }
        mCurrentPlatform.setPlatformActionListener(listener);
        mCurrentPlatform.share(shareData.mShareParams);
    }

    /**
     * 应用程序需要的平台
     */
    public enum PlatformType {
        QQ, QZone, WeChat, WechatMoments;
    }

}
