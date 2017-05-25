package com.vino.pay

import android.content.Context
import android.support.v7.app.AlertDialog
import com.unionpay.UPPayAssistEx

/**
 * 银联支付的工具类
 */
object UnionPay {

    const val PLUGIN_VALID = 0
    const val PLUGIN_NOT_INSTALLED = -1// 没有安装
    const val PLUGIN_NEED_UPGRADE = 2// 需要更新

    /**
     * 开启银联支付
     * @param context   上下文
     * @param tn        交易流水号
     * @param debug     是否是测试，true是测试 false不是测试
     */
    fun startPay(context: Context, tn: String, debug: Boolean) {
        val result = UPPayAssistEx.startPay(context, null, null, tn, if (debug) "01" else "00")
        if (result == PLUGIN_NEED_UPGRADE || result == PLUGIN_NOT_INSTALLED) {
            val builder = AlertDialog.Builder(context)
            builder.setTitle("温馨提示")
            builder.setMessage("完成购买需要安装银联支付控件，是否安装？")
            builder.setNegativeButton("确定", {
                dialog, which ->
                UPPayAssistEx.installUPPayPlugin(context)
                dialog.dismiss()
            })
            builder.setPositiveButton("取消", {
                dialog, which ->
                dialog.dismiss()
            })
            builder.create().show()
        }
    }
}