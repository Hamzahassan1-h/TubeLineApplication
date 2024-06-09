package com

import com.example.tubelineapplication.common.Resource
import com.example.tubelineapplication.data.remote.dto.TubeLineItemModel
import com.example.tubelineapplication.data.remote.dto.toTube
import com.example.tubelineapplication.domain.repository.TubeLineRepository
import com.example.tubelineapplication.domain.usecase.GetTubeLineUseCase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import retrofit2.HttpException
import java.io.IOException

@ExperimentalCoroutinesApi
class GetTubeLineUseCaseTest {

    @Mock
    private lateinit var repository: TubeLineRepository

    private lateinit var getTubeLineUseCase: GetTubeLineUseCase

    private val testDispatcher = TestCoroutineDispatcher()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        getTubeLineUseCase = GetTubeLineUseCase(repository)
    }

    @Test
    fun `invoke returns loading followed by success`() = runBlockingTest(testDispatcher) {
        // Given
        val tubeLines = listOf(
            TubeLineItemModel("id1", "name1", "modeName1", "created1", "modified1"),
            TubeLineItemModel("id2", "name2", "modeName2", "created2", "modified2")
        )
        `when`(repository.getTubes()).thenReturn(tubeLines)

        // When
        val flow = getTubeLineUseCase()

        // Then
        val results = flow.toList()
        assertEquals(2, results.size)
        assertEquals(true, results[0] is Resource.Loading)
        assertEquals(true, results[1] is Resource.Success)
        assertEquals(tubeLines.map { it.toTube() }, (results[1] as Resource.Success).data)
    }

    @Test
    fun `invoke returns loading followed by error on HttpException`() = runBlockingTest(testDispatcher) {
        // Given
        val httpException = Mockito.mock(HttpException::class.java)
        `when`(repository.getTubes()).thenThrow(httpException)

        // When
        val flow = getTubeLineUseCase()

        // Then
        val results = flow.toList()
        assertEquals(2, results.size)
        assertEquals(true, results[0] is Resource.Loading)
        assertEquals(true, results[1] is Resource.Error)
    }

}