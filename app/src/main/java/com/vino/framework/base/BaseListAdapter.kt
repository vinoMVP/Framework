package com.vino.framework.base

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

/**
 * @项目名: Framework
 * @包名: com.vino.framework.base
 * @作者: vino
 * @创建时间: 2017/5/24 20:43
 * @描述: listView adapter的基类
 */
abstract class BaseListAdapter<T>(val list: List<T>) : BaseAdapter() {

    lateinit var rootView: View

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): T {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var viewHolder: ViewHolder
        var view: View
        if (convertView === null) {
            viewHolder = ViewHolder()
            view = viewHolder.getRootView(parent)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as BaseListAdapter<T>.ViewHolder
        }

        viewHolder.setData(list[position], position)

        return view
    }

    inner class ViewHolder {

        fun getRootView(parent: ViewGroup?): View {
            rootView = this@BaseListAdapter.getRootView(parent)
            return rootView
        }

        fun setData(t: T, position: Int) {
            this@BaseListAdapter.setData(t, position)
        }
    }

    abstract fun getRootView(parent: ViewGroup?): View

    abstract fun setData(t: T, position: Int)

    inline fun <reified T : View> find(id: Int): T = rootView.findViewById(id) as T
}