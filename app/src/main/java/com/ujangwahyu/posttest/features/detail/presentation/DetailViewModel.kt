package com.ujangwahyu.posttest.features.detail.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ujangwahyu.posttest.base.BaseResultState
import com.ujangwahyu.posttest.features.detail.domain.DetailUseCase
import com.ujangwahyu.posttest.features.detail.domain.model.DetailItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by wahyouwebid on 20 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val useCase: DetailUseCase
) : ViewModel() {

    val detail: MutableLiveData<BaseResultState<DetailItem>> by lazy {
        MutableLiveData()
    }

    fun getDetail(id: String?) {
        useCase.getDetail(id) {
            detail.postValue(it)
        }
    }

}