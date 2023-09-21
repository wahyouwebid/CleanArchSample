package com.ujangwahyu.posttest.features.detail.data

import com.ujangwahyu.posttest.core.model.BaseResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface DetailApiService {
    @GET("lookup.php")
    fun getDetailById(
        @Query("i") id: String?,
    ): Observable<BaseResponse>
}