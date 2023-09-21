package com.ujangwahyu.posttest.features.detail.domain.model


import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class DetailItem(
    val idMeal: String?,
    val strCategory: String?,
    val strMeal: String?,
    val strMealThumb: String?,
    val strTags: String?,
    val strInstructions: String?,
    val strYoutube: String?,
): Parcelable