package com.vino.framework.listener

import android.view.View

/**
 * @项目名: Framework
 * @包名: com.vino.framework.listener
 * @作者: vino
 * @创建时间: 2017/5/24 21:39
 * @描述:
 */
interface OnItemClickListener {
    /**
     * item点击的时候的回调
     */
    fun onItemClick(view: View, position: Int)
}