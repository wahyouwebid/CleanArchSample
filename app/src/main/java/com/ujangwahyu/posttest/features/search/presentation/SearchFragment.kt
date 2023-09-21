package com.ujangwahyu.posttest.features.search.presentation

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.ujangwahyu.posttest.R
import com.ujangwahyu.posttest.base.BaseFragment
import com.ujangwahyu.posttest.base.BaseResultState
import com.ujangwahyu.posttest.databinding.FragmentSearchBinding
import com.ujangwahyu.posttest.features.search.domain.model.SearchItem
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by wahyouwebid on 20 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

@AndroidEntryPoint
class SearchFragment: BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate) {

    private val viewModel: SearchViewModel by viewModels()

    private val navigation: NavController? by lazy {
        activity?.findNavController(R.id.nav_host_auth)
    }

    private val adapter: SearchAdapter by lazy {
        SearchAdapter { goToDetail(it) }
    }

    override fun setupView(savedInstanceState: Bundle?){
        with(binding) {
            rvData.setHasFixedSize(false)
            rvData.isNestedScrollingEnabled = false
            rvData.layoutManager = LinearLayoutManager(context)
            rvData.adapter = adapter
        }
    }

    override fun setupViewModel() {
        viewModel.setupSearchMeal(binding.etSearch)
        viewModel.search.observe(viewLifecycleOwner) {
            when(it) {
                is BaseResultState.Loading -> setupLoading(true)
                is BaseResultState.Error -> setupError(it.error)
                is BaseResultState.Success -> setupSuccess(it.data)
            }
        }
    }

    private fun setupSuccess(data: List<SearchItem>) = with(binding){
        adapter.setData(data)
        adapter.notifyItemRangeChanged(0, adapter.itemCount)
        setupLoading(false)
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
        Snackbar.make(binding.rvData, error.message.toString(), Snackbar.LENGTH_INDEFINITE).apply {
            setAction(getString(R.string.title_oke)) {
                dismiss()
            }
            show()
        }
    }

    private fun goToDetail(data: SearchItem) {
        navigation?.navigate(
            R.id.action_searchFragment_to_detailFragment,
            bundleOf("data" to data)
        )
    }

}