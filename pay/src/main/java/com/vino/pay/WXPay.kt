package com.vino.pay

import android.content.Context
import android.widget.Toast
import com.tencent.mm.opensdk.modelpay.PayReq
import com.tencent.mm.opensdk.openapi.IWXAPI
import com.tencent.mm.opensdk.openapi.WXAPIFactory

/**
 * 微信支付的工具类
 */
object WXPay {

    lateinit var api: IWXAPI

    /**
     * 调起微信支付
     *
     * @param context           上下文
     * @param appKey            微信key
     * @param prepayId          预支付交易会话ID
     * @param partnerId         商户号
     * @param nonceStr          随机字符串
     * @param timeStamp         时间戳
     * @param sign              签名
     */
    fun sendPayRequest(context: Context, appKey: String, partnerId: String, prepayId: String,
                       nonceStr: String, timeStamp: String, sign: String) {
        if (api.isWXAppInstalled) {
            val payReq = PayReq()
            payReq.appId = appKey
            payReq.partnerId = partnerId
            payReq.prepayId = prepayId
            payReq.nonceStr = nonceStr
            payReq.timeStamp = timeStamp
            payReq.sign = sign
            api.sendReq(payReq)
        } else {
            Toast.makeText(context, "微信客户端未安装或微信客户端是非官方版本", Toast.LENGTH_LONG).show()
        }
    }

    /**
     * 初始化微信api
     * @param context           上下文
     * @param appKey            微信key
     */
    fun initWXAPI(context: Context, appKey: String) {
        api = WXAPIFactory.createWXAPI(context, appKey)
        api.registerApp(appKey)
    }
}