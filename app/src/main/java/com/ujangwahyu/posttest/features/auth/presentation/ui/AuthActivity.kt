package com.ujangwahyu.posttest.features.auth.presentation.ui

import android.os.Bundle
import com.ujangwahyu.posttest.base.BaseActivity
import com.ujangwahyu.posttest.databinding.ActivityAuthBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthActivity : BaseActivity<ActivityAuthBinding>(ActivityAuthBinding::inflate) {

    override fun setupView(savedInstanceState: Bundle?) {}

    override fun setupViewModel() {}

}