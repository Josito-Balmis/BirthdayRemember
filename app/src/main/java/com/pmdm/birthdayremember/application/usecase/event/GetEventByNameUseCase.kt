package com.pmdm.birthdayremember.application.usecase.event

import android.util.Log
import com.pmdm.birthdayremember.domain.entity.Event
import com.pmdm.birthdayremember.domain.error.AppError
import com.pmdm.birthdayremember.domain.error.EventError
import com.pmdm.birthdayremember.domain.repository.EventRepository
import okio.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetEventByNameUseCase @Inject constructor(
    private val eventRepository: EventRepository
) {
    suspend operator fun invoke(name: String): Result<Event> {
        try {
            val event = eventRepository.getByName(name) ?: return Result.failure(
                EventError.NotFoundByName(name)
            )

            return Result.success(event)
        } catch (e: IOException) {
            return Result.failure(AppError.DatabaseError(e))
        } catch (e: Exception) {
            Log.e(this.javaClass.name, e.localizedMessage ?: "Error desconocido")
            return Result.failure(AppError.UnknownError)
        }
    }
}