package com.jinshan.application.http;

import com.jinshan.application.Constant;
import com.minilive.library.http.callback.OnJsonCallBack;

import java.util.HashMap;
import java.util.Map;

public class ProductProvider extends BaseProvider {

    public static void getList(Object tag, OnJsonCallBack onJsonCallBack){
        post(tag , Constant.BASEURL + "/loan/getRecommend" , onJsonCallBack);
    }

    public static void getProductList(Object tag,String id, int page, OnJsonCallBack onJsonCallBack){
        Map<String, String> map = new HashMap<>();
        map.put("loanSeriesId" , id);
        map.put("limit",String.valueOf(LIMIT));
        map.put("currPage",String.valueOf(page));
        post(tag , Constant.BASEURL + "/loan/loanSeriesDetails" , map, onJsonCallBack);
    }


    public static void getClassify(Object tag, OnJsonCallBack onJsonCallBack){
        post(tag , Constant.BASEURL + "/loan/classifyInterfaceSeriesList" , onJsonCallBack);
    }

    public static void getDetail(Object tag,String id, OnJsonCallBack onJsonCallBack){
        Map<String, String> map = new HashMap<>();
        map.put("id",id);
        post(tag , Constant.BASEURL + "/crack/showCrackDetails" ,map, onJsonCallBack);
    }


    public static void search(Object tag, String key, OnJsonCallBack onJsonCallBack){
        Map<String, String> map = new HashMap<>();
        map.put("keyword" , key);
        post(tag , Constant.BASEURL + "/loan/searchBothSeriesAndInterface",map, onJsonCallBack);
    }

}
