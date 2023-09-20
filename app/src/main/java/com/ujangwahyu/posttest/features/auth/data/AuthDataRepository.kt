package com.ujangwahyu.posttest.features.auth.data

import android.util.Base64
import com.ujangwahyu.posttest.common.encodeBase64
import com.ujangwahyu.posttest.core.encrypted.Base64EncoderDecoder
import com.ujangwahyu.posttest.core.sharepref.SharedPref
import com.ujangwahyu.posttest.features.auth.domain.AuthRepository
import com.ujangwahyu.posttest.features.auth.domain.model.User
import javax.inject.Inject

/**
 * Created by wahyouwebid on 19 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

class AuthDataRepository @Inject constructor(
    private val sharedPref: SharedPref,
    private val decoder: Base64EncoderDecoder
): AuthRepository {

    override fun signUp(user: User) {
        sharedPref.apply {
            putString(SharedPref.name, user.name)
            putString(SharedPref.username, user.username)
            putString(SharedPref.nik, user.nik)
            putString(SharedPref.email, user.email)
            putString(SharedPref.password, decoder.encodeToString(user.password?.toByteArray(), Base64.DEFAULT))
        }
    }

    override fun signIn(): User {
        return User(
            sharedPref.getString(SharedPref.name),
            sharedPref.getString(SharedPref.username),
            sharedPref.getString(SharedPref.nik),
            sharedPref.getString(SharedPref.email),
            String(decoder.decode(sharedPref.getString(SharedPref.password), Base64.DEFAULT), Charsets.UTF_8)
        )
    }

}