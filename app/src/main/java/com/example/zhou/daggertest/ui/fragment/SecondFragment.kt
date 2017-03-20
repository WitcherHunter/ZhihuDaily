package com.example.zhou.daggertest.ui.fragment

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.zhou.daggertest.R
import com.example.zhou.daggertest.ui.contract.SecondContract
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by zhou on 2017/3/15.
 */

class SecondFragment : Fragment(), SecondContract.View {
    override fun start() {
//        presenter.start()
    }

    lateinit var mRootView : View


    override fun showTitle(title: String) {
        activity.toolbar.title = title
    }

    private object Holder{val Instance = SecondFragment()}

    companion object{
        val instance : SecondFragment by lazy { Holder.Instance }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mRootView = inflater.inflate(R.layout.fragment_second,container,false)

        start()

        return mRootView
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!hidden && activity.toolbar.title != null)
            start()
    }
}