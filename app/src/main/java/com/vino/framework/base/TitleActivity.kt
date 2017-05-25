package com.vino.framework.base

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.vino.framework.view.layout.GenericTitleLayout

/**
 * 所有有标题的页面的基类
 */
abstract class TitleActivity<T, E : BasePresenter<T>> : BaseActivity<T, E>() {

    lateinit var titleLayout: GenericTitleLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        titleLayout = GenericTitleLayout(this)
        val layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        titleLayout.layoutParams = layoutParams
        titleLayout.orientation = LinearLayout.VERTICAL
        setContentView(titleLayout)

        titleLayout.addView(createView())

        initEvent()
    }

    private fun initEvent() {
        titleLayout.onTitleClickListener = object : GenericTitleLayout.OnTitleClickListener {
            override fun onBackClick() {
                onBackPressed()
            }

            override fun onLeftSecondTextClick() {
                this@TitleActivity.onLeftSecondTextClick()
            }

            override fun onTitleClick() {
                this@TitleActivity.onTitleClick()
            }

            override fun onRightFirstIconClick() {
                this@TitleActivity.onRightFirstIconClick()
            }

            override fun onRightSecondIconClick() {
                this@TitleActivity.onRightSecondIconClick()
            }

            override fun onRightTextClick() {
                this@TitleActivity.onRightTextClick()
            }

        }
    }

    abstract fun createView(): View

    fun onLeftSecondTextClick() {

    }

    fun onTitleClick() {

    }

    fun onRightFirstIconClick() {

    }

    fun onRightSecondIconClick() {

    }

    fun onRightTextClick() {

    }

}