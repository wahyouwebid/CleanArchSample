package com.ujangwahyu.posttest.features.detail.domain

import com.ujangwahyu.posttest.features.detail.domain.model.DetailItem
import io.reactivex.rxjava3.core.Observable

/**
 * Created by wahyouwebid on 20 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

interface DetailRepository {

    fun getDetail(id: String?): Observable<DetailItem>

}