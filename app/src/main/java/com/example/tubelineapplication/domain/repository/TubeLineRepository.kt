package com.example.tubelineapplication.domain.repository

import com.example.tubelineapplication.data.remote.dto.TubeLineItemModel


interface TubeLineRepository {

    suspend fun getTubes() : List<TubeLineItemModel>

}