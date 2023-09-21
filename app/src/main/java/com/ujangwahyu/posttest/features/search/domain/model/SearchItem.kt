package com.ujangwahyu.posttest.features.search.domain.model


import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class SearchItem(
    val idMeal: String?,
    val strCategory: String?,
    val strMeal: String?,
    val strMealThumb: String?,
    val strTags: String?
): Parcelable