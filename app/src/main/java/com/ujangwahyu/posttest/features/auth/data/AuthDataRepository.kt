package com.ujangwahyu.posttest.features.auth.data

import com.ujangwahyu.posttest.common.encodeBase64
import com.ujangwahyu.posttest.core.Sessions
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
    private val sessions: Sessions
): AuthRepository {

    override fun signUp(user: User) {
        sessions.apply {
            putString(Sessions.name, user.name)
            putString(Sessions.username, user.username)
            putString(Sessions.nik, user.nik)
            putString(Sessions.email, user.email)
            putString(Sessions.password, user.password?.encodeBase64())
        }
    }

    override fun signIn(): User {
        return User(
            sessions.getString(Sessions.name),
            sessions.getString(Sessions.username),
            sessions.getString(Sessions.nik),
            sessions.getString(Sessions.email),
            sessions.getString(Sessions.password),
        )
    }

}