package com.pmdm.birthdayremember.application.usecase.birthday

import android.util.Log
import com.pmdm.birthdayremember.domain.entity.Birthday
import com.pmdm.birthdayremember.domain.repository.BirthdayRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetListBirthdaysUseCase @Inject constructor(
    private val birthdayRepository: BirthdayRepository
) {
    suspend operator fun invoke(): Result<List<Birthday>> {
        try {
            val birthdays = birthdayRepository.get()

            return Result.success(birthdays)
        } catch (e: Exception) {
            Log.e(this.javaClass.name, e.localizedMessage ?: "Error sin mensaje")
            return Result.failure(e)
        }
    }
}