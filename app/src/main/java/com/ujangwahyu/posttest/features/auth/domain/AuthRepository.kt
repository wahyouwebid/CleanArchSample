package com.ujangwahyu.posttest.features.auth.domain

import com.ujangwahyu.posttest.features.auth.domain.model.User

/**
 * Created by wahyouwebid on 19 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

interface AuthRepository {

    fun signUp(user: User)

    fun signIn(): User

}