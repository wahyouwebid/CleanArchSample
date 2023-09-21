package com.ujangwahyu.posttest.features.search.data.di

import com.ujangwahyu.posttest.features.search.data.SearchApiService
import com.ujangwahyu.posttest.features.search.data.SearchDataRepository
import com.ujangwahyu.posttest.features.search.domain.SearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class SearchDataModule {

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): SearchApiService {
        return retrofit.create(SearchApiService::class.java)
    }

    @Provides
    fun provideDataRepository(
        apiService: SearchApiService
    ): SearchRepository {
        return SearchDataRepository(apiService)
    }

}