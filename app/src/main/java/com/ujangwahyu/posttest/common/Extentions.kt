package com.ujangwahyu.posttest.common

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.ujangwahyu.posttest.R
import java.util.regex.Pattern

/**
 * Created by wahyouwebid on 19 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */


fun ImageView.loadImage(imageUrl: String?) {
    Glide.with(this.context)
        .load(imageUrl)
        .placeholder(R.drawable.bg_rounded_place_holder)
        .into(this)
}
fun String.isValidEmail(): Boolean {
    val pattern = Pattern.compile(
        "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
    )
    val matcher = pattern.matcher(this)
    return matcher.matches()
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}



inline fun <reified T : Parcelable> Bundle.parcelable(key: String): T? = when {
    Build.VERSION.SDK_INT >= 33 -> getParcelable(key, T::class.java)
    else -> @Suppress("DEPRECATION") getParcelable(key) as? T
}
