package com.ujangwahyu.posttest.features.search.data

import com.ujangwahyu.posttest.features.search.domain.SearchRepository
import com.ujangwahyu.posttest.features.search.domain.model.SearchItem
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

/**
 * Created by wahyouwebid on 20 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

class SearchDataRepository @Inject constructor(
    private val api: SearchApiService
): SearchRepository {

    override fun searchMeal(query: String): Observable<List<SearchItem>> {
        return api.searchMeal(query).map { result -> result.meals.map { it.toSearchDomain() } }
    }

}