package com.example.zhou.daggertest.ui.presenter

import com.example.zhou.daggertest.ui.contract.SecondContract

/**
 * Created by zhou on 2017/3/15.
 */

class SecondPresenter : SecondContract.Presenter{
    override fun subscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unSubscribe() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    val v : SecondContract.View

    constructor(view : SecondContract.View){
        v = view
    }
}