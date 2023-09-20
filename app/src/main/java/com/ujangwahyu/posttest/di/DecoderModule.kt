package com.ujangwahyu.posttest.di

import com.ujangwahyu.posttest.core.encrypted.AndroidBase64EncoderDecoder
import com.ujangwahyu.posttest.core.encrypted.Base64EncoderDecoder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by wahyouwebid on 19 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

@Module
@InstallIn(SingletonComponent::class)
class DecoderModule {

    @Provides
    @Singleton
    fun provideSessions(): Base64EncoderDecoder = AndroidBase64EncoderDecoder()

}