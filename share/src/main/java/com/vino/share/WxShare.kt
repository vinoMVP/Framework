package com.vino.share

import android.content.Context
import android.graphics.Bitmap
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject
import com.tencent.mm.opensdk.openapi.IWXAPI
import com.tencent.mm.opensdk.openapi.WXAPIFactory
import java.io.ByteArrayOutputStream

/**
 * 微信分享
 */
object WxShare {

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
}