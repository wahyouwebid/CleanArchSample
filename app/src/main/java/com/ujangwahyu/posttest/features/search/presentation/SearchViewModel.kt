package com.ujangwahyu.posttest.features.search.presentation

import android.widget.EditText
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jakewharton.rxbinding3.widget.TextViewTextChangeEvent
import com.jakewharton.rxbinding3.widget.textChangeEvents
import com.ujangwahyu.posttest.base.BaseResultState
import com.ujangwahyu.posttest.features.search.domain.SearchUseCase
import com.ujangwahyu.posttest.features.search.domain.model.SearchItem
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by wahyouwebid on 20 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val useCase: SearchUseCase
) : ViewModel() {

    val search: MutableLiveData<BaseResultState<List<SearchItem>>> by lazy {
        MutableLiveData()
    }

    fun setupSearchMeal(editText: EditText){
        editText.textChangeEvents()
            .skipInitialValue()
            .debounce(500, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<TextViewTextChangeEvent>() {
                override fun onNext(t: TextViewTextChangeEvent) {
                    val keyword = t.text.toString()
                    if(keyword.trim{it <= ' '}.isNotEmpty() && keyword.trim { it <= ' ' }.isNotEmpty()) {
                        useCase.searchMeal(keyword) {
                            search.postValue(it)
                        }
                    }
                }

                override fun onError(e: Throwable) {

                }

                override fun onComplete() {

                }
            })
            .let { return@let useCase.getDisposable()::add }
    }
}