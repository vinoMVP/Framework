package com.vino.framework.protocol

import rx.Observable
import rx.Observer
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * @项目名: Framework
 * @包名: com.vino.framework.protocol
 * @作者: vino
 * @创建时间: 2017/5/25 23:16
 * @描述: 网络请求的类
 */
object HttpData {

    fun <T> setSubscribe(observable: Observable<T>, observer: Observer<T>): Subscription {
        return observable.subscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }
}