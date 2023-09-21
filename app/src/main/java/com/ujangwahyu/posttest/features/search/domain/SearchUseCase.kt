package com.ujangwahyu.posttest.features.search.domain

import com.ujangwahyu.posttest.base.BaseResultState
import com.ujangwahyu.posttest.features.search.domain.model.SearchItem
import io.reactivex.rxjava3.disposables.CompositeDisposable

/**
 * Created by wahyouwebid on 20 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

interface SearchUseCase {

    fun searchMeal(query: String, callback: (data: BaseResultState<List<SearchItem>>) -> Unit)

    fun getDisposable(): CompositeDisposable

    fun clearDisposable()

}