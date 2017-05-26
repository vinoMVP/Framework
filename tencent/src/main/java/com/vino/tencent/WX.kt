package com.vino.tencent

import android.content.Context
import android.graphics.Bitmap
import android.widget.Toast
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject
import com.tencent.mm.opensdk.modelpay.PayReq
import com.tencent.mm.opensdk.openapi.IWXAPI
import com.tencent.mm.opensdk.openapi.WXAPIFactory
import java.io.ByteArrayOutputStream

/**
 * 微信分享
 */
object WX {

    lateinit var api: IWXAPI

    fun initWXAPI(context: Context, wxKey: String) {
        api = WXAPIFactory.createWXAPI(context, wxKey)
        api.registerApp(wxKey)
    }

    /**
     * 调起分享
     *
     * @param title 标题
     * @param desc 描述
     * @param url 跳转链接
     * @param bitmap 图片的bitmap对象
     * @param type 分享的类型
     */
    fun share(title: String, desc: String, url: String, bitmap: Bitmap, type: Int) {
        api.sendReq(SendMessageToWX.Req().apply {
            transaction = desc
            scene = type
            message = WXMediaMessage(
                    WXWebpageObject().apply {
                        webpageUrl = url
                    }
            ).apply {
                this.title = title
                description = desc
                thumbData = bmpToByteArray(bitmap, true)
            }
        })
    }

    /**
     * 将bitmap转换成byte数组
     */
    private fun bmpToByteArray(bmp: Bitmap, needRecycle: Boolean): ByteArray {
        val output = ByteArrayOutputStream()
        bmp.compress(Bitmap.CompressFormat.PNG, 100, output)
        if (needRecycle) {
            bmp.recycle()
        }
        val result = output.toByteArray()
        try {
            output.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return result
    }

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

}