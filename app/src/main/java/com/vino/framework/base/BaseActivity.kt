package com.vino.framework.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * 所有activity的基类
 */
abstract class BaseActivity<T, E : BasePresenter<T>> : AppCompatActivity() {

    var mPresenter: E? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = createPresenter()
        mPresenter?.attachView(this as T)
    }

    abstract fun createPresenter(): E
}