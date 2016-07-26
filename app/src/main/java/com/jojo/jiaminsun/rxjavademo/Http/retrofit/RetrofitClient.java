package com.jojo.jiaminsun.rxjavademo.Http.retrofit;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 项目名称：HeartPro
 * 类描述：
 * 创建人：Jiamin.Sun
 * 创建时间：6/6/2016 1:45 PM
 */
public class RetrofitClient {

    //接口可能在多个服务器上 ,需要多个实例
    private static class LazyHolder17 {
        private static final RetrofitClient instance = new RetrofitClient("");//HeartProConfig.HOST_NAME_17
    }

    private static class LazyHolder106 {
        private static final RetrofitClient instance = new RetrofitClient("");//HeartProConfig.HOST_NAME_106
    }

    private static class LazyHolder222 {
        private static final RetrofitClient instance = new RetrofitClient("");//HeartProConfig.HOST_NAME_222
    }




    public static RetrofitClient getInstance17() {
        return LazyHolder17.instance;
    }
    public static RetrofitClient getInstance106() {
        return LazyHolder106.instance;
    }
    public static RetrofitClient getInstance222() {
        return LazyHolder222.instance;
    }

    private Retrofit retrofit;

    private RetrofitClient(String baseUrl) {
        createRetrofit(baseUrl);
    }

    private void createRetrofit(String baseUrl) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                //.addInterceptor(interceptor)
                .addInterceptor(new Interceptor() {
                     @Override
                     public Response intercept(Chain chain) throws IOException {
                         Request request = chain.request();
                         Response response = chain.proceed(request);
                         return response;
                     }
                 })
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public <T> T create(Class<?> clazz) {
        return (T) retrofit.create(clazz);
    }

}
