package com.ujangwahyu.posttest.features.search.domain

import com.ujangwahyu.posttest.features.search.domain.model.SearchItem
import io.reactivex.rxjava3.core.Observable

/**
 * Created by wahyouwebid on 20 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

interface SearchRepository {

    fun searchMeal(query: String): Observable<List<SearchItem>>

}