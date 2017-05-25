package com.vino.pay

/**
 * 支付宝回调接口
 */
interface AliPayCallback {

    /**
     * 支付成功的回调
     */
    fun onPaySucceed()

    /**
     * 支付失败的回调
     */
    fun onPayFailed()
}