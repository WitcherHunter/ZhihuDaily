package com.example.zhou.daggertest.util

import android.app.Activity
import android.support.v4.app.Fragment
import android.util.Log

/**
 * Created by zhou on 2017/3/15.
 */

fun <T : Activity> T.e(msg: String) = Log.e(this.javaClass.name,msg)

fun <T : Activity> T.d(msg: String) = Log.d(this.javaClass.name,msg)

fun <T : Activity> T.i(msg: String) = Log.i(this.javaClass.name,msg)

fun <T : Activity> T.w(msg: String) = Log.w(this.javaClass.name,msg)

fun <T : Activity> T.v(msg: String) = Log.v(this.javaClass.name,msg)

fun <T : Activity> T.wtf(msg: String) = Log.wtf(this.javaClass.name,msg)


fun <T : Fragment> T.e(msg: String) = Log.e(this.javaClass.name,msg)

fun <T : Fragment> T.d(msg: String) = Log.d(this.javaClass.name,msg)

fun <T : Fragment> T.i(msg: String) = Log.i(this.javaClass.name,msg)

fun <T : Fragment> T.w(msg: String) = Log.w(this.javaClass.name,msg)

fun <T : Fragment> T.v(msg: String) = Log.v(this.javaClass.name,msg)

fun <T : Fragment> T.wtf(msg: String) = Log.wtf(this.javaClass.name,msg)


