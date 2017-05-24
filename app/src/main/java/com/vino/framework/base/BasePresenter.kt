package com.vino.framework.base

import rx.Subscription
import rx.subscriptions.CompositeSubscription

/**
 * presenter的基类
 */
open class BasePresenter<T> {

    var view: T? = null

    val subscriptions = CompositeSubscription()

    fun addSubscription(subscription: Subscription) {
        subscriptions.add(subscription)
    }

    fun unSubscript() {
        if (subscriptions.hasSubscriptions()) {
            subscriptions.unsubscribe()
        }
    }

    /**
     * 关联view
     */
    fun attachView(v: T) {
        view = v
    }

    /**
     * 是否关联view
     */
    fun isAttach(): Boolean {
        return view != null
    }

}