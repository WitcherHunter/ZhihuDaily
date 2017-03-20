package com.example.zhou.daggertest.util

import de.greenrobot.event.EventBus

/**
 * Created by zhou on 2017/3/15.
 */

fun Any.registerEventBus() = EventBus.getDefault().register(this)

fun Any.unregisterEventBus() = EventBus.getDefault().unregister(this)

fun postEvent(event : Any) = EventBus.getDefault().post(event)

fun postStickyEvent(event: Any) = EventBus.getDefault().postSticky(event)