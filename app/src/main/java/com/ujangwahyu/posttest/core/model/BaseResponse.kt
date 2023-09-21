package com.ujangwahyu.posttest.core.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class BaseResponse(
    @SerializedName("meals")
    val meals: List<DataMeal>
)