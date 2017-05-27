package com.vino.framework.base

import android.app.Activity
import android.view.View
import android.view.ViewGroup

/**
 * @项目名: Framework
 * @包名: com.vino.framework.base
 * @作者: vino
 * @创建时间: 2017/5/27 21:41
 * @描述: list holder的基类
 */
abstract class BaseHolder<T>(val activity: Activity, parent: ViewGroup?) {

    val rootView = getRootView(parent)

    inline fun <reified T : View> find(id: Int): T = rootView.findViewById(id) as T

    abstract fun getRootView(parent: ViewGroup?): View

    abstract fun setData(t: T, position: Int)
}