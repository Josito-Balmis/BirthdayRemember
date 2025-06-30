package com.pmdm.birthdayremember.application.usecase.seeder

import com.pmdm.birthdayremember.infraestructure.room.seeder.InitialGroupSeeder
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SeedGroupsUseCase @Inject constructor(
    private val seeder: InitialGroupSeeder
) {
    suspend operator fun invoke() {
        seeder.seedIfIsEmpty()
    }
}