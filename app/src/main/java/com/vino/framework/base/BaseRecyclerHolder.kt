package com.vino.framework.base

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.View
import com.vino.framework.listener.OnItemClickListener

/**
 * @项目名: Framework
 * @包名: com.vino.framework.base
 * @作者: vino
 * @创建时间: 2017/5/27 22:05
 * @描述: recyclerView，holder的基类
 */
abstract class BaseRecyclerHolder<T>(itemView: View, val activity: Activity,val onItemClickListener: OnItemClickListener?) : RecyclerView.ViewHolder(itemView) {

    inline fun <reified T : View> find(id: Int): T = itemView.findViewById(id) as T

    abstract fun setData(t: T, position: Int)
}