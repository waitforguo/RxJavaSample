package com.xh.rxjavademo.bean;

import android.util.Log;

import com.google.gson.Gson;

/**
 * @author FuZhiXue(Fran)
 * @date 2021/1/28 3:57 PM
 */
public class ResponseBean2 {
    private String tingAppKey;
    private String tingSecretKey;

    public String show() {
        String json = new Gson().toJson(this);
        Log.d("RxJava", "[ResponseBean2] " + json);
        return json;
    }
} 
