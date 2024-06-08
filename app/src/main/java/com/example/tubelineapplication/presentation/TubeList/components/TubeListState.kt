package com.example.tubelineapplication.presentation.TubeList.components

import com.example.tubelineapplication.domain.model.TubeLineList

data class TubeListState(
    val isLoading: Boolean = false,
    val tubeLines: List<TubeLineList> = emptyList(),
    val error: String = " "
)
