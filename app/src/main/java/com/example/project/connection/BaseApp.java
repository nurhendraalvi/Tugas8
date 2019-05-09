package com.example.project.connection;

import android.app.Application;

import com.example.project.BuildConfig;
import com.example.project.connection.Login.LoginService;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseApp extends Application {
    public static LoginService loginService;
    public static ApiService service;
    private String BASE_URL = "https://dev.farizdotid.com";
    private String BASE_URL2 = "https://yutub-api.herokuapp.com";
    @Override
    public void onCreate() {
        super.onCreate();
        service = getRetrofit().create(ApiService.class);
        loginService = getRetrofit2().create(LoginService.class);
    }
    private Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getHttpClient())
                .build();
    }
    private Retrofit getRetrofit2() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL2)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getHttpClient())
                .build();
    }
    private OkHttpClient getHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(getHttpLogInterceptor())
                .build();
    }
    private Interceptor getHttpLogInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new
                HttpLoggingInterceptor();
        HttpLoggingInterceptor.Level level;
        if (BuildConfig.DEBUG) {
            level = HttpLoggingInterceptor.Level.BODY;
        } else {
            level = HttpLoggingInterceptor.Level.NONE;
        }
        loggingInterceptor.setLevel(level);
        return loggingInterceptor;
    }
}
