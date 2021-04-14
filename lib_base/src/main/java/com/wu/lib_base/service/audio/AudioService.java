package com.wu.lib_base.service.audio;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * 音频基础库对外接口
 */
public interface AudioService extends IProvider {
    void pauseAudio();

    void resumeAudio();

}
