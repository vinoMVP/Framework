package com.vino.framework.base

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.vino.framework.listener.OnItemClickListener

/**
 * @项目名: Framework
 * @包名: com.vino.framework.base
 * @作者: vino
 * @创建时间: 2017/5/24 21:24
 * @描述: recyclerView 的baseAdapter
 */
abstract class BaseRecyclerAdapter<T>(val list: List<T>, val activity: Activity) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var onItemClickListener: OnItemClickListener? = null

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        @Suppress("UNCHECKED_CAST")
        (holder as BaseRecyclerHolder<T>).setData(list[position], position)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseRecyclerHolder<T> {
        return getHolder(getRootView(parent), activity, onItemClickListener)
    }

    abstract fun getHolder(rootView: View, activity: Activity, onItemClickListener: OnItemClickListener?): BaseRecyclerHolder<T>

    override fun getItemCount(): Int {
        return list.size
    }

    abstract fun getRootView(parent: ViewGroup?): View

}