package com.vino.framework.mvp.presenter

import android.util.Log.e
import com.vino.framework.base.BasePresenter

class TestPresenter : BasePresenter<String>() {

    fun test() {
        e("guoxing", "isAttach:${isAttach()}")
    }
}
