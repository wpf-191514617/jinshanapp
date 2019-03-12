package com.jinshan.application.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jinshan.application.R;
import com.jinshan.application.base.BaseActivity;
import com.jinshan.application.http.HomeProvider;
import com.minilive.library.http.callback.OnJsonCallBack;
import com.minilive.library.util.StringUtils;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FeedBackActivity extends BaseActivity {
    @BindView(R.id.flowlayout)
    TagFlowLayout flowlayout;
    @BindView(R.id.etContent)
    EditText etContent;
    @BindView(R.id.btnCommit)
    Button btnCommit;

    private String type ;

    @Override
    protected boolean isRegisterEventBus() {
        return false;
    }

    @Override
    protected void initViewAndData() {
        setTitle("意见反馈");
        ButterKnife.bind(this);
        final List<String> sets = new ArrayList<>();
        sets.add("课程建议");
        sets.add("使用问题");
        sets.add("需求反馈");
        sets.add("其他问题");
        flowlayout.setAdapter(new TagAdapter<String>(sets){
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView textView =  (TextView) LayoutInflater.from(FeedBackActivity.this).inflate(R.layout.item_tag,
                        flowlayout, false);
                setText(textView , s);
                return textView;
            }
        });
        flowlayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                type = sets.get(position);
                return false;
            }
        });
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_feedback;
    }

    @OnClick(R.id.btnCommit)
    public void onViewClicked() {
        if (StringUtils.isEmpty(type)){
            showToast("请选择反馈类型");
            return;
        }

        String content = etContent.getText().toString();
        if (StringUtils.isEmpty(content)){
            showToast("请输入内容");
            return;
        }

        HomeProvider.feedBack(this, type, content, new OnJsonCallBack() {
            @Override
            public void onResult(Object data) {
                showToast("提交成功");
                return;
            }

            @Override
            public void onError(String msg) {
                super.onError(msg);
                showToast(msg);
            }
        });
    }
}
