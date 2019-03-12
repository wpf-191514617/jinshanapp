package com.jinshan.application.ui;

import android.os.Bundle;
import android.widget.Button;

import com.jinshan.application.R;
import com.jinshan.application.base.BaseActivity;
import com.jinshan.application.entity.ServiceData;
import com.jinshan.application.http.HomeProvider;
import com.jinshan.application.util.ServiceDialog;
import com.minilive.library.http.callback.OnJsonCallBack;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AboutUSActivity extends BaseActivity {
    @BindView(R.id.btnOpen)
    Button btnOpen;

    private ServiceData serviceData;

    private ServiceDialog mServiceDialog;

    @Override
    protected boolean isRegisterEventBus() {
        return false;
    }

    @Override
    protected void initViewAndData() {
        ButterKnife.bind(this);
        setTitle("会员中心");
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_about_us;
    }

    @OnClick(R.id.btnOpen)
    public void onViewClicked() {
        if (serviceData == null){
        HomeProvider.getServiceData(this, new OnJsonCallBack<ServiceData>() {
            @Override
            public void onResult(ServiceData data) {
                if (data != null){
                    serviceData = data;
                    showDialog();
                }
            }
        });} else {
            showDialog();
        }
    }

    private void showDialog(){
        if (mServiceDialog == null){
            mServiceDialog = new ServiceDialog(this);
            mServiceDialog.setData(serviceData);
        }
        mServiceDialog.show();
    }
}
