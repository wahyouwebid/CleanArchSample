package com.ujangwahyu.posttest.features.auth.presentation.ui

import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.ujangwahyu.posttest.R
import com.ujangwahyu.posttest.base.BaseFragment
import com.ujangwahyu.posttest.databinding.FragmentSignInBinding
import com.ujangwahyu.posttest.features.auth.presentation.viewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by wahyouwebid on 19 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

@AndroidEntryPoint
class SignFragment: BaseFragment<FragmentSignInBinding>(FragmentSignInBinding::inflate) {

    private val viewModel: AuthViewModel by viewModels()

    private val navigation: NavController? by lazy {
        activity?.findNavController(R.id.nav_host_auth)
    }

    override fun setupView(savedInstanceState: Bundle?) = with(binding){
        etUsername.doOnTextChanged { text, _, _, _ ->
            viewModel.validateUsername(binding, text.toString())
        }

        etPassword.doOnTextChanged { text, _, _, _ ->
            viewModel.validatePassword(binding, text.toString())
        }

        btnSignin.setOnClickListener {
            viewModel.signIn(binding)
        }

        btnSignup.setOnClickListener {
            goToSignUp()
        }
    }

    override fun setupViewModel() {
        viewModel.signIn.observe(viewLifecycleOwner) {
            navigation?.navigate(R.id.action_signFragment_to_searchFragment)
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) {
            if (it != null) {
                showMessage(it)
            }
        }
    }

    private fun goToSignUp() {
        navigation?.navigate(R.id.action_signFragment_to_signUpFragment)
    }

    private fun showMessage(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_INDEFINITE).apply {
            setAction(getString(R.string.title_oke)) {
                dismiss()
            }
            show()
        }
    }
}