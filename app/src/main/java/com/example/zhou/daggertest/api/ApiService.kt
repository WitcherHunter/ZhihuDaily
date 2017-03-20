package com.example.zhou.daggertest.api

import com.example.zhou.daggertest.data.entity.response.HistoryNews
import com.example.zhou.daggertest.data.entity.response.LatestNews
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

/**
 * Created by zhou on 2017/3/17.
 */

interface ApiService{

    @GET("4/news/latest")
    fun getLatestNews() : Observable<LatestNews>

    @GET("4/news/before/{date}")
    fun getHistoryNews(@Path("date") date : Long?) : Observable<HistoryNews>
}