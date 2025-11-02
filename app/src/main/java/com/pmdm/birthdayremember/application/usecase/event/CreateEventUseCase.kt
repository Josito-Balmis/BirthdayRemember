package com.pmdm.birthdayremember.application.usecase.event

import android.util.Log
import com.pmdm.birthdayremember.domain.entity.Event
import com.pmdm.birthdayremember.domain.repository.EventRepository
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class CreateBirthdayUseCase @Inject constructor(
    private val eventRepository: EventRepository
) {
    suspend operator fun invoke(event: Event): Result<Unit> {
        try {
            eventRepository.insert(event)

            return Result.success(Unit)
        } catch (e: Exception) {
            Log.e(this.javaClass.name, e.localizedMessage ?: "Error sin mensaje")
            return Result.failure(e)
        }
    }
}