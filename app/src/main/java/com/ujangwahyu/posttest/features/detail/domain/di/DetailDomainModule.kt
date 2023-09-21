package com.ujangwahyu.posttest.features.detail.domain.di

import com.ujangwahyu.posttest.features.detail.domain.DetailInteractor
import com.ujangwahyu.posttest.features.detail.domain.DetailRepository
import com.ujangwahyu.posttest.features.detail.domain.DetailUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.rxjava3.disposables.CompositeDisposable

@InstallIn(SingletonComponent::class)
@Module
class DetailDomainModule {

    @Provides
    fun provideInteractor(
        repository: DetailRepository,
        disposable: CompositeDisposable,
    ): DetailUseCase {
        return DetailInteractor(repository, disposable)
    }

}