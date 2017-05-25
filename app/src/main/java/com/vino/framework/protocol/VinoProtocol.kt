package com.vino.framework.protocol

import android.content.Context
import com.vino.framework.utils.Logger
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory

/**
 * 网络请求框架
 */
object VinoProtocol {

    lateinit var mContext: Context
    lateinit var mBaseUrl: String

    fun initProtocol(context: Context, baseUrl: String) {
        mContext = context
        mBaseUrl = baseUrl
    }

    fun getRetrofit(factory: Converter.Factory, client: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(mBaseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .addConverterFactory(factory)
                .build()
    }

//    fun genericClient(time: Long): OkHttpClient {
//        val logger = HttpLoggingInterceptor.Logger {
//            message ->
//            Logger.e(message)
//        }
//
//    }
}