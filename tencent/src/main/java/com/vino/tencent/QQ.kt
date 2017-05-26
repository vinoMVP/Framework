package com.vino.tencent

import android.app.Activity
import android.content.Context
import android.os.Bundle
import com.tencent.connect.share.QQShare
import com.tencent.connect.share.QzoneShare
import com.tencent.tauth.IUiListener
import com.tencent.tauth.Tencent

/**
 * QQ分享的库
 */
object QQ {

    lateinit var api: Tencent

    fun initQQAPI(context: Context, qqKey: String) {
        api = Tencent.createInstance(qqKey, context)
    }

    /**
     * 分享给好友
     *
     * @param activity  上下文对象
     * @param title     分享的标题
     * @param desc      分享内容的描述
     * @param icon      分享的缩略图
     * @param url       对应的url链接
     */
    fun shareToQFriend(activity: Activity, title: String, desc: String, icon: String, url: String, listener: IUiListener) {
        val bundle = Bundle()
        bundle.putString(QQShare.SHARE_TO_QQ_TITLE, title)
        bundle.putString(QQShare.SHARE_TO_QQ_TARGET_URL, url)
        bundle.putString(QQShare.SHARE_TO_QQ_IMAGE_URL, icon)
        bundle.putString(QQShare.SHARE_TO_QQ_SUMMARY, desc)
        bundle.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_DEFAULT)
        bundle.putInt(QQShare.SHARE_TO_QQ_EXT_INT, 0x00)
        api.shareToQQ(activity, bundle, listener)
    }

    /**
     * 分享到空间
     *
     * @param activity  上下文对象
     * @param title     分享的标题
     * @param desc      分享内容的描述
     * @param icon      分享的缩略图
     * @param url       对应的url链接
     */
    fun shareToQZone(activity: Activity, title: String, desc: String, icon: String, url: String, listener: IUiListener) {
        val bundle = Bundle()
        bundle.putInt(QzoneShare.SHARE_TO_QZONE_KEY_TYPE, QzoneShare.SHARE_TO_QZONE_TYPE_IMAGE_TEXT)
        bundle.putString(QzoneShare.SHARE_TO_QQ_TITLE, title)
        bundle.putString(QzoneShare.SHARE_TO_QQ_SUMMARY, desc)

        bundle.putStringArrayList(QzoneShare.SHARE_TO_QQ_IMAGE_URL, arrayListOf(icon))
        bundle.putString(QzoneShare.SHARE_TO_QQ_TARGET_URL, url)
        api.shareToQzone(activity, bundle, listener)
    }
}