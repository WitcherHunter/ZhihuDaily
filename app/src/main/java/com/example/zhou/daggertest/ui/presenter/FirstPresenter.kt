package com.example.zhou.daggertest.ui.presenter

import android.support.v7.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.zhou.daggertest.R
import com.example.zhou.daggertest.api.ApiService
import com.example.zhou.daggertest.data.entity.NewStory
import com.example.zhou.daggertest.data.entity.Story
import com.example.zhou.daggertest.data.entity.response.HistoryNews
import com.example.zhou.daggertest.data.entity.response.LatestNews
import com.example.zhou.daggertest.ui.adapter.SectionAdapter
import com.example.zhou.daggertest.ui.contract.FirstContract
import com.example.zhou.daggertest.util.convertDateWithWeek
import com.example.zhou.daggertest.util.minusDay
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription
import javax.inject.Inject

/**
 * Created by zhou on 2017/3/14.
 */

class FirstPresenter @Inject constructor(service: ApiService, view: FirstContract.View) : FirstContract.Presenter,BaseQuickAdapter.RequestLoadMoreListener {
    override fun subscribe() {
        loadNews()
    }

    override fun unSubscribe() {
        subscriptions.clear()
    }

    override fun onLoadMoreRequested() {
        getHistoryNews()
    }

    var subscriptions : CompositeSubscription = CompositeSubscription()

    val service = service
    val view = view

    var data = arrayListOf<NewStory>()
    var bannerData = arrayListOf<Story>()

    var index = 0

    var today : Long ?= 0

    val adapter : SectionAdapter by lazy { SectionAdapter(R.layout.item_latest_news,R.layout.header_news_section,data) }

    override fun loadNews() {
        var subscription = service.getLatestNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            refreshData(it)
                        },
                        {
                            view.showError(it)
                        },
                        {
                            view.showComplete()
                        })
        subscriptions.add(subscription)
    }

    override fun getHistoryNews(){
        var subscription = service.getHistoryNews(today?.minus(index ++))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            loadMoreData(it)
                        },
                        {
                            view.showError(it)
                        },
                        {
                            view.showComplete()
                        }
                )
        subscriptions.add(subscription)
    }

    fun setAdapter(view : RecyclerView) {
        adapter.setOnLoadMoreListener(this)
        view.adapter = adapter
    }

    fun refreshData(news: LatestNews){
        data.clear()
        data.add(NewStory(true,"今日热闻"))
        news.stories?.map(::NewStory)?.let { data.addAll(it) }

        index = 0
        today = news.date

        news.top_stories?.let { view.startBanner(it) }

        adapter.notifyDataSetChanged()
        view.showNews()
    }

    fun loadMoreData(news : HistoryNews){
        data.add(NewStory(true, convertDateWithWeek(minusDay(index))))
        news.stories?.map(::NewStory)?.let { data.addAll(it) }

        adapter.notifyDataSetChanged()
        view.showNews()
        adapter.loadMoreComplete()
    }
}