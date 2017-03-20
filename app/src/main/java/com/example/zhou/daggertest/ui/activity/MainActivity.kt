package com.example.zhou.daggertest.ui.activity

import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBarDrawerToggle
import android.util.SparseArray
import android.util.SparseBooleanArray
import android.view.MenuItem
import com.example.zhou.daggertest.R
import com.example.zhou.daggertest.ui.base.BaseActivity
import com.example.zhou.daggertest.ui.fragment.LatestNewsFragment
import com.example.zhou.daggertest.ui.fragment.SecondFragment
import com.example.zhou.daggertest.ui.presenter.FirstPresenter
import com.example.zhou.daggertest.ui.presenter.SecondPresenter
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by zhou on 2017/3/15.
 */

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {
    var currentFragmentIndex = 0

    val fragmentList = SparseArray<Fragment>()
    val fragmentStatusList = SparseBooleanArray()

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun start() {
        setSupportActionBar(toolbar)

        val actionBarToggle = ActionBarDrawerToggle(this, drawer_layout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.setStatusBarBackground(R.color.colorPrimaryDark)
        drawer_layout.addDrawerListener(actionBarToggle)
        drawer_layout.closeDrawers()

        actionBarToggle.syncState()

        if (null != nav_view)
            setUpDrawerContent(nav_view)
    }

    fun setUpDrawerContent(navigationView: NavigationView) {
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.list_navigation_menu_item -> showFragment(0)
            R.id.statistic_navigation_menu_item -> showFragment(1)
        }
        drawer_layout.closeDrawers()
        return true
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        if (hasFocus)
            showFragment(currentFragmentIndex)
    }

    fun showFragment(index: Int) {
        if (null == fragmentList.get(index))
            fragmentList.put(index, newFragmentByIndex(index))

        val transaction = supportFragmentManager.beginTransaction()
                .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)

        for (i in 0..fragmentList.size()) {
            val fragment = fragmentList[i] ?: continue
            if (i != index && fragment.isAdded) {
                transaction.hide(fragment)
            } else if (fragment.isAdded) {
                transaction.show(fragment)
            } else
                transaction.add(R.id.contentFrame, fragment)
        }
        transaction.commit()

        currentFragmentIndex = index
    }

    fun newFragmentByIndex(index: Int): Fragment = when (index) {
        0 -> LatestNewsFragment.INSTANCE
        1 -> SecondFragment.instance
        else -> LatestNewsFragment.INSTANCE
    }
}