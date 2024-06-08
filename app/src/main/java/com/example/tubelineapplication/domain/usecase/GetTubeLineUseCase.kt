package com.example.tubelineapplication.domain.usecase

import com.example.tubelineapplication.common.Resource
import com.example.tubelineapplication.data.remote.dto.TubeLine
import com.example.tubelineapplication.data.remote.dto.toTube
import com.example.tubelineapplication.domain.model.TubeLineList
import com.example.tubelineapplication.domain.repository.TubeLineRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetTubeLineUseCase @Inject constructor(
    private val repository: TubeLineRepository
){
    operator fun invoke(): Flow<Resource<List<TubeLineList>>> = flow {
        try {
            emit(Resource.Loading<List<TubeLineList>>())
            val tubeLines = repository.getTubes().map { it.toTube() }
            emit(Resource.Success<List<TubeLineList>>(tubeLines))
        } catch (e: HttpException) {
            emit(Resource.Error<List<TubeLineList>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<List<TubeLineList>>("Couldn't reach server. Check your internet connection"))
        }
    }
}
