package com.vino.framework.rx

import rx.Observable
import rx.subjects.PublishSubject
import rx.subjects.SerializedSubject
import rx.subjects.Subject
import java.util.*

/**
 * @项目名: Framework
 * @包名: com.vino.framework.rx
 * @作者: vino
 * @创建时间: 2017/5/24 23:37
 * @描述: rxBus
 */
object RxBus {

    val _bus: Subject<Objects, Objects> = SerializedSubject<Objects, Objects>(PublishSubject.create())

    fun send(objects: Objects) {
        _bus.onNext(objects)
    }

    fun toObservable(): Observable<Objects> {
        return _bus
    }
}
