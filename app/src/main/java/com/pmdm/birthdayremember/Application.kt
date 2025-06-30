package com.pmdm.birthdayremember

import android.app.Application
import com.pmdm.birthdayremember.application.usecase.seeder.SeedGroupsUseCase
import dagger.hilt.android.HiltAndroidApp
import jakarta.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@HiltAndroidApp
class Application : Application() {

    @Inject
    lateinit var seedGroupUseCase: SeedGroupsUseCase

    override fun onCreate() {
        super.onCreate()

        CoroutineScope(Dispatchers.IO).launch {
            seedGroupUseCase()
        }
    }
}