package com.pmdm.birthdayremember.di

import com.pmdm.birthdayremember.domain.repository.BirthdayRepository
import com.pmdm.birthdayremember.infraestructure.room.repository.BirthdayRepositoryImpl
import com.pmdm.birthdayremember.presentation.config.ChipConfigProvider
import com.pmdm.birthdayremember.presentation.config.LobbyChipConfigProvider
import com.pmdm.birthdayremember.presentation.features.lobby.LobbyEvent
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AbstractionModule {
    @Binds
    abstract fun bindBirthdayRepository(impl: BirthdayRepositoryImpl): BirthdayRepository

    @Binds
    abstract fun bindChipConfigProvider(impl: LobbyChipConfigProvider): ChipConfigProvider<LobbyEvent>
}