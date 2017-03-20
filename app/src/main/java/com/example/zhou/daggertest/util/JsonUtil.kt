package com.example.zhou.daggertest.util

import com.google.gson.Gson

/**
 * Created by zhou on 2017/3/15.
 */

inline fun <reified T> T.fromJson(json:String) : T?{
    try {
        return Gson().fromJson(json,T::class.java)
    }catch (ex : Exception){
        return null
    }
}