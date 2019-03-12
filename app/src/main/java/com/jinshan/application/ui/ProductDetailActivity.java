package com.jinshan.application.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jinshan.application.R;
import com.jinshan.application.base.BaseActivity;
import com.jinshan.application.entity.ProductDetailResponse;
import com.jinshan.application.entity.ProductEntity;
import com.jinshan.application.entity.UserResponse;
import com.jinshan.application.http.HomeProvider;
import com.jinshan.application.http.ProductProvider;
import com.jinshan.application.http.UserProvider;
import com.jinshan.application.util.CacheHelper;
import com.jinshan.application.util.PublishDialog;
import com.jinshan.application.util.UserDialog;
import com.minilive.library.http.callback.OnJsonCallBack;
import com.minilive.library.util.StringUtils;
import com.minilive.library.util.Trace;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductDetailActivity extends BaseActivity {
    @BindView(R.id.tvHight)
    TextView tvHight;
    @BindView(R.id.tvTag)
    TextView tvTag;
    @BindView(R.id.tvDaySwaps)
    TextView tvDaySwaps;
    @BindView(R.id.tvSpeed)
    TextView tvSpeed;
    @BindView(R.id.tvTerm)
    TextView tvTerm;
    @BindView(R.id.tvPublish)
    TextView tvPublish;
    @BindView(R.id.tvRegist)
    TextView tvRegist;
    @BindView(R.id.layoutContent)
    LinearLayout layoutContent;
    @BindView(R.id.tvTiaojian)
    TextView tvTiaojian;
    private ProductEntity mProductEntity;

    private UserDialog mUserDialog;

    private String name, phone, id;


    private String userId;

    private PublishDialog mPublishDialog;

    @Override
    protected boolean isRegisterEventBus() {
        return false;
    }

    @Override
    protected void initViewAndData() {
        if (mProductEntity != null) {
            setTitle(mProductEntity.getName());
            getData();
        }
    }

    private void getData() {
        showLoading("");
        ProductProvider.getDetail(this, String.valueOf(mProductEntity.getId()), new OnJsonCallBack<ProductDetailResponse>() {
            @Override
            public void onResult(ProductDetailResponse data) {
                reStoreView();
                if (data != null && data.getLoanCrack() != null) {
                    setData(data.getLoanCrack());
                }
            }

            @Override
            public void onError(String msg) {
                super.onError(msg);
                reStoreView();
            }
        });
    }

    private void setData(ProductDetailResponse.LoanCrackBean loanCrack) {
        setText(tvHight, String.valueOf(loanCrack.getUpperLimit()));
        setText(tvDaySwaps, loanCrack.getDayrate() + "%");
        setText(tvSpeed, String.valueOf(loanCrack.getLoanSpeed()) + "小时");
        setText(tvTerm, String.valueOf(loanCrack.getLoanDeadline()) + "天");

        String app1 = loanCrack.getApplicationConditions1();
        String app2 = loanCrack.getApplicationConditions2();
        String app3 = loanCrack.getApplicationConditions3();
        String app4 = loanCrack.getApplicationConditions4();
        StringBuilder sb = new StringBuilder();
        if (!StringUtils.isEmpty(app1)) {
            sb.append("1、").append(app1).append('\n');
        }
        if (!StringUtils.isEmpty(app2)) {
            sb.append("2、").append(app2).append('\n');
        }
        if (!StringUtils.isEmpty(app3)) {
            sb.append("3、").append(app3).append('\n');
        }
        if (!StringUtils.isEmpty(app4)) {
            sb.append("4、").append(app4).append('\n');
        }

        setText(tvTiaojian, sb.toString());
    }

    @Override
    protected void getBundleExtras(Bundle extras) {
        mProductEntity = (ProductEntity) extras.getSerializable("data");
    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_detail;
    }

    @Override
    protected View getLoadingTargetView() {
        return findViewById(R.id.layoutContent);
    }


    @OnClick({R.id.tvPublish, R.id.tvRegist})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvPublish:
                generate();
                break;
            case R.id.tvRegist:
                name = CacheHelper.getInstance().get("userName");
                phone = CacheHelper.getInstance().get("userPhone");
                id = CacheHelper.getInstance().get("userID");

                if (!StringUtils.isEmpty(name) &&
                        !StringUtils.isEmpty(phone) &&
                        !StringUtils.isEmpty(id)) {
                    addUserMake();
                } else {
                    if (mUserDialog == null) {
                        mUserDialog = new UserDialog(this);
                    }
                    mUserDialog.show();
                }

                break;

        }
    }

    private void generate() {
        if (StringUtils.isEmpty(userId)){
            UserProvider.getUserId(this, new OnJsonCallBack<UserResponse>() {
                @Override
                public void onResult(UserResponse data) {
                    if (data != null){
                        userId = data.getUserId();
                    }
                    showPublishDialog();
                }
            });
        } else {
            showPublishDialog();
        }
    }

    private void showPublishDialog(){
        if (mPublishDialog == null){
            mPublishDialog = new PublishDialog(this);
            mPublishDialog.setData(String.valueOf(mProductEntity.getId()) , userId);
        }
        mPublishDialog.show();
    }

    private void addUserMake() {
        UserProvider.addUserLog(this, name, phone, id, String.valueOf(mProductEntity.getId()), new OnJsonCallBack() {
            @Override
            public void onResult(Object data) {
                jumpTo();
            }

            @Override
            public void onError(String msg) {
                super.onError(msg);
                jumpTo();
            }
        });
    }

    private void jumpTo() {
        Uri uri;
        if (!StringUtils.isEmpty(mProductEntity.getAccessPath())) {
            uri = Uri.parse(mProductEntity.getAccessPath());
        } else {
            uri = Uri.parse(mProductEntity.getSparePath());
        }
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
