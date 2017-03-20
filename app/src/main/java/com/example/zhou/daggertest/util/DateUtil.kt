package com.example.zhou.daggertest.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by zhou on 2017/3/18.
 */

fun convertDateWithWeek(date: Long): String =
        SimpleDateFormat("MM月dd日").format(Date(date)) concat " " concat getDayOfWeek(date)

fun getDayOfWeek(date: Long): String {
    val calendar = Calendar.getInstance()
    calendar.time = Date(date)
    when (calendar.get(Calendar.DAY_OF_WEEK)) {
        1 -> return "星期日"
        2 -> return "星期一"
        3 -> return "星期二"
        4 -> return "星期三"
        5 -> return "星期四"
        6 -> return "星期五"
        7 -> return "星期六"
        else -> return ""
    }
}

fun minusDay(index : Int) : Long = System.currentTimeMillis() - 1000 * 60 * 60 * 24 * index

fun convertDate(date: Long) = SimpleDateFormat("yyMMdd").format(date)