package com.wu.lib_audio.mediaplayer.event;

import com.wu.lib_audio.mediaplayer.core.AudioController;

/**
 * 播放模式切换事件
 */
public class AudioPlayModeEvent {

    public AudioController.PlayMode mPlayMode;

    public AudioPlayModeEvent(AudioController.PlayMode playMode) {
        this.mPlayMode = playMode;
    }

}
