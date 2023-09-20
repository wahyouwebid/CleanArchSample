package com.ujangwahyu.posttest.features.auth.data.di

import com.ujangwahyu.posttest.core.encrypted.AndroidBase64EncoderDecoder
import com.ujangwahyu.posttest.core.encrypted.Base64EncoderDecoder
import com.ujangwahyu.posttest.core.sharepref.SharedPref
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
        sharedPref: SharedPref,
        decoder: Base64EncoderDecoder
    ): AuthRepository {
        return AuthDataRepository(sharedPref, decoder)
    }

}