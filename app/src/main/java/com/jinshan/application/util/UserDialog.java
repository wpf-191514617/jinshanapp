package com.jinshan.application.util;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.jinshan.application.R;
import com.minilive.library.util.DensityUtil;
import com.minilive.library.util.StringUtils;

public class UserDialog extends Dialog {

    private EditText etName, etPhone, etID;

    public UserDialog(Context context) {
        super(context, R.style.customDialog);
        initView();
    }

    private void initView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_dialog, null);
        Window dialogWindow = getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = DensityUtil.dip2px(getContext(), 257);
        dialogWindow.setAttributes(lp);
        setContentView(view);
        setCanceledOnTouchOutside(true);
        setCancelable(true);

        etName = view.findViewById(R.id.etName);
        etPhone = view.findViewById(R.id.etPhone);
        etID = view.findViewById(R.id.etID);

        view.findViewById(R.id.ivClose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        view.findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveInfo();
            }
        });
    }

    private void saveInfo() {
        String name = etName.getText().toString();
        String phone = etPhone.getText().toString();
        String id = etID.getText().toString();

        if (!StringUtils.isEmpty(name) &&
                !StringUtils.isEmpty(phone) &&
                !StringUtils.isEmpty(id)) {
            CacheHelper.getInstance()
                    .put("userName", name)
                    .put("userPhone", name)
                    .put("userID", id);
            Toast.makeText(getContext(), "保存用户信息成功", Toast.LENGTH_SHORT).show();
            dismiss();
        } else {
            Toast.makeText(getContext(), "请将信息填写完整", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void show() {
        super.show();
        String name = CacheHelper.getInstance().get("userName");
        String phone = CacheHelper.getInstance().get("userPhone");
        String id = CacheHelper.getInstance().get("userID");

        if (!StringUtils.isEmpty(name) &&
                !StringUtils.isEmpty(phone) &&
                !StringUtils.isEmpty(id)) {
            etName.setText(name);
            etName.setSelection(name.length());
            etPhone.setText(phone);
            etPhone.setSelection(phone.length());
            etID.setText(id);
            etID.setSelection(etID.length());
        }
    }
}
