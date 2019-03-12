package com.jinshan.application.ui.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jinshan.application.R;
import com.jinshan.application.base.BaseFragment;
import com.jinshan.application.ui.AboutUSActivity;
import com.jinshan.application.ui.AppActivity;
import com.jinshan.application.ui.FeedBackActivity;
import com.jinshan.application.ui.LoginActivity;
import com.jinshan.application.util.CacheHelper;
import com.jinshan.application.view.LineView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MineFragment extends BaseFragment {
    @BindView(R.id.lvUpdatePassword)
    LineView lvUpdatePassword;
    @BindView(R.id.lvUser)
    LineView lvUser;
    @BindView(R.id.lvFeedBack)
    LineView lvFeedBack;
    @BindView(R.id.lvBack)
    LineView lvBack;
    @BindView(R.id.lvAboutUs)
    LineView lvAboutUs;
    @BindView(R.id.btnLogout)
    Button btnLogout;
    Unbinder unbinder;

    private AlertDialog mAlertDialog;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initViewAndData() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.lvUpdatePassword, R.id.lvUser, R.id.lvFeedBack, R.id.lvBack, R.id.lvAboutUs, R.id.btnLogout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lvUpdatePassword:
                break;
            case R.id.lvUser:
                jumpTo(AboutUSActivity.class);
                break;
            case R.id.lvFeedBack:
                jumpTo(FeedBackActivity.class);
                break;
            case R.id.lvBack:
                break;
            case R.id.lvAboutUs:
                jumpTo(AppActivity.class);
                break;
            case R.id.btnLogout:
                logout();
                break;
        }
    }

    private void logout() {
        if (mAlertDialog == null){
            mAlertDialog= new AlertDialog.Builder(getActivity()).setMessage("是否退出登录")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            CacheHelper.getInstance().clear();
                            Intent intent = new Intent(getActivity(), LoginActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    }).setNegativeButton("取消",null).create();
        }
        mAlertDialog.show();
    }
}
