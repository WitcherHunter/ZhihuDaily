package com.example.zhou.daggertest.util

/**
 * Created by zhou on 2017/3/15.
 */

infix fun String.concat(string : String?) : String = this + string

infix fun String.concatWithSpace(string: String?) = this + "\n" + string

infix fun String.concatWithTab(string: String?) = this + "\t" + string