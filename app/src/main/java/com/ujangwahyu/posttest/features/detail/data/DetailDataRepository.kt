package com.ujangwahyu.posttest.features.detail.data

import com.ujangwahyu.posttest.features.detail.domain.DetailRepository
import com.ujangwahyu.posttest.features.detail.domain.model.DetailItem
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

/**
 * Created by wahyouwebid on 20 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

class DetailDataRepository @Inject constructor(
    private val api: DetailApiService
): DetailRepository {

    override fun getDetail(id: String?): Observable<DetailItem> {
        return api.getDetailById(id).map { it.meals[0].toDetailDomain() }
    }

}