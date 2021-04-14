package com.wu.lib_audio.app.service;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wu.lib_audio.mediaplayer.core.AudioController;
import com.wu.lib_base.service.audio.AudioService;

/**
 * AudioService的实现类
 */
@Route(path = "/audio/audio_service")
public class AudioServiceImpl implements AudioService {
    @Override
    public void pauseAudio() {
        AudioController.getInstance().pause();
    }

    @Override
    public void resumeAudio() {
        AudioController.getInstance().resume();
    }


    @Override
    public void init(Context context) {

    }
}
