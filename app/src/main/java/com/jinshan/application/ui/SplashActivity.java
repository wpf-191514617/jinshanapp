package com.jinshan.application.ui;

import android.os.Bundle;
import android.os.Handler;

import com.jinshan.application.R;
import com.jinshan.application.base.BaseActivity;
import com.jinshan.application.entity.LoginResponse;
import com.jinshan.application.http.UserProvider;
import com.jinshan.application.util.CacheHelper;
import com.minilive.library.http.callback.OnJsonCallBack;
import com.minilive.library.util.StringUtils;

public class SplashActivity extends BaseActivity {
    @Override
    protected boolean isRegisterEventBus() {
        return false;
    }

    @Override
    protected void initViewAndData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                checkToken();
            }
        }, 2000);
    }

    private void checkToken() {
        if (StringUtils.isEmpty(CacheHelper.getInstance().getToken())){
            jumpToThenKill(LoginActivity.class);
            return;
        }

        String name = CacheHelper.getInstance().get("name");
        String password = CacheHelper.getInstance().get("password");

        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password)){
            jumpToThenKill(LoginActivity.class);
            return;
        }

        UserProvider.login(this, name, password, new OnJsonCallBack<LoginResponse>() {
            @Override
            public void onResult(LoginResponse data) {
                if (data != null){
                    CacheHelper.getInstance().putToken(data.getAccess_token());
                    jumpToThenKill(HomeActivity.class);
                }
            }
        });

    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_splash;
    }
}
