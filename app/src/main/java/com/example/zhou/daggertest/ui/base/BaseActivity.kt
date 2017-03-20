package com.example.zhou.daggertest.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by zhou on 2017/3/14.
 */

abstract class BaseActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())

        start()
    }

    abstract fun getLayoutId() : Int
    abstract fun start()
}