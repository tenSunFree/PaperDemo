package com.example.paperdemo.common.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.text.format.DateUtils
import android.util.Base64
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.navArgument
import java.io.ByteArrayOutputStream
import java.util.*

fun Long.timeAgo() = DateUtils.getRelativeTimeSpanString(
    this,
    Calendar.getInstance().timeInMillis,
    DateUtils.DAY_IN_MILLIS
).toString()

fun Long.timeAgoInSeconds() = DateUtils.getRelativeTimeSpanString(
    this,
    Calendar.getInstance().timeInMillis,
    DateUtils.SECOND_IN_MILLIS
).toString()

fun String.gridTrim(maxDigits: Int = 100) =
    if (this.length > maxDigits) "${this.substring(0, maxDigits)}..." else this


fun Bitmap.getEncodedString(): String? = Base64.encodeToString(ByteArrayOutputStream().apply {
    val w = 360
    val h = this@getEncodedString.height * w / this@getEncodedString.width
    Bitmap.createScaledBitmap(this@getEncodedString, w, h, false)
        .compress(Bitmap.CompressFormat.PNG, 99, this)
}.toByteArray(), Base64.NO_WRAP)


@Throws(IllegalArgumentException::class)
fun String.convert(): Bitmap? {
    val decodedByteArray: ByteArray = Base64.decode(this, Base64.NO_WRAP)
    return BitmapFactory.decodeByteArray(decodedByteArray, 0, decodedByteArray.size)
}

fun String.withArg(arg: String, isDef: Boolean = false) =
    if (isDef) "$this/{$arg}" else "$this/$arg"

fun String.toArgs() = listOf(navArgument(this) {
    type = NavType.StringType
})

fun Modifier.paddingBottom(paddingValues: PaddingValues): Modifier {
    val pv = paddingValues.calculateBottomPadding()
    return padding(0.dp, 0.dp, 0.dp, if (pv > 46.dp) pv - 46.dp else pv)
}

fun Int.toPercent(dependency: Float) =
    this.let { it -> 1 - ((it * 100 / dependency) / 100f) }

