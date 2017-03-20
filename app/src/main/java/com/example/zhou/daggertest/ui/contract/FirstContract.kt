package com.example.zhou.daggertest.ui.contract

import com.example.zhou.daggertest.data.entity.Story
import com.example.zhou.daggertest.data.entity.TopStory
import com.example.zhou.daggertest.ui.base.BasePresenter
import com.example.zhou.daggertest.ui.base.BaseView

/**
 * Created by zhou on 2017/3/14.
 */

interface FirstContract {
    interface View : BaseView{
        fun showNews()
        fun showTitle(title : String)
        fun startBanner(data : ArrayList<TopStory>)
        fun showComplete()
        fun showError(t:Throwable)
    }

    interface Presenter : BasePresenter{
        fun loadNews()
        fun getHistoryNews()
    }
}