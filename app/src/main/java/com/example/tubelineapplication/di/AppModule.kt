package com.example.tubelineapplication.di

import com.example.tubelineapplication.common.Constants
import com.example.tubelineapplication.data.remote.TubeLineApi
import com.example.tubelineapplication.data.repository.TubeLineImpl
import com.example.tubelineapplication.domain.repository.TubeLineRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTubeLineApi(): TubeLineApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TubeLineApi::class.java)
    }
    @Provides
    @Singleton
    fun provideTubeLineRepository(api: TubeLineApi): TubeLineRepository {
        return TubeLineImpl(api)
    }
}