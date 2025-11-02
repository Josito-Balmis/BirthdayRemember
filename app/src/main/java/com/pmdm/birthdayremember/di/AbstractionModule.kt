package com.pmdm.birthdayremember.di

import com.pmdm.birthdayremember.domain.repository.EventRepository
import com.pmdm.birthdayremember.domain.repository.GroupRepository
import com.pmdm.birthdayremember.infraestructure.room.repository.EventRepositoryImpl
import com.pmdm.birthdayremember.infraestructure.room.repository.GroupRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AbstractionModule {
    @Binds
    abstract fun bindBirthdayRepository(impl: EventRepositoryImpl): EventRepository

    @Binds
    abstract fun bindGroupRepository(impl : GroupRepositoryImpl) : GroupRepository

    //@Binds
    //abstract fun bindChipConfigProvider(impl: LobbyChipConfigProvider): ChipConfigProvider<LobbyEvent>
}