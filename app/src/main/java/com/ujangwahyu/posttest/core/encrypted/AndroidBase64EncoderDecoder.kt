package com.ujangwahyu.posttest.core.encrypted

import android.util.Base64

/**
 * Created by wahyouwebid on 19 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

class AndroidBase64EncoderDecoder : Base64EncoderDecoder {
    override fun encodeToString(input: ByteArray?, flags: Int): String {
        return Base64.encodeToString(input, flags)
    }

    override fun decode(input: String, flags: Int): ByteArray {
        return Base64.decode(input, flags)
    }
}