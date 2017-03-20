package com.example.zhou.daggertest

import android.app.Application

/**
 * Created by zhou on 2017/3/10.
 */

class App : Application(){
    val baseUrl = "http://news-at.zhihu.com/api/"

    companion object{
        lateinit var graph : AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        graph = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
}