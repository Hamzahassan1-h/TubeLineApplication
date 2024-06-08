package com.example.tubelineapplication.data.remote.dto


import com.example.tubelineapplication.domain.model.TubeLineList
import com.google.gson.annotations.SerializedName

data class TubeLineItemModel(
    @SerializedName("created")
    val created: String? = "",
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("lineStatuses")
    val lineStatuses: List<LineStatusModel?>? = listOf(),
    @SerializedName("modeName")
    val modeName: String? = "",
    @SerializedName("modified")
    val modified: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("serviceTypes")
    val serviceTypes: List<ServiceTypeModel?>? = listOf(),

)
fun TubeLineItemModel.toTube(): TubeLineList {
    return TubeLineList(
        created = created,
        id = id,
        lineStatuses = lineStatuses,
        modeName = modeName,
        modified = modified,
        name = name,
        serviceTypes = serviceTypes
    )
}
