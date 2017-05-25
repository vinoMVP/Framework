package com.vino.pay

import android.app.Activity
import android.text.TextUtils
import com.alipay.sdk.app.PayTask

/**
 * 支付宝工具类
 */
object AliPay {

    fun pay(activity: Activity, orderInfo: String, aliPayCallback: AliPayCallback) {

        val runnable = Runnable {
            val payTask = PayTask(activity)
            val resultMap = payTask.payV2(orderInfo, true)
            val resultStatus = resultMap["resultStatus"]
            if (TextUtils.equals(resultStatus, "9000")) {
                aliPayCallback.onPaySucceed()
            } else {
                aliPayCallback.onPayFailed()
            }

        }

        Thread(runnable).start()
    }

}