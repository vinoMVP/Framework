package com.vino.framework.utils

import android.util.Log
import com.vino.framework.BuildConfig

/**
 * 日志工具类
 */
object Logger {

    const val TAG = "vino"

    fun e(msg: String) {
        if (BuildConfig.DEBUG)
            Log.e(TAG, msg)
    }

    fun w(msg: String) {
        if (BuildConfig.DEBUG) {
            Log.w(TAG, msg)
        }
    }

    fun d(msg: String) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, msg)
        }
    }

    fun i(msg: String) {
        if (BuildConfig.DEBUG) {
            Log.i(TAG, msg)
        }
    }

}