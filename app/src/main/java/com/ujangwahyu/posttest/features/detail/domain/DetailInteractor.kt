package com.ujangwahyu.posttest.features.detail.domain

import com.ujangwahyu.posttest.base.BaseResultState
import com.ujangwahyu.posttest.features.detail.domain.model.DetailItem
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

class DetailInteractor @Inject constructor(
    private val repository: DetailRepository,
    private val disposable: CompositeDisposable
): DetailUseCase {

    override fun getDetail(id: String?, callback: (data: BaseResultState<DetailItem>) -> Unit) {
        repository.getDetail(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map<BaseResultState<DetailItem>> { BaseResultState.Success(it) }
            .onErrorReturn { BaseResultState.Error(it) }
            .startWithItem(BaseResultState.Loading)
            .subscribe(callback)
            .let { disposable.add(it) }
    }

    override fun clearDisposable() {
        disposable.clear()
    }

}