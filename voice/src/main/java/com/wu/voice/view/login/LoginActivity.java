package com.wu.voice.view.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.wu.voice.R;
import com.wu.voice.api.MockData;
import com.wu.voice.api.RequestCenter;
import com.wu.voice.model.login.LoginEvent;
import com.wu.voice.model.user.User;
import com.wu.voice.utils.UserManager;
import com.wu.lib_common_ui.base.BaseActivity;
import com.wu.lib_network.okhttp.response.listener.DisposeDataListener;
import com.wu.lib_network.okhttp.utils.ResponseEntityToModule;

import org.greenrobot.eventbus.EventBus;

public class LoginActivity extends BaseActivity {

    public static void start(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_layout);
        findViewById(R.id.login_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestCenter.login(new DisposeDataListener() {
                    @Override
                    public void onSuccess(Object responseObj) {
                        User user = (User) responseObj;
                        UserManager.getInstance().setUser(user);
                        //发送登陆Event
                        EventBus.getDefault().post(new LoginEvent());
                        finish();
                    }

                    @Override
                    public void onFailure(Object reasonObj) {
                        onSuccess(ResponseEntityToModule.parseJsonToModule(MockData.LOGIN_DATA, User.class));
                    }
                });
            }
        });
    }

}
