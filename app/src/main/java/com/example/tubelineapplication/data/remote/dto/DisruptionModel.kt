package com.example.tubelineapplication.data.remote.dto


import com.google.gson.annotations.SerializedName

data class DisruptionModel(
    @SerializedName("category")
    val category: String? = "",
    @SerializedName("categoryDescription")
    val categoryDescription: String? = "",
    @SerializedName("closureText")
    val closureText: String? = "",
    @SerializedName("description")
    val description: String? = "",

)