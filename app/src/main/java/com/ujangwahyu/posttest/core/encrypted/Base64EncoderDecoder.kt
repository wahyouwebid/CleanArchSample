package com.ujangwahyu.posttest.core.encrypted

/**
 * Created by wahyouwebid on 19 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

interface Base64EncoderDecoder {
    fun encodeToString(input: ByteArray?, flags: Int): String
    fun decode(input: String, flags: Int): ByteArray
}