package com.vino.framework.base

import rx.Observer

/**
 * observer的基类
 */
abstract class BaseObserver<T>(val view: BaseView?) : Observer<T> {

    override fun onCompleted() {

    }

    override fun onError(e: Throwable?) {
        e?.printStackTrace()
        view?.onConnectFailed()
    }

    override fun onNext(t: T) {
        onSuccess(t)
    }

    abstract fun onSuccess(t: T)
}