package com.pmdm.birthdayremember.application.usecase.birthday

import android.util.Log
import com.pmdm.birthdayremember.domain.entity.Birthday
import com.pmdm.birthdayremember.domain.repository.BirthdayRepository
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class CreateBirthdayUseCase @Inject constructor(
    private val birthdayRepository: BirthdayRepository
) {
    suspend operator fun invoke(birthday: Birthday): Result<Unit> {
        try {
            birthdayRepository.insert(birthday)

            return Result.success(Unit)
        } catch (e: Exception) {
            Log.e(this.javaClass.name, e.localizedMessage ?: "Error sin mensaje")
            return Result.failure(e)
        }
    }
}