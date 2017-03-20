package com.example.zhou.daggertest.ui.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.zhou.daggertest.App
import com.example.zhou.daggertest.AppComponent

/**
 * Created by zhou on 2017/3/17.
 */

abstract class BaseFragment : Fragment(){
    protected abstract val layoutResource : Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val rootView = inflater.inflate(layoutResource,container,false)
        injectDependencies(App.graph)
        return rootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        start()
    }

    abstract fun injectDependencies(appComponent: AppComponent)

    abstract fun start()
}