package com.ujangwahyu.posttest.features.search.data

import com.ujangwahyu.posttest.core.model.BaseResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApiService {
    @GET("search.php")
    fun searchMeal(
        @Query("f") query: String,
    ): Observable<BaseResponse>
}