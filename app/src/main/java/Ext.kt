/**
 *项目的扩展方法
 */

import android.app.Activity
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.CLIPBOARD_SERVICE
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.TypedValue
import com.vino.framework.R
import java.io.File

/**
 * 通过id获取dimens
 */
fun Context.getDimension(id: Int): Int {
    return resources.getDimensionPixelSize(id)
}

/**
 * 获取字符串数组
 */
fun Context.getStringArray(id: Int): Array<String> {
    return resources.getStringArray(id)
}

/**
 * 通过id获取颜色
 */
fun Context.getColorById(id: Int): Int {
    return resources.getColor(id)
}

/**
 * 通过id获取字符串
 */
fun Context.getStringById(id: Int): String {
    return resources.getString(id)
}

/**
 * 通过id获取drawable
 */
fun Context.getDrawableById(id: Int): Drawable {
    return resources.getDrawable(id)
}

/**
 * dp转换成px
 */
fun Context.dp2px(dp: Float): Float {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics)
}

/**
 * px转换成dp
 */
fun Context.px2dp(px: Float): Float {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, px, resources.displayMetrics)
}

/**
 * 获取版本号
 */
fun Context.getVersionCode(): Int {
    return packageManager.getPackageInfo(packageName, 0).versionCode
}

/**
 * 获取版本名称
 */
fun Context.getVersionName(): String {
    return packageManager.getPackageInfo(packageName, 0).versionName
}

/**
 * 复制文字
 */
fun Context.copyText(text: String) {
    val clipboardManager = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
    clipboardManager.text = text
}

/**
 * 获取toolbar的高度
 */
fun Context.getToolbarHeight(): Float {
    val typedArray = theme.obtainStyledAttributes(intArrayOf(R.attr.actionBarSize))
    val height = typedArray.getDimension(0, 0f)
    typedArray.recycle()
    return height
}

/**
 * 安装activity的方法
 */
fun Context.installApk(path: String) {
    val intent = Intent(Intent.ACTION_VIEW)
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
    intent.setDataAndType(Uri.fromFile(File(path)), "application/vnd.android.package-archive")
    startActivity(intent)
}

/**
 * 屏幕宽度
 */
fun Context.getDisplayWidth(): Int {
    return resources.displayMetrics.widthPixels
}

/**
 * 获取屏幕高度
 */
fun Context.getDisplayHeight(): Int {
    return resources.displayMetrics.heightPixels
}

/**
 * 重启app
 */
fun Context.restartApp(clazz: Class<Activity>) {
    val mFirstActivity = Intent(this, clazz)
    val activity = PendingIntent.getActivity(this, 123456, mFirstActivity, PendingIntent.FLAG_CANCEL_CURRENT)
    val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
    alarmManager.set(AlarmManager.RTC, System.currentTimeMillis() + 100, activity)
    System.exit(0)
}