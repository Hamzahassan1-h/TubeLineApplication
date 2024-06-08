package com.example.tubelineapplication.presentation.TubeList.components

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tubelineapplication.common.Resource
import com.example.tubelineapplication.domain.usecase.GetTubeLineUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TubeListViewModel @Inject constructor(
    private val getTubeLineUseCase: GetTubeLineUseCase

): ViewModel(){

    private val _state = mutableStateOf(TubeListState())
    val state : State<TubeListState> = _state

    init {
        getTubes()
    }

    private fun getTubes(){
        getTubeLineUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = TubeListState(tubeLines = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = TubeListState(error = result.message ?:
                    "An unexpected error occurred ")
                }
                is Resource.Loading -> {
                    _state.value = TubeListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}