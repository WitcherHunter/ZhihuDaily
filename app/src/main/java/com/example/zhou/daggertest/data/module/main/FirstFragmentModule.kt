package com.example.zhou.daggertest.data.module.main

import com.example.zhou.daggertest.api.ApiService
import com.example.zhou.daggertest.data.scope.FragmentScope
import com.example.zhou.daggertest.ui.contract.FirstContract
import com.example.zhou.daggertest.ui.fragment.LatestNewsFragment
import com.example.zhou.daggertest.ui.presenter.FirstPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by zhou on 2017/3/17.
 */

@Module
class FirstFragmentModule(fragment : LatestNewsFragment){
    val view = fragment

    @Provides @FragmentScope
    fun provideFirstFragmentView() : FirstContract.View = view

//    @Provides @FragmentScope
//    fun provideFirstPresenter(api : ApiService, view: FirstContract.View) : FirstContract.Presenter =
//            FirstPresenter(api,view)
}