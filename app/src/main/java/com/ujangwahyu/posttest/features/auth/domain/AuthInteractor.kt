package com.ujangwahyu.posttest.features.auth.domain

import com.ujangwahyu.posttest.common.DataEnum
import com.ujangwahyu.posttest.common.isValidEmail
import com.ujangwahyu.posttest.features.auth.domain.model.User
import com.ujangwahyu.posttest.features.auth.domain.model.ValidationResult
import javax.inject.Inject

/**
 * Created by wahyouwebid on 19 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

class AuthInteractor @Inject constructor(
    private val repository: AuthRepository,
): AuthUseCase {

    override fun signUp(user: User) {
        repository.signUp(user)
    }

    override fun signIn(username: String, password: String): ValidationResult {
        val user = repository.signIn()
        return try {
            when {
                username == user.username && password == user.password -> {
                    ValidationResult(true, DataEnum.SUCCESS.message, user)
                }

                else -> {
                    ValidationResult(false, DataEnum.USER_INVALID.message)
                }
            }
        } catch (e: Exception) {
            ValidationResult(false, DataEnum.USER_INVALID.message)
        }
    }

    override fun validateUsername(username: String): ValidationResult {
        return when {
            username.isEmpty() -> {
                ValidationResult(false, DataEnum.USERNAME_EMPTY.message)
            }

            username.length < 3 -> {
                ValidationResult(false, DataEnum.USERNAME_INVALID_LENGTH.message)
            }

            else -> {
                ValidationResult(true)
            }
        }
    }

    override fun validateName(name: String): ValidationResult {
        return when {
            name.isEmpty() -> {
                ValidationResult(false, DataEnum.NAME_EMPTY.message)
            }

            name.length < 3 -> {
                ValidationResult(false, DataEnum.NAME_INVALID_LENGTH.message)
            }

            else -> {
                ValidationResult(true)
            }
        }
    }

    override fun validateNIK(nik: String): ValidationResult {
        return when {
            nik.isEmpty() -> {
                ValidationResult(false, DataEnum.NIK_EMPTY.message)
            }

            nik.length != 16 -> {
                ValidationResult(false, DataEnum.NIK_INVALID_LENGTH.message)
            }

            else -> {
                ValidationResult(true)
            }
        }
    }

    override fun validateEmail(email: String): ValidationResult {
        return when {
            email.isEmpty() -> {
                ValidationResult(false, DataEnum.EMAIL_EMPTY.message)
            }

            !email.isValidEmail() -> {
                ValidationResult(false, DataEnum.EMAIL_INVALID_FORMAT.message)
            }

            else -> {
                ValidationResult(true)
            }
        }
    }

    override fun validatePassword(password: String): ValidationResult {
        return when {
            password.isEmpty() -> {
                ValidationResult(false, DataEnum.PASSWORD_EMPTY.message)
            }

            password.length < 6 -> {
                ValidationResult(false, DataEnum.PASSWORD_INVALID_LENGTH.message)
            }

            else -> {
                ValidationResult(true)
            }
        }
    }

}