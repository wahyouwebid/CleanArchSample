package com.ujangwahyu.posttest.features.detail.presentation

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.ujangwahyu.posttest.R
import com.ujangwahyu.posttest.base.BaseFragment
import com.ujangwahyu.posttest.base.BaseResultState
import com.ujangwahyu.posttest.common.loadImage
import com.ujangwahyu.posttest.common.parcelable
import com.ujangwahyu.posttest.common.show
import com.ujangwahyu.posttest.databinding.FragmentDetailBinding
import com.ujangwahyu.posttest.features.detail.domain.model.DetailItem
import com.ujangwahyu.posttest.features.search.domain.model.SearchItem
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by wahyouwebid on 20 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

@AndroidEntryPoint
class DetailFragment: BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate) {

    private val viewModel: DetailViewModel by viewModels()

    private val navigation: NavController? by lazy {
        activity?.findNavController(R.id.nav_host_auth)
    }

    private val data: SearchItem? by lazy {
        arguments?.parcelable("data")
    }

    override fun setupView(savedInstanceState: Bundle?) = with(binding) {
        ivBack.setOnClickListener {
            navigation?.navigateUp()
        }
    }

    override fun setupViewModel() {
        viewModel.getDetail(data?.idMeal)
        viewModel.detail.observe(viewLifecycleOwner) {
            when(it) {
                is BaseResultState.Loading -> setupLoading(true)
                is BaseResultState.Error -> setupError(it.error)
                is BaseResultState.Success -> setupSuccess(it.data)
            }
        }
    }

    private fun setupSuccess(data: DetailItem) = with(binding){
        setupLoading(false)
        tvName.text = data.strMeal
        tvCategories.text = data.strCategory
        tvDes.text = data.strInstructions
        ivThumbnail.loadImage(data.strMealThumb)
        tvCategories.show()
    }

    private fun setupLoading(isLoading: Boolean) = with(binding) {
        if (isLoading) {
            loading.show()
        } else {
            loading.hide()
        }
    }

    private fun setupError(error: Throwable) {
        setupLoading(false)
        Snackbar.make(binding.root, error.message.toString(), Snackbar.LENGTH_INDEFINITE).apply {
            setAction(getString(R.string.title_oke)) {
                dismiss()
            }
            show()
        }
    }

}