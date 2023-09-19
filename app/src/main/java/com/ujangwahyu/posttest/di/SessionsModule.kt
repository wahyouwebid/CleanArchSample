package com.ujangwahyu.posttest.di

import android.content.Context
import com.ujangwahyu.posttest.core.SharedPref
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
class SessionsModule {

    @Provides
    @Singleton
    fun provideSessions(@ApplicationContext context: Context): SharedPref = SharedPref(context)

}