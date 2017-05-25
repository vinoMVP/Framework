package com.vino.framework

import android.view.View
import com.vino.framework.base.TitleActivity
import com.vino.framework.mvp.presenter.TestPresenter

class MainActivity : TitleActivity<String, TestPresenter>() {

    override fun createView(): View {
        return View.inflate(this, R.layout.activity_main, null)
    }

}
