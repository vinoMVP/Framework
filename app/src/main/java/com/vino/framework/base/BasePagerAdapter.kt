package com.vino.framework.base

import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup

/**
 * @项目名: Framework
 * @包名: com.vino.framework.base
 * @作者: vino
 * @创建时间: 2017/5/24 23:29
 * @描述: pagerAdapter的基类
 */
class BasePagerAdapter<out T>(val list: List<T>) : PagerAdapter() {

    override fun isViewFromObject(view: View?, `object`: Any?): Boolean {
        return view === `object`
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getItemPosition(`object`: Any?): Int {
        return POSITION_NONE
    }


    override fun destroyItem(container: ViewGroup?, position: Int, `object`: Any?) {
        container?.removeView(`object` as View)
    }
}