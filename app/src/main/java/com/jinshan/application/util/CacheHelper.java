package com.jinshan.application.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jinshan.application.Constant;
import com.jinshan.application.MyApplication;
import com.minilive.library.util.ACache;
import com.minilive.library.util.StringUtils;

import java.util.List;

/**
 * Created by john on 2018/9/29.
 */

public class CacheHelper {

    private static CacheHelper mInstance = null;

    private final String KEY_TOKEN = "USER.TOKEN";
    private final String KEY_DIC = "app.DIC";

    private ACache mACache;

    private CacheHelper() {
        mACache = ACache.get(MyApplication.getContext(), Constant.CACHE_NAME);
    }

    public static CacheHelper getInstance() {
        if (mInstance == null) {
            synchronized (CacheHelper.class) {
                if (mInstance == null) {
                    mInstance = new CacheHelper();
                }
            }
        }
        return mInstance;
    }


    public void putToken(String token){
        mACache.put(KEY_TOKEN , token);
    }


    public String getToken(){
        return mACache.getAsString(KEY_TOKEN);
    }

    public CacheHelper put(String key, String value){
        mACache.put(key, value);
        return this;
    }

    public void clear(){
        mACache.clear();
    }

    public String get(String key){
        return mACache.getAsString(key);
    }

}
