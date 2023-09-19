package com.ujangwahyu.posttest.features.auth.data.di

import com.ujangwahyu.posttest.core.Sessions
import com.ujangwahyu.posttest.features.auth.data.AuthDataRepository
import com.ujangwahyu.posttest.features.auth.domain.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AuthDataModule {

    @Provides
    fun provideRepository(
        sessions: Sessions
    ): AuthRepository {
        return AuthDataRepository(sessions)
    }

}