package com.vino.framework.view.layout

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.vino.framework.R
import getDimension
import org.jetbrains.anko.find

/**
 * 通用的title布局
 */
class GenericTitleLayout(context: Context?, attrs: AttributeSet?) : LinearLayout(context), View.OnClickListener {

    constructor(context: Context?) : this(context, null)

    val iv_icon_right by lazy { view?.find<ImageView>(R.id.iv_icon_right) }
    val iv_title_center by lazy { view?.find<ImageView>(R.id.iv_title_center) }
    val iv_icon_right_second by lazy { view?.find<ImageView>(R.id.iv_icon_right_second) }
    val iv_title_left by lazy { view?.find<ImageView>(R.id.iv_icon_right) }
    val tv_title_left by lazy { view?.find<TextView>(R.id.tv_title_left) }
    val tv_title_center by lazy { view?.find<TextView>(R.id.tv_title_center) }
    val tv_title_left_second by lazy { view?.find<TextView>(R.id.tv_title_left_second) }
    val tv_title_right by lazy { view?.find<TextView>(R.id.tv_title_right) }
    val tv_unread by lazy { view?.find<TextView>(R.id.tv_unread) }
    val view_title_divider by lazy { view?.find<View>(R.id.view_title_divider) }
    val rl_base_title by lazy { view?.find<RelativeLayout>(R.id.rl_base_title) }

    var titleHeight: Int? = null
    var view: View? = null

    init {
        view = View.inflate(context, R.layout.layout_generic_title, null)
        val layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, context?.getDimension(R.dimen.y144) as Int)
        addView(view, layoutParams)

        rl_base_title?.measure(0, 0)
        titleHeight = rl_base_title?.measuredHeight

        iv_title_left?.setOnClickListener(this)
        tv_title_left?.setOnClickListener(this)
        tv_title_left_second?.setOnClickListener(this)
        tv_title_center?.setOnClickListener(this)
        tv_title_right?.setOnClickListener(this)
        iv_icon_right?.setOnClickListener(this)
        iv_icon_right_second?.setOnClickListener(this)
    }

    /**
     * 设置左边的图标
     */
    fun setLeftIcon(resId: Int) {
        iv_title_left?.setImageResource(resId)
    }

    /**
     * 设置左边的文字
     */
    fun setLeftText(text: String) {
        tv_title_left?.text = text
    }

    /**
     * 设置左边的第二个文字
     */
    fun setLeftTextSecond(text: String) {
        tv_title_left_second?.text = text
    }

    /**
     * 设置标题的文字
     */
    fun setTitleCenter(text: String) {
        tv_title_center?.text = text
    }

    /**
     * 设置标题的图标
     */
    fun setTitleImg(resId: Int) {
        iv_title_center?.setImageResource(resId)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_title_back -> {
            }
            R.id.tv_title_left -> {
            }
            R.id.tv_title_left_second -> {
            }
            R.id.tv_title_right -> {
            }
            R.id.tv_title_center -> {
            }
            R.id.iv_icon_right -> {
            }
            R.id.iv_icon_right_second -> {
            }
        }
    }
}