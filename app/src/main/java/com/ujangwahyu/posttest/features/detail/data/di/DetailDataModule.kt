package com.ujangwahyu.posttest.features.detail.data.di

import com.ujangwahyu.posttest.features.detail.data.DetailApiService
import com.ujangwahyu.posttest.features.detail.data.DetailDataRepository
import com.ujangwahyu.posttest.features.detail.domain.DetailRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DetailDataModule {

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): DetailApiService {
        return retrofit.create(DetailApiService::class.java)
    }

    @Provides
    fun provideDataRepository(
        apiService: DetailApiService
    ): DetailRepository {
        return DetailDataRepository(apiService)
    }

}