package com.vino.framework.base

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
abstract class BaseRecyclerAdapter<T>(val list: List<T>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var onItemClickListener: OnItemClickListener? = null

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        (holder as BaseRecyclerAdapter<T>.BaseHolder).setData(list[position], position)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return BaseHolder(getRootView(parent, onItemClickListener))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    abstract fun getRootView(parent: ViewGroup?, onItemClickListener: OnItemClickListener?): View

    abstract fun setData(t: T, position: Int)

    inner class BaseHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        fun getRootView(parent: ViewGroup?, onItemClickListener: OnItemClickListener?): View {
            return this@BaseRecyclerAdapter.getRootView(parent, onItemClickListener)
        }

        fun setData(t: T, position: Int) {
            this@BaseRecyclerAdapter.setData(t, position)
        }
    }

}