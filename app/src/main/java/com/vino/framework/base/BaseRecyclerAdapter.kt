package com.vino.framework.base

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vino.framework.listener.OnItemClickListener
import java.lang.reflect.ParameterizedType

/**
 * @项目名: Framework
 * @包名: com.vino.framework.base
 * @作者: vino
 * @创建时间: 2017/5/24 21:24
 * @描述: recyclerView 的baseAdapter
 */
abstract class BaseRecyclerAdapter<T, out E : BaseRecyclerHolder<T>>(val list: List<T>, val activity: Activity)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var onItemClickListener: OnItemClickListener? = null

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        @Suppress("UNCHECKED_CAST")
        (holder as BaseRecyclerHolder<T>).setData(list[position], position)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): E {
        // 通过泛型创建presenter对象
        val arguments = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments
        val clazz = arguments[1] as Class<E>
        val cons = clazz.getConstructor(javaClass, View::class.java, Activity::class.java, OnItemClickListener::class.java)
        return cons.newInstance(this,getRootView(parent), activity, onItemClickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun getRootView(parent: ViewGroup?): View {
        return LayoutInflater.from(activity).inflate(getLayoutId(), parent, false)
    }

    /**
     * 获取布局id
     */
    abstract fun getLayoutId(): Int

}