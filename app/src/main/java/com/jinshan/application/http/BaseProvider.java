package com.jinshan.application.http;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.jinshan.application.Constant;
import com.jinshan.application.util.CacheHelper;
import com.minilive.library.entity.http.BaseResponse;
import com.minilive.library.http.callback.OnHttpCallBack;
import com.minilive.library.network.OkHttpUtils;
import com.minilive.library.network.builder.GetBuilder;
import com.minilive.library.network.builder.OkHttpRequestBuilder;
import com.minilive.library.network.builder.PostFormBuilder;
import com.minilive.library.network.builder.PostStringBuilder;
import com.minilive.library.network.callback.StringCallback;
import com.minilive.library.util.StringUtils;
import com.minilive.library.util.Trace;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by Administrator on 2018/1/9.
 */

public class BaseProvider {

    public static final int LIMIT = 10;
    public static final int VALIDATE_ERROR = 450;

    protected BaseProvider() {
    }

    public static void get(Object tag, String url, OnHttpCallBack onHttpCallBack) {
        get(tag, url, new HashMap<String, String>(), onHttpCallBack);
    }

    protected static void get(Object tag, String url, Map<String, String> params, OnHttpCallBack
            onHttpCallBack) {
        request(tag, OkHttpUtils.get(), url, params, onHttpCallBack);
    }

    protected static void post(Object tag, String url, OnHttpCallBack onHttpCallBack) {
        post(tag, url, new HashMap<String, String>(), onHttpCallBack);
    }

    protected static void post(Object tag, String url, Map<String, String> params, OnHttpCallBack
            onHttpCallBack) {
        request(tag, OkHttpUtils.post(), url, params, onHttpCallBack);
    }


    private static void request(Object tag, OkHttpRequestBuilder requestBuilder, final String
            url, Map<String, String> params, final OnHttpCallBack onHttpCallBack) {
        if (tag != null) {
//            throw new IllegalArgumentException("http 请求传入的Tag不能为空");
//        } else {
            requestBuilder.tag(tag);
        }
        if (StringUtils.isEmpty(url)) {
            throw new IllegalArgumentException("请求路径不能为空!");
        }
        // 设置请求url
//        if (url.equals("mini/token/getToken") || url.equals("mini/slideShow/getSlideShow")) {
//            requestBuilder.url("http://192.168.0.115/" + url);
//        } else {

        requestBuilder.url(url);
        Trace.d("Http", "URL----" + requestBuilder.getUrl());
        String token = CacheHelper.getInstance().getToken();
        if (!StringUtils.isEmpty(token)){
            params.put("access_token", token);
        }
        if (params != null && params.size() > 0) {
            if (requestBuilder instanceof GetBuilder) {
                ((GetBuilder) requestBuilder).params(params);
            } else if (requestBuilder instanceof PostFormBuilder) {
                ((PostFormBuilder) requestBuilder).params(params);
            } else if (requestBuilder instanceof PostStringBuilder) {

            }
            Trace.d("Http", "params----" + params.toString());
        }

        /*if (onHttpCallBack == null) {
            throw new IllegalArgumentException("传入的Http请求的回调不能为空");
        }*/

        execute(requestBuilder, onHttpCallBack);
    }

    private static void execute(OkHttpRequestBuilder requestBuilder, final OnHttpCallBack
            onHttpCallBack) {
        requestBuilder.build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Trace.d("Http", " error -- " + call.request().url());
                if (onHttpCallBack != null)
                    onHttpCallBack.onFailed("请求超时");
            }

