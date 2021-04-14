package com.wu.voice.view.loading;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;

import com.wu.voice.R;
import com.wu.voice.view.home.HomeActivity;
import com.wu.lib_common_ui.base.BaseActivity;
import com.wu.lib_common_ui.base.constant.Constant;
import com.wu.lib_pullalive.app.AliveJobService;

public class LoadingActivity extends BaseActivity {

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            startActivity(new Intent(LoadingActivity.this, HomeActivity.class));
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_layout);
        pullAliveService();
        if (hasPermission(Constant.WRITE_READ_EXTERNAL_PERMISSION)) {
            doSDCardPermission();
        } else {
            requestPermission(Constant.WRITE_READ_EXTERNAL_CODE, Constant.WRITE_READ_EXTERNAL_PERMISSION);
        }
    }

    private void pullAliveService() {
        AliveJobService.start(this);
    }

    @Override
    public void doSDCardPermission() {
        mHandler.sendEmptyMessageDelayed(0, 3000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }
}
