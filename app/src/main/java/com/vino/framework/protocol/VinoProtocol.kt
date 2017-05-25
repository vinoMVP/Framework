package com.vino.framework.protocol

import android.content.Context
import com.vino.framework.utils.Logger
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * 网络请求框架
 */
object VinoProtocol {

    private const val DEFAULT_TIMEOUT: Long = 30

    lateinit var mContext: Context
    lateinit var mBaseUrl: String

    /**
     * 初始化
     */
    fun initProtocol(context: Context, baseUrl: String) {
        mContext = context
        mBaseUrl = baseUrl
    }

    /**
     * 获取Retrofit对象
     */
    fun getRetrofit(factory: Converter.Factory, client: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(mBaseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .addConverterFactory(factory)
                .build()
    }

    fun getRetrofit(time: Long): Retrofit {
        return getRetrofit(GsonConverterFactory.create(), genericClient(time))
    }

    fun getRetrofit(): Retrofit {
        return getRetrofit(DEFAULT_TIMEOUT)
    }

    /**
     * 创建httpclient
     */
    fun genericClient(time: Long): OkHttpClient {

        return OkHttpClient.Builder().addInterceptor(
                HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
                    message ->
                    Logger.e(message)
                }).apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }).connectTimeout(time, TimeUnit.SECONDS)
                .readTimeout(time, TimeUnit.SECONDS)
                .writeTimeout(time, TimeUnit.SECONDS)
                .build()
    }
}