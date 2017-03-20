package com.example.zhou.daggertest.ui.contract

import com.example.zhou.daggertest.ui.base.BasePresenter
import com.example.zhou.daggertest.ui.base.BaseView

/**
 * Created by zhou on 2017/3/15.
 */

interface SecondContract{
    interface View : BaseView{
        fun showTitle(title:String)
        fun start()
    }


    interface Presenter : BasePresenter{

    }
}