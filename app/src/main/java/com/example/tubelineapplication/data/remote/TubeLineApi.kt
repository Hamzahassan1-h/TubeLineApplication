package com.example.tubelineapplication.data.remote


import com.example.tubelineapplication.data.remote.dto.TubeLineItemModel
import retrofit2.http.GET

interface TubeLineApi {

    @GET("Status")
    suspend fun getTubes(): List<TubeLineItemModel>


    //https://api.tfl.gov.uk/Line/Mode/Tube/Status
    //Line/Mode/Tube/Status
}