package com.example.tubelineapplication.data.remote.dto


import com.example.tubelineapplication.domain.model.TubeLineList
import com.google.gson.annotations.SerializedName

data class TubeLineItemModel(
    @SerializedName("created")
    val created: String? = "",
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("modeName")
    val modeName: String? = "",
    @SerializedName("modified")
    val modified: String? = "",
    @SerializedName("name")
    val name: String? = "",


)
fun TubeLineItemModel.toTube(): TubeLineList {
    return TubeLineList(
        created = created,
        id = id,
        modeName = modeName,
        modified = modified,
        name = name,

    )
}
