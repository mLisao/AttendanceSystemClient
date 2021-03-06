package com.lisao.lisaolibrary.http.factory;

import com.lisao.lisaolibrary.http.convert.FastJsonConvertFactory;
import com.lisao.lisaolibrary.logger.Logger;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;


/**
 * Created by yuweichen on 15/11/30.
 * 创建API工具
 */
public class ApiFactory {

    /**
     * @param clazz   API 类型
     * @param baseUrl 基础URL
     * @param <T>
     * @return
     */
    public static <T> T createRetrofitService(final Class clazz, String baseUrl) {
        OkHttpClient okClient = new OkHttpClient.Builder()
//                .connectTimeout(20, TimeUnit.SECONDS)
//                .readTimeout(20, TimeUnit.SECONDS)
//                .writeTimeout(20, TimeUnit.SECONDS)
//                .retryOnConnectionFailure(true)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();
                        Request.Builder requestBuilder;
                        requestBuilder = original.newBuilder()
                                .header("Accept-Encoding", "")
                                .method(original.method(), original.body());
                        Request request = requestBuilder.build();
                        Logger.d("url:" + request.url() + "\n" +
                                "method:" + request.method() + "\n" +
                                "header:" + request.headers().toString()
                        );
                        return chain.proceed(request);
                    }
                })
                //.addNetworkInterceptor(new GzipRequestInterceptor())
                .addNetworkInterceptor(new StethoInterceptor())
                .build();


        Retrofit client = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(FastJsonConvertFactory.create())
                .build();
        T service = (T) client.create(clazz);
        return service;
    }
}
