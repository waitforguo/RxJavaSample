package com.xh.rxjavademo;

import com.xh.rxjavademo.bean.ExtendConfigResponseBean;
import com.xh.rxjavademo.bean.ResponseBean2;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @author FuZhiXue(Fran)
 * @date 2021/1/28 3:14 PM
 */
public interface GetRequest_Interface {

    @GET("/api/v1/pub/app/extend")
    Observable<ExtendConfigResponseBean> getCall();
    // 注解里传入 网络请求 的部分URL地址
    // Retrofit把网络请求的URL分成了两部分：一部分放在Retrofit对象里，另一部分放在网络请求接口里
    // 如果接口里的url是一个完整的网址，那么放在Retrofit对象里的URL可以忽略
    // 采用Observable<...>接口
    // getCall()是接受网络请求数据的方法

    // 另外的请求
    @GET("/api/v1/pub/app/extend")
    Observable<ResponseBean2> getCall2();
} 
