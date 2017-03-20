package com.example.zhou.daggertest.util

import android.app.Activity
import android.content.DialogInterface
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog

/**
 * Created by zhou on 2017/3/15.
 */

fun Activity.getColor(resId : Int) = ContextCompat.getColor(this,resId)

fun Activity.showActionDialog(title:String?,msg:String?,listener:DialogInterface.OnClickListener){
    AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(msg)
            .setPositiveButton("确定",listener)
            .setNegativeButton("取消",null)
            .setCancelable(true)
            .create()
            .show()
}