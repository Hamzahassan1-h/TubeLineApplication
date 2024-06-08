package com.example.tubelineapplication.data.remote.dto


import com.google.gson.annotations.SerializedName

data class LineStatusModel(
    @SerializedName("created")
    val created: String? = "",
    @SerializedName("disruption")
    val disruption: DisruptionModel? = DisruptionModel(),
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("lineId")
    val lineId: String? = "",
    @SerializedName("reason")
    val reason: String? = "",
    @SerializedName("statusSeverity")
    val statusSeverity: Int? = 0,
    @SerializedName("statusSeverityDescription")
    val statusSeverityDescription: String? = "",
    @SerializedName("validityPeriods")
    val validityPeriods: List<ValidityPeriodModel?>? = listOf()
)