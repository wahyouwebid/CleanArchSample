package com.ujangwahyu.posttest.features.auth.domain

import com.ujangwahyu.posttest.features.auth.domain.model.User
import com.ujangwahyu.posttest.features.auth.domain.model.ValidationResult

/**
 * Created by wahyouwebid on 19 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

interface AuthUseCase {

    fun signUp(user: User)

    fun signIn(username: String, password: String): ValidationResult

    fun validateUsername(username: String): ValidationResult

    fun validateName(name: String): ValidationResult

    fun validateNIK(nik: String): ValidationResult

    fun validateEmail(email: String): ValidationResult

    fun validatePassword(password: String): ValidationResult
}