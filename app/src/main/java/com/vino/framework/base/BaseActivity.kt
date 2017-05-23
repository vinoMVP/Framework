package com.vino.framework.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * 所有activity的基类
 */
abstract class BaseActivity : AppCompatActivity() {

    abstract fun setView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setView()

    }
}