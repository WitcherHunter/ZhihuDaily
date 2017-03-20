package com.example.zhou.daggertest.data.component.main

import com.example.zhou.daggertest.data.module.main.FirstFragmentModule
import com.example.zhou.daggertest.data.scope.FragmentScope
import com.example.zhou.daggertest.ui.fragment.LatestNewsFragment
import dagger.Subcomponent

/**
 * Created by zhou on 2017/3/17.
 */

@FragmentScope
@Subcomponent(modules = arrayOf(FirstFragmentModule::class))
interface FirstFragmentComponent{
    fun inject(fragment: LatestNewsFragment)
}