package com.example.tubelineapplication.data.remote.dto


import com.google.gson.annotations.SerializedName

data class ValidityPeriodModel(
    @SerializedName("fromDate")
    val fromDate: String? = "",
    @SerializedName("isNow")
    val isNow: Boolean? = false,
    @SerializedName("toDate")
    val toDate: String? = "",

)