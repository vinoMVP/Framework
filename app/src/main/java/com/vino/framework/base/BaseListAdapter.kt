package com.vino.framework.base

import android.app.Activity
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
abstract class BaseListAdapter<T>(val list: List<T>, val activity: Activity) : BaseAdapter() {

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
        var viewHolder: BaseHolder<T>
        var view: View
        if (convertView === null) {
            viewHolder = getHolder(activity, parent)
            view = viewHolder.getRootView(parent)
            view.tag = viewHolder
        } else {
            view = convertView
            @Suppress("UNCHECKED_CAST")
            viewHolder = view.tag as BaseHolder<T>
        }

        viewHolder.setData(list[position], position)

        return view
    }

    abstract fun getHolder(activity: Activity, parent: ViewGroup?): BaseHolder<T>

}