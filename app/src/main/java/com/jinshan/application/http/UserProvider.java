package com.jinshan.application.http;

import com.jinshan.application.Constant;
import com.jinshan.application.util.CacheHelper;
import com.minilive.library.http.callback.OnJsonCallBack;

import java.util.HashMap;
import java.util.Map;

public class UserProvider extends BaseProvider {


    public static void login(Object tag,String name , String password, OnJsonCallBack onJsonCallBack){
        Map<String, String> map = new HashMap<>();
        map.put("username",name);
        map.put("password",password);
        post(tag, Constant.BASEURL + "/user/login", map, onJsonCallBack);
    }


    public static void addUserLog(Object tag,String name , String phone, String identityCard, String id, OnJsonCallBack onJsonCallBack){
        Map<String, String> map = new HashMap<>();
        map.put("identityCard" , identityCard);
        map.put("phone", phone);
        map.put("realName",name);
        map.put("loanCrackId" , id);
        post(tag,Constant.BASEURL + "/userLog/add",map,onJsonCallBack);
    }


    public static void onVisible(Object tag,OnJsonCallBack stringCallback){
        get(tag , "https://dsn.apizza.net/mock/798e661a3ba3eccb847f18ca4a9dedd5/test",stringCallback);
    }


    public static void getUserId(Object tag, OnJsonCallBack onJsonCallBack){
        post(tag , Constant.BASEURL + "/user/queryUserByAccessToken" , onJsonCallBack);
    }

}