            @Override
            public void onResponse(String result, int id) {
                if (onHttpCallBack == null){
                    return;
                }
               BaseResponse response = onHttpCallBack.getResponseGenericity(result);
              //  if (response.getCode() == 0){

              //  }
                //onHttpCallBack.onResult(result);
                /*if (response.getCode() == 201 || response.getCode() == 202) { // TOKEN 失效

//                    }
                    return;
                }
                if (response.getCode() == 200) {
                    Object responseResult = response.getResult();
                    String res = null;
                    if (responseResult != null) {
                        res = responseResult.toString();
                    }
                    Object obj = onHttpCallBack.parseNetResponse(res);
                    onHttpCallBack.onResult(obj);

                    *//*if (response.getResult() != null) {
                        Object obj = onHttpCallBack.parseNetResponse(res);
                        onHttpCallBack.onResult(obj);

                    } else {
                        onHttpCallBack.onResult("");
                    }*//*
                } else if (response.getCode() == VALIDATE_ERROR) {
                    onHttpCallBack.onValidateError(VALIDATE_ERROR, response.getMsg());
                } else {
                    onHttpCallBack.onError(response.getMsg());
                }*/

                if (response.getCode() == 1) {
                    Object responseResult = response.getResultMap();
                    String res = null;
                    if (responseResult != null) {
                        res = responseResult.toString();
                    }
                    /*Object obj = onHttpCallBack.parseNetResponse(res);
                    onHttpCallBack.onResult(obj);*/

                    if (response.getResultMap() != null) {
                    Object obj = onHttpCallBack.parseNetResponse(res);
                    onHttpCallBack.onResult(obj);

                } else {
                    onHttpCallBack.onResult("");
                }
            } else if (response.getCode() == VALIDATE_ERROR) {
                onHttpCallBack.onValidateError(VALIDATE_ERROR, response.getMessage());
            } else {
                onHttpCallBack.onError(response.getMessage());
            }

            }
        });
    }


    public static void postFormFile(Object tag, String url, String key, String name, String path,
                                    OnHttpCallBack onHttpCallback) {
        //postFormFile(tag, url, null, key, name, path, onHttpCallback);
    }


    /**
     * 以表单形式上传
     *
     * @param tag            请求标识
     * @param url            请求url
     * @param params         参数
     * @param key            请求文件key
     * @param name           文件名称
     * @param path           文件路径
     * @param onHttpCallback
     */
   /* public static void postFormFile(Object tag, String url, Map<String, String> params, String
            key, String name, String path, OnHttpCallBack onHttpCallback) {
        PostFormBuilder formBuilder = OkHttpUtils.post().addFile(key, name, new File(path));
        request(tag, formBuilder, url, params, onHttpCallback);
    }*/


    /**
     * 取消网络请求
     *
     * @param object
     */
    public static void cancelRequestByTag(Object object) {
        OkHttpUtils.getInstance().cancelTag(object);
    }

    /**
     * post请求
     *
     * @param url
     * @param
     * @param onHttpCallBack
     */
    public static void postJson(String url, String content, StringCallback onHttpCallBack) {
        Trace.d("httpRequest","url---------" + url);
        Trace.d("httpRequest","body---------" + content);

        PostStringBuilder stringBuilder = OkHttpUtils
                .postString()
                .url(url);
        if (content != null) {
            stringBuilder.content(content)
                    .mediaType(MediaType.parse("application/json; charset=utf-8"))
                    .build()
                    .execute(onHttpCallBack);
        } else {
            stringBuilder
                    .mediaType(MediaType.parse("application/json; charset=utf-8"))
                    .build()
                    .execute(onHttpCallBack);
        }
    }


    public static void patch(String url, String content, StringCallback onHttpCallBack) {
        OkHttpUtils.patch().url(Constant.BASEURL + url).requestBody(
                RequestBody.create(MediaType.parse("application/json; charset=utf-8"), content))
                .build().execute(onHttpCallBack);
    }


    public static Application.ActivityLifecycleCallbacks lifecycleCallbacks = new Application
            .ActivityLifecycleCallbacks() {
        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

        }

        @Override
        public void onActivityStarted(Activity activity) {

        }

        @Override
        public void onActivityResumed(Activity activity) {

        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            cancelRequestByTag(activity);
        }
    };

}
