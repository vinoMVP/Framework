package com.vino.framework.base

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import java.lang.reflect.ParameterizedType

/**
 * @项目名: Framework
 * @包名: com.vino.framework.base
 * @作者: vino
 * @创建时间: 2017/5/24 20:43
 * @描述: listView adapter的基类
 */
abstract class BaseListAdapter<T, out E : BaseHolder<T>>(val list: List<T>, val activity: Activity) : BaseAdapter() {

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
        val viewHolder: E
        val view: View
        if (convertView === null) {
            // 通过泛型创建presenter对象
            val arguments = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments
            val clazz = arguments[1] as Class<E>
            val cons = clazz.getConstructor(javaClass, Activity::class.java, ViewGroup::class.java)
            viewHolder = cons.newInstance(activity, parent)
            view = viewHolder.getRootView(parent)
            view.tag = viewHolder
        } else {
            view = convertView
            @Suppress("UNCHECKED_CAST")
            viewHolder = view.tag as E
        }

        viewHolder.setData(list[position], position)

        return view
    }

}