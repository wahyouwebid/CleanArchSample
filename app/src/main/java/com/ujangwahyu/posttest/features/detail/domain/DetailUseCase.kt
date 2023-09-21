package com.ujangwahyu.posttest.features.detail.domain

import com.ujangwahyu.posttest.base.BaseResultState
import com.ujangwahyu.posttest.features.detail.domain.model.DetailItem

/**
 * Created by wahyouwebid on 20 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

interface DetailUseCase {

    fun getDetail(id: String?, callback: (data: BaseResultState<DetailItem>) -> Unit)

    fun clearDisposable()

}