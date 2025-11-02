package com.pmdm.birthdayremember.application.usecase.event

import android.util.Log
import com.pmdm.birthdayremember.domain.entity.Event
import com.pmdm.birthdayremember.domain.repository.EventRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetAllBirthdaysUseCase @Inject constructor(
    private val eventRepository: EventRepository
) {
    suspend operator fun invoke(): Result<List<Event>> {
        try {
            val birthdays = eventRepository.get()

            return Result.success(birthdays)
        } catch (e: Exception) {
            Log.e(this.javaClass.name, e.localizedMessage ?: "Error desconocido")
            return Result.failure(e)
        }
    }
}