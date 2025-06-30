package com.pmdm.birthdayremember.di

import android.content.Context
import com.pmdm.birthdayremember.infraestructure.room.db.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDataBase =
        AppDataBase.getDataBase(context)

    @Provides
    @Singleton
    fun provideBirthdayDao(db: AppDataBase) = db.birthdayDao()

    @Provides
    @Singleton
    fun provideGroupDao(db: AppDataBase) = db.groupDao()
}