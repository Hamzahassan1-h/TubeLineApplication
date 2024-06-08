package com.example.tubelineapplication.data.remote.dto


import com.google.gson.annotations.SerializedName

data class ServiceTypeModel(
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("uri")
    val uri: String? = ""
)