package com.ujangwahyu.posttest.features.auth.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ujangwahyu.posttest.common.hide
import com.ujangwahyu.posttest.common.show
import com.ujangwahyu.posttest.databinding.FragmentSignInBinding
import com.ujangwahyu.posttest.features.auth.domain.AuthUseCase
import com.ujangwahyu.posttest.features.auth.domain.model.User
import com.ujangwahyu.posttest.features.auth.domain.model.ValidationResult
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by wahyouwebid on 19 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val useCase: AuthUseCase
): ViewModel() {

    val signIn: MutableLiveData<User> by lazy {
        MutableLiveData()
    }

    val errorMessageSignIn: MutableLiveData<String> by lazy {
        MutableLiveData()
    }

    val signUp: MutableLiveData<User> by lazy {
        MutableLiveData()
    }

    fun signIn(
        binding: FragmentSignInBinding,
        username: String,
        password: String
    ) {

        val hasError = listOf(
            validateUsername(binding, username),
            validatePassword(binding, password),
        )

        if (!hasError.any { !it.successful }) {
            val result = useCase.signIn(username, password)
            if (result.successful) {
                signIn.postValue(result.data)
                errorMessageSignIn.postValue(null)
            } else {
                errorMessageSignIn.postValue(result.message)
            }
        } else {
            hasError.reversed().filter { !it.successful }.map {
                errorMessageSignIn.postValue(it.message)
            }
        }
    }


    fun validateUsername(
        binding: FragmentSignInBinding,
        username: String
    ): ValidationResult {
        val result = useCase.validateUsername(username)
        binding.tvUsernameError.apply {
            if (!result.message.isNullOrEmpty()) show() else hide()
            text = result.message
        }
        return result
    }

    fun validatePassword(
        binding: FragmentSignInBinding,
        password: String
    ): ValidationResult {
        val result = useCase.validatePassword(password)
        binding.tvPasswordError.apply {
            if (!result.message.isNullOrEmpty()) show() else hide()
            text = result.message
        }
        return result
    }

}