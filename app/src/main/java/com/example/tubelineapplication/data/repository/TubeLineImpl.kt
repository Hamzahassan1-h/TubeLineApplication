package com.example.tubelineapplication.data.repository

import com.example.tubelineapplication.data.remote.TubeLineApi
import com.example.tubelineapplication.data.remote.dto.TubeLineItemModel
import com.example.tubelineapplication.domain.repository.TubeLineRepository

import javax.inject.Inject

class TubeLineImpl @Inject constructor(
    private val api: TubeLineApi
) : TubeLineRepository{
    override suspend fun getTubes(): List<TubeLineItemModel> {
        return api.getTubes()
    }
}