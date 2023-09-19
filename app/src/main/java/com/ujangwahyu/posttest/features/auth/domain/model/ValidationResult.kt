package com.ujangwahyu.posttest.features.auth.domain.model

/**
 * Created by wahyouwebid on 19 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

data class ValidationResult(
    val successful: Boolean,
    val message: String? = "",
    val data: User? = null
)