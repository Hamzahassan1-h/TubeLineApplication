package com

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.tubelineapplication.common.Resource
import com.example.tubelineapplication.domain.model.TubeLineList
import com.example.tubelineapplication.domain.usecase.GetTubeLineUseCase
import com.example.tubelineapplication.presentation.TubeList.components.TubeListState
import com.example.tubelineapplication.presentation.TubeList.components.TubeListViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class TubeListViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private val testDispatcher = TestCoroutineDispatcher()

    @Mock
    private lateinit var getTubeLineUseCase: GetTubeLineUseCase

    private lateinit var viewModel: TubeListViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(testDispatcher)
        viewModel = TubeListViewModel(getTubeLineUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun `getTubes emits success`() = runTest {
        val tubeList = listOf(TubeLineList("created", "id", "modeName", "modified", "name"))
        val flow: Flow<Resource<List<TubeLineList>>> = flow {
            emit(Resource.Loading())
            emit(Resource.Success(tubeList))
        }

        `when`(getTubeLineUseCase()).thenReturn(flow)

        viewModel.getTubes()

        // Advances the virtual clock until all tasks are completed
        advanceUntilIdle()

        assert(viewModel.state.value == TubeListState(tubeLines = tubeList))
    }

    @Test
    fun `getTubes emits error`() = runTest {
        val errorMessage = "An unexpected error occurred"
        val flow: Flow<Resource<List<TubeLineList>>> = flow {
            emit(Resource.Loading())
            emit(Resource.Error(errorMessage))
        }

        `when`(getTubeLineUseCase()).thenReturn(flow)

        viewModel.getTubes()

        // Advances the virtual clock until all tasks are completed
        advanceUntilIdle()

        assert(viewModel.state.value == TubeListState(error = errorMessage))
    }

    @Test
    fun `getTubes emits loading`() = runTest {
        val flow: Flow<Resource<List<TubeLineList>>> = flow {
            emit(Resource.Loading())
        }

        `when`(getTubeLineUseCase()).thenReturn(flow)

        viewModel.getTubes()


        // Advances the virtual clock until all tasks are completed
        advanceUntilIdle()

        assert(viewModel.state.value == TubeListState(isLoading = true))
    }
}
