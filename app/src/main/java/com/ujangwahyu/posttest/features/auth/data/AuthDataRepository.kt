package com.ujangwahyu.posttest.features.auth.data

import com.ujangwahyu.posttest.common.encodeBase64
import com.ujangwahyu.posttest.core.SharedPref
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
    private val sharedPref: SharedPref
): AuthRepository {

    override fun signUp(user: User) {
        sharedPref.apply {
            putString(SharedPref.name, user.name)
            putString(SharedPref.username, user.username)
            putString(SharedPref.nik, user.nik)
            putString(SharedPref.email, user.email)
            putString(SharedPref.password, user.password?.encodeBase64())
        }
    }

    override fun signIn(): User {
        return User(
            sharedPref.getString(SharedPref.name),
            sharedPref.getString(SharedPref.username),
            sharedPref.getString(SharedPref.nik),
            sharedPref.getString(SharedPref.email),
            sharedPref.getString(SharedPref.password),
        )
    }

}