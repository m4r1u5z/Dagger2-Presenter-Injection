package com.example.mariusz.dagger2.dagger.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mariusz on 18.05.16
 */

@Module
public class ApiConfigurationModule {
    @Provides
    @Singleton
    String provideBaseUrl() {
        return "https://api.github.com/";
    }

    @Provides
    @Singleton
    Converter.Factory provideConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    CallAdapter.Factory provideCallAdapterFactory() {
        return RxJavaCallAdapterFactory.create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.addInterceptor(logging);
        return httpClientBuilder.build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(String url, Converter.Factory converter,
                             CallAdapter.Factory callAdapter, OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(converter)
                .addCallAdapterFactory(callAdapter)
                .client(client)
                .build();
    }
}