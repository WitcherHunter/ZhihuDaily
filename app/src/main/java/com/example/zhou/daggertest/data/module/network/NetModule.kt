package com.example.zhou.daggertest.data.module.network

import android.app.Application
import com.example.zhou.daggertest.App
import com.example.zhou.daggertest.api.ApiService
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by zhou on 2017/3/16.
 */

@Module
class NetModule{
    val cacheSize: Long = 10 * 1024 * 1024

    @Provides @Singleton
    fun provideCache(app: App): Cache = Cache(app.cacheDir, cacheSize)

    @Provides @Singleton
    fun provideOkhttpClient(cache: Cache): OkHttpClient
            = OkHttpClient.Builder().cache(cache).build()

    @Provides @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit
            = Retrofit.Builder()
            .baseUrl("http://news-at.zhihu.com/api/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build()

    @Provides @Singleton
    fun provideApiService(retrofit: Retrofit) : ApiService
            = retrofit.create(ApiService::class.java)
}