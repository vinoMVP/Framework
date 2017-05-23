package com.vino.framework.utils

import android.content.Context
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * sharePreference工具类
 */
class SPUtil<T>(val context: Context, val name: String, val default: T) : ReadWriteProperty<Any?, T> {

    val sp by lazy { context.getSharedPreferences(name, Context.MODE_PRIVATE) }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        with(sp.edit()) {
            when (value) {
                is Long -> putLong(name, value)

                is Int -> putInt(name, value)

                is String -> putString(name, value)

                is Float -> putFloat(name, value)
                is Boolean -> putBoolean(name, value)
                else -> throw IllegalArgumentException("不支持的类型")
            }
        }.apply()
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        with(sp) {
            val result: Any = when (default) {
                is Long -> getLong(name, default)
                is Int -> getInt(name, default)
                is String -> getString(name, default)
                is Float -> getFloat(name, default)
                is Boolean -> getBoolean(name, default)
                else -> throw IllegalArgumentException("不支持的类型")
            }
            return result as T
        }
    }
}