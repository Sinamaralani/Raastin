package com.example.raastin.core.di

import com.example.raastin.core.data.remote.MarketsApi
import com.example.raastin.core.data.repository.MarketsRepositoryImpl
import com.example.raastin.core.domain.repository.MarketsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMarketsApi(): MarketsApi {
        return Retrofit.Builder().baseUrl("https://api.raastin.com/api/v1/").addConverterFactory(
            GsonConverterFactory.create()
        ).build().create(MarketsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMarketsRepository(marketsApi: MarketsApi): MarketsRepository {
        return MarketsRepositoryImpl(marketsApi)
    }


}