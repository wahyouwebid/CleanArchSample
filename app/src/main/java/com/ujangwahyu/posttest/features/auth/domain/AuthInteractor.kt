package com.ujangwahyu.posttest.features.auth.domain

import com.ujangwahyu.posttest.common.Enum
import com.ujangwahyu.posttest.common.decodeBase64
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
                username == user.username && password == user.password?.decodeBase64() -> {
                    ValidationResult(true, Enum.SUCCESS.message, user)
                }

                else -> {
                    ValidationResult(false, Enum.USER_INVALID.message)
                }
            }
        } catch (e: Exception) {
            ValidationResult(false, Enum.USER_INVALID.message)
        }
    }

    override fun validateUsername(username: String): ValidationResult {
        return when {
            username.isEmpty() -> {
                ValidationResult(false, Enum.USERNAME_EMPTY.message)
            }

            username.length < 3 -> {
                ValidationResult(false, Enum.USERNAME_INVALID_LENGTH.message)
            }

            else -> {
                ValidationResult(true)
            }
        }
    }

    override fun validateName(name: String): ValidationResult {
        return when {
            name.isEmpty() -> {
                ValidationResult(false, Enum.NAME_EMPTY.message)
            }

            name.length < 3 -> {
                ValidationResult(false, Enum.NAME_INVALID_LENGTH.message)
            }

            else -> {
                ValidationResult(true)
            }
        }
    }

    override fun validateNIK(nik: String): ValidationResult {
        return when {
            nik.isEmpty() -> {
                ValidationResult(false, Enum.NIK_EMPTY.message)
            }

            nik.length != 16 -> {
                ValidationResult(false, Enum.NIK_INVALID_LENGTH.message)
            }

            else -> {
                ValidationResult(true)
            }
        }
    }

    override fun validateEmail(email: String): ValidationResult {
        return when {
            email.isEmpty() -> {
                ValidationResult(false, Enum.EMAIL_EMPTY.message)
            }

            !email.isValidEmail() -> {
                ValidationResult(false, Enum.EMAIL_INVALID_FORMAT.message)
            }

            else -> {
                ValidationResult(true)
            }
        }
    }

    override fun validatePassword(password: String): ValidationResult {
        return when {
            password.isEmpty() -> {
                ValidationResult(false, Enum.PASSWORD_EMPTY.message)
            }

            password.length < 6 -> {
                ValidationResult(false, Enum.PASSWORD_INVALID_LENGTH.message)
            }

            else -> {
                ValidationResult(true)
            }
        }
    }

}