package com.ujangwahyu.posttest.features.auth.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ujangwahyu.posttest.common.hide
import com.ujangwahyu.posttest.common.show
import com.ujangwahyu.posttest.databinding.FragmentSignInBinding
import com.ujangwahyu.posttest.databinding.FragmentSignUpBinding
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

    val signUp: MutableLiveData<Boolean> by lazy {
        MutableLiveData()
    }

    val errorMessage: MutableLiveData<String> by lazy {
        MutableLiveData()
    }

    fun signIn(
        binding: FragmentSignInBinding
    ) = with(binding){

        val hasError = listOf(
            validateUsername(binding, etUsername.text.toString()),
            validatePassword(binding, etPassword.text.toString()),
        )

        if (!hasError.any { !it.successful }) {
            val result = useCase.signIn(etUsername.text.toString(), etPassword.text.toString())
            if (result.successful) {
                signIn.postValue(result.data)
                errorMessage.postValue(null)
            } else {
                errorMessage.postValue(result.message)
            }
        } else {
            hasError.reversed().filter { !it.successful }.map {
                errorMessage.postValue(it.message)
            }
        }
    }


    fun signUp(binding: FragmentSignUpBinding) = with(binding){
        val hasError = listOf(
            validateName(binding, etName.text.toString()),
            validateUsername(binding, etUsername.text.toString()),
            validateNik(binding, etNik.text.toString()),
            validateEmail(binding, etEmail.text.toString()),
            validatePassword(binding, etPassword.text.toString()),
        )

        if (!hasError.any { !it.successful }) {
            val user = User(
                etName.text.toString(),
                etUsername.text.toString(),
                etNik.text.toString(),
                etEmail.text.toString(),
                etPassword.text.toString()
            )

            useCase.signUp(user)
            signUp.postValue(true)
            errorMessage.postValue(null)
        } else {
            hasError.reversed().filter { !it.successful }.map {
                errorMessage.postValue(it.message)
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

    fun validateName(
        binding: FragmentSignUpBinding,
        username: String
    ): ValidationResult {
        val result = useCase.validateName(username)
        binding.tvNameError.apply {
            if (!result.message.isNullOrEmpty()) show() else hide()
            text = result.message
        }
        return result
    }

    fun validateUsername(
        binding: FragmentSignUpBinding,
        username: String
    ): ValidationResult {
        val result = useCase.validateUsername(username)
        binding.tvUsernameError.apply {
            if (!result.message.isNullOrEmpty()) show() else hide()
            text = result.message
        }
        return result
    }

    fun validateNik(
        binding: FragmentSignUpBinding,
        username: String
    ): ValidationResult {
        val result = useCase.validateNIK(username)
        binding.tvNikError.apply {
            if (!result.message.isNullOrEmpty()) show() else hide()
            text = result.message
        }
        return result
    }

    fun validateEmail(
        binding: FragmentSignUpBinding,
        username: String
    ): ValidationResult {
        val result = useCase.validateEmail(username)
        binding.tvEmailError.apply {
            if (!result.message.isNullOrEmpty()) show() else hide()
            text = result.message
        }
        return result
    }

    fun validatePassword(
        binding: FragmentSignUpBinding,
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