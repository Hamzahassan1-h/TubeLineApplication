package com.example.tubelineapplication.domain.model

import com.example.tubelineapplication.data.remote.dto.LineStatusModel

import com.example.tubelineapplication.data.remote.dto.ServiceTypeModel

data class TubeLineList(
    val created: String? = "",
    val id: String? = "",
    val lineStatuses: List<LineStatusModel?>? = listOf(),
    val modeName: String? = "",
    val modified: String? = "",
    val name: String? = "",
    val serviceTypes: List<ServiceTypeModel?>? = listOf(),
)
