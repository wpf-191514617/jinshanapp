package com.jinshan.application.ui;

import android.os.Bundle;

import com.jinshan.application.R;
import com.jinshan.application.base.BaseActivity;

public class SetActivity extends BaseActivity {
    @Override
    protected boolean isRegisterEventBus() {
        return false;
    }

    @Override
    protected void initViewAndData() {
        setTitle("系列汇总");
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_set;
    }
}
