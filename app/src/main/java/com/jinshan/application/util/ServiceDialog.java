package com.jinshan.application.util;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jinshan.application.Constant;
import com.jinshan.application.R;
import com.jinshan.application.entity.ServiceData;
import com.minilive.library.BaseAdapterUtil;
import com.minilive.library.util.DensityUtil;
import com.minilive.library.util.StringUtils;

public class ServiceDialog extends Dialog {

    private int mIndex = 0;

    private TextView tvTitle, tvContent;

    private ImageView ivCode;

    private Button btnPre , btnNext;

    public ServiceDialog(Context context) {
        super(context, R.style.customDialog);
        initView();
    }

    private void initView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_service, null);
        Window dialogWindow = getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = DensityUtil.dip2px(getContext(), 357);
        dialogWindow.setAttributes(lp);
        setContentView(view);
        setCanceledOnTouchOutside(true);
        setCancelable(true);

        tvTitle = view.findViewById(R.id.tvTitle);
        tvContent = view.findViewById(R.id.tvContent);
        ivCode = view.findViewById(R.id.ivCode);
        view.findViewById(R.id.ivClose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        btnPre = findViewById(R.id.btnPre);
        btnPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIndex--;
                initImageView();
            }
        });
        btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIndex++;
                initImageView();
            }
        });
        btnPre.setVisibility(View.INVISIBLE);
    }

    private void initImageView() {
        btnPre.setVisibility(View.VISIBLE);
        btnNext.setVisibility(View.VISIBLE);
        if (mIndex == 0){
            btnPre.setVisibility(View.INVISIBLE);
        }
        if (mServiceData != null && BaseAdapterUtil.isListNotEmpty(mServiceData.getCustomerServiceList())){
            if (mIndex == mServiceData.getCustomerServiceList().size() - 1){
                btnNext.setVisibility(View.INVISIBLE);
            }
            ServiceData.CustomerServiceListBean customerServiceListBean = mServiceData.getCustomerServiceList().get(mIndex);
            setText(tvTitle , customerServiceListBean.getName());
            setText(tvContent , customerServiceListBean.getWorkingHours());
            Glide.with(getContext()).load(Constant.BASEURL + customerServiceListBean.getImageUrl()).into(ivCode);
        }

    }

    private ServiceData mServiceData;

    public void setData(ServiceData data){
        mServiceData = data;
        ServiceData.CustomerServiceListBean customerServiceListBean = mServiceData.getCustomerServiceList().get(mIndex);
        setText(tvTitle , customerServiceListBean.getName());
        setText(tvContent , customerServiceListBean.getWorkingHours());
        Glide.with(getContext()).load(Constant.BASEURL + customerServiceListBean.getImageUrl()).into(ivCode);

    }

    private void setText(TextView tv , String data){
        if (StringUtils.isEmpty(data)){
            data = "";
        }
        tv.setText(data);
    }

}
