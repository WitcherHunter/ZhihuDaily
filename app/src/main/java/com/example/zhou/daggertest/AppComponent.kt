package com.example.zhou.daggertest

import com.example.zhou.daggertest.data.component.main.FirstFragmentComponent
import com.example.zhou.daggertest.data.module.main.FirstFragmentModule
import com.example.zhou.daggertest.data.module.network.NetModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by zhou on 2017/3/16.
 */

@Singleton
@Component(modules = arrayOf(NetModule::class,AppModule::class))
interface AppComponent{
    fun plus(module : FirstFragmentModule) : FirstFragmentComponent
}