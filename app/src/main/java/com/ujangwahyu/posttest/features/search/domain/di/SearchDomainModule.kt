package com.ujangwahyu.posttest.features.search.domain.di

import com.ujangwahyu.posttest.features.search.domain.SearchInteractor
import com.ujangwahyu.posttest.features.search.domain.SearchRepository
import com.ujangwahyu.posttest.features.search.domain.SearchUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.rxjava3.disposables.CompositeDisposable

@InstallIn(SingletonComponent::class)
@Module
class SearchDomainModule {

    @Provides
    fun provideInteractor(
        repository: SearchRepository,
        disposable: CompositeDisposable,
    ): SearchUseCase {
        return SearchInteractor(repository, disposable)
    }

}