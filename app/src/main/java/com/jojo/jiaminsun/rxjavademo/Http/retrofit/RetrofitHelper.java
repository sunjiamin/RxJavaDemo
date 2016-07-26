package com.jojo.jiaminsun.rxjavademo.Http.retrofit;

/**
 * 项目名称：HeartPro
 * 类描述：
 * 创建人：Jiamin.Sun
 * 创建时间：6/8/2016 2:58 PM
 */
public class RetrofitHelper {

    public static ApiService getApiService106(){
       return RetrofitClient.getInstance106().create(ApiService.class);
    }

    public static ApiService getApiService17(){
        return RetrofitClient.getInstance17().create(ApiService.class);
    }

    public static ApiService getApiService222(){
        return RetrofitClient.getInstance222().create(ApiService.class);
    }





}
