package com.ujangwahyu.posttest.features.search.domain

import com.ujangwahyu.posttest.base.BaseResultState
import com.ujangwahyu.posttest.features.search.domain.model.SearchItem
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by wahyouwebid on 20 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

class SearchInteractor @Inject constructor(
    private val repository: SearchRepository,
    private val disposable: CompositeDisposable
): SearchUseCase {

    override fun searchMeal(query: String, callback: (data: BaseResultState<List<SearchItem>>) -> Unit) {
        repository.searchMeal(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map<BaseResultState<List<SearchItem>>> { BaseResultState.Success(it) }
            .onErrorReturn { BaseResultState.Error(it) }
            .startWithItem(BaseResultState.Loading)
            .subscribe(callback)
            .let { disposable.add(it) }
    }

    override fun getDisposable(): CompositeDisposable {
        return disposable
    }

    override fun clearDisposable() {
        disposable.clear()
    }

}