package com.ujangwahyu.posttest.features.auth.domain.di

import com.ujangwahyu.posttest.features.auth.domain.AuthInteractor
import com.ujangwahyu.posttest.features.auth.domain.AuthRepository
import com.ujangwahyu.posttest.features.auth.domain.AuthUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AuthDomainModule {

    @Provides
    fun provideInteractor(
        repository: AuthRepository
    ): AuthUseCase {
        return AuthInteractor(repository)
    }
}