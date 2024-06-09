package com

import com.example.tubelineapplication.data.remote.TubeLineApi
import com.example.tubelineapplication.data.remote.dto.TubeLineItemModel
import com.example.tubelineapplication.data.repository.TubeLineImpl
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


class TubeLineImplTest {

    @Mock
    private lateinit var api: TubeLineApi

    private lateinit var repository: TubeLineImpl

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        repository = TubeLineImpl(api)
    }

    @Test
    fun `getTubes returns list of TubeLineItemModel`(): Unit = runBlocking {
        // Given
        val expectedTubes = listOf(
            TubeLineItemModel("id1", "name1", "modeName1", "created1", "modified1"),
            TubeLineItemModel("id2", "name2", "modeName2", "created2", "modified2")
        )
        Mockito.`when`(api.getTubes()).thenReturn(expectedTubes)

        // When
        val actualTubes = repository.getTubes()

        // Then
        assertEquals(expectedTubes, actualTubes)
        Mockito.verify(api).getTubes()
    }
}
