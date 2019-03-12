package com.jinshan.application.util;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.jinshan.application.R;
import com.minilive.library.util.DensityUtil;

public class PublishDialog extends Dialog {

    private ImageView ivCode;

    private String userId;

    public PublishDialog(Context context) {
        super(context, R.style.customDialog);
        initView();
    }

    private void initView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_publish, null);
        Window dialogWindow = getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = DensityUtil.dip2px(getContext(), 341);
        dialogWindow.setAttributes(lp);
        setContentView(view);
        setCanceledOnTouchOutside(true);
        setCancelable(true);

        ivCode = view.findViewById(R.id.ivCode);

        view.findViewById(R.id.ivClose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }


    public void setData(String id,String userId){
        this.userId = userId;
        Bitmap bmp =  ZXingUtils.createQRImage("http://jianshanjt.cn/app/html/jump.html?id="+id+"&u=" + userId, 400,  400);
        ivCode.setImageBitmap(bmp);
    }

}
