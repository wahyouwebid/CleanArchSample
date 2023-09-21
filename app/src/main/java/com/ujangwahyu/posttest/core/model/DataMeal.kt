package com.ujangwahyu.posttest.core.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import com.ujangwahyu.posttest.features.detail.domain.model.DetailItem
import com.ujangwahyu.posttest.features.search.domain.model.SearchItem

@Keep
data class DataMeal(
    @SerializedName("idMeal")
    val idMeal: String?,
    @SerializedName("strCategory")
    val strCategory: String?,
    @SerializedName("strMeal")
    val strMeal: String?,
    @SerializedName("strMealThumb")
    val strMealThumb: String?,
    @SerializedName("strTags")
    val strTags: String?,
    @SerializedName("strInstructions")
    val strInstructions: String?,
    @SerializedName("strYoutube")
    val strYoutube: String?,
) {
    fun toSearchDomain(): SearchItem {
        return SearchItem(
            idMeal,
            strCategory,
            strMeal,
            strMealThumb,
            strTags
        )
    }

    fun toDetailDomain(): DetailItem {
        return DetailItem(
            idMeal,
            strCategory,
            strMeal,
            strMealThumb,
            strTags,
            strInstructions,
            strYoutube
        )
    }
}