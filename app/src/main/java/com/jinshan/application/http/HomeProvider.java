package com.jinshan.application.http;

import com.jinshan.application.Constant;
import com.minilive.library.http.callback.OnJsonCallBack;

import java.util.HashMap;
import java.util.Map;

public class HomeProvider extends BaseProvider {

    public static void getBannerData(Object tag, String place , OnJsonCallBack onJsonCallBack){
        Map<String, String> map = new HashMap<>();
        map.put("place" , place);
        post(tag , Constant.BASEURL + "/advertise/advertisementsList", map, onJsonCallBack);
    }


    public static void getHomeLoanData(Object tag, OnJsonCallBack onJsonCallBack){
        post(tag , Constant.BASEURL + "/crack/getRecommendLoanCrackList", onJsonCallBack);
    }


    public static void getHomePostData(Object tag ,int page, OnJsonCallBack onJsonCallBack){
        Map<String, String> map = new HashMap<>();
        map.put("currPage" , String.valueOf(page));
        map.put("limit" , String.valueOf(LIMIT));
        post(tag , Constant.BASEURL + "/postApp/getRecentlyPost",map, onJsonCallBack);
    }


    public static void getBankList(Object tag, int page, OnJsonCallBack onJsonCallBack){
        Map<String, String> map = new HashMap<>();
        map.put("currPage" , String.valueOf(page));
        map.put("limit" , String.valueOf(20));
        post(tag , Constant.BASEURL + "/appFastCard/getAllFastcardPageable" , map, onJsonCallBack);
    }


    public static void getPostDetail(Object tag, String id, OnJsonCallBack onJsonCallBack){
        Map<String, String> map = new HashMap<>();
        map.put("id" , id);
        post(tag , Constant.BASEURL + "/postApp/postDetail" , map, onJsonCallBack);
    }

    public static void getServiceData(Object tag, OnJsonCallBack onJsonCallBack){
        post(tag , Constant.BASEURL + "/customerService/getAllCustomerService" , onJsonCallBack);
    }

    public static void getSelectHotData(Object tag ,  OnJsonCallBack onJsonCallBack){
        getPostListById(tag , "5" , 1 , 5 , onJsonCallBack);
    }


    public static void checkIsMake(Object tag, OnJsonCallBack onJsonCallBack){
        post(tag , "http://rest.apizza.net/mock/c41e5beb1147d9ebb6af489140453129/check" , onJsonCallBack);
    }


    public static void getPostListById(Object tag , String id ,int currentPage , int limit, OnJsonCallBack onJsonCallBack){
        Map<String, String> map = new HashMap<>();
        map.put("categoryId" , id);
        map.put("currPage", currentPage + "");
        map.put("limit" , limit + "");
        post(tag , Constant.BASEURL + "/postApp/getPostListById" , map, onJsonCallBack);
    }


    public static void getCategotyList(Object tag , OnJsonCallBack onJsonCallBack){
        post(tag , Constant.BASEURL + "/postApp/getCategorypostList" ,  onJsonCallBack);
    }

    public static void feedBack(Object tag , String tye , String content , OnJsonCallBack onJsonCallBack){
        Map<String, String> map = new HashMap<>();
        map.put("adviceType" , tye);
        map.put("content" , content);
        post(tag , Constant.BASEURL + "/advise/addAdvice" , map, onJsonCallBack);
    }




}
