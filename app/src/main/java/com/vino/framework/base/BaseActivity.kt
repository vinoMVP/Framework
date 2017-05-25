package com.vino.framework.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import java.lang.reflect.ParameterizedType

/**
 * 所有activity的基类
 */
abstract class BaseActivity<T, E : BasePresenter<T>> : AppCompatActivity() {

    var mPresenter: E? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 通过泛型创建presenter对象
        val arguments = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments
        // 防止数组越界
        if (arguments.size > 1) {
            @Suppress("UNCHECKED_CAST")
            val clazz = arguments[1] as Class<E>
            mPresenter = clazz.newInstance()
        }
        // 和view关联起来，前提是子类实现baseView
        // 这么做就不需要每个页面都手动去创建presenter，只要实现一个泛型就行了
        mPresenter?.attachView(this as T)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.unSubscript()
    }

}