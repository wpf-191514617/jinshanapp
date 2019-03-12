package com.jinshan.application.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;

import com.jinshan.application.R;
import com.jinshan.application.base.BaseActivity;
import com.jinshan.application.entity.PostDetailResponse;
import com.jinshan.application.http.HomeProvider;
import com.minilive.library.http.callback.OnJsonCallBack;
import com.minilive.library.util.StringUtils;
import com.minilive.library.util.Trace;
import com.minilive.library.widget.BrowserLayout;

import java.util.IllegalFormatCodePointException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebActivity extends BaseActivity {

    public static String KEY_TITLE = "webTitle";
    public static String KEY_WEB = "webUrl";
    public static String KEY_POSTDETAIL = "postDetail";

    @BindView(R.id.webLayout)
    BrowserLayout webLayout;

    private String title;
    private String url;
    private boolean isPostDetail = false;

    @Override
    protected boolean isRegisterEventBus() {
        return false;
    }

    @Override
    protected void initViewAndData() {
        ButterKnife.bind(this);
        if (!StringUtils.isEmpty(title)){
            setTitle(title);
        }

        webLayout.getWebView().getSettings().setSupportZoom(true); //将图片调整到适合webview的大小
        webLayout.getWebView().getSettings().setTextSize(WebSettings.TextSize.LARGER);// 缩放至屏幕的大小

        webLayout.getWebView().setVerticalScrollBarEnabled(false);
        webLayout.getWebView().getSettings().setPluginState(WebSettings.PluginState.ON);

        if (!StringUtils.isEmpty(url)){
            if (!isPostDetail) {
                webLayout.loadUrl(url);
            }else {
                getPostContent(url);
            }
        }

    }

    private void getPostContent(String url) {
        HomeProvider.getPostDetail(this, url, new OnJsonCallBack<PostDetailResponse>() {
            @Override
            public void onResult(PostDetailResponse data) {
                if (data != null){
                    if (data.getPost() != null){
                        if (!StringUtils.isEmpty(data.getPost().getContent())){
                            webLayout.getWebView().loadDataWithBaseURL( null, data.getPost().getContent() , "text/html", "UTF-8", null ) ;
                        }
                    }
                }
            }
        });
    }

    @Override
    protected void getBundleExtras(Bundle extras) {
        title = extras.getString(KEY_TITLE);
        url = extras.getString(KEY_WEB);
        isPostDetail = extras.getBoolean(KEY_POSTDETAIL);
    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.web;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            if (webLayout.canGoBack()){
                webLayout.goBack();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
