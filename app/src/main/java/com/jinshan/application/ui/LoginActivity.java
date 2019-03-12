package com.jinshan.application.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.jinshan.application.R;
import com.jinshan.application.base.BaseActivity;
import com.jinshan.application.entity.LoginResponse;
import com.jinshan.application.http.UserProvider;
import com.jinshan.application.util.CacheHelper;
import com.jinshan.application.util.CodeUtil;
import com.minilive.library.http.callback.OnJsonCallBack;
import com.minilive.library.util.Trace;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {
    @BindView(R.id.etUserName)
    EditText etUserName;
    @BindView(R.id.etUserPassword)
    EditText etUserPassword;
    @BindView(R.id.etCode)
    EditText etCode;
    @BindView(R.id.ivAuthCode)
    ImageView ivAuthCode;
    @BindView(R.id.tvRegister)
    TextView tvRegister;
    @BindView(R.id.tvForget)
    TextView tvForget;
    @BindView(R.id.btnLogin)
    Button btnLogin;

    @Override
    protected boolean isRegisterEventBus() {
        return false;
    }

    @Override
    protected void initViewAndData() {
        ButterKnife.bind(this);
        ivAuthCode.setImageBitmap(CodeUtil.getInstance().createBitmap());
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_login;
    }

    @OnClick({R.id.ivAuthCode, R.id.tvRegister, R.id.tvForget, R.id.btnLogin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ivAuthCode:
                ivAuthCode.setImageBitmap(CodeUtil.getInstance().createBitmap());
                break;
            case R.id.tvRegister:
                break;
            case R.id.tvForget:
                break;
            case R.id.btnLogin:
                String phone = etUserName.getText().toString();
                String password = etUserPassword.getText().toString();
                String autoCode = etCode.getText().toString();
                if (autoCode.toLowerCase().equals(CodeUtil.getInstance().getCode().toLowerCase())){
                    login(phone, password);
                } else {
                    showToast("输入的验证码不正确，请重新输入");
                }
                break;
        }
    }

    private void login(final String phone, final String password) {
        UserProvider.login(this, phone, password, new OnJsonCallBack<LoginResponse>() {
            @Override
            public void onResult(LoginResponse data) {
               if (data != null){
                   CacheHelper.getInstance().putToken(data.getAccess_token());
                   CacheHelper.getInstance().put("name" , phone);
                   CacheHelper.getInstance().put("password" , password);
                    jumpToThenKill(HomeActivity.class);
               } else {
                   showToast("登录失败");
               }
            }

            @Override
            public void onError(String msg) {
                super.onError(msg);
                showToast(msg);
            }
        });
    }
}
