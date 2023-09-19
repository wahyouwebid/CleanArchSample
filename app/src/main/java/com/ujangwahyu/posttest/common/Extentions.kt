package com.ujangwahyu.posttest.common

import android.util.Base64
import android.view.View
import java.util.regex.Pattern

/**
 * Created by wahyouwebid on 19 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */


fun String.encodeBase64(): String {
    return Base64.encodeToString(this.toByteArray(), Base64.DEFAULT)
}

fun String.decodeBase64(): String {
    return String(Base64.decode(this, Base64.DEFAULT))
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