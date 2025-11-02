package com.pmdm.birthdayremember.domain.error

sealed class AppError(message: String, cause : Throwable? = null) : Exception(message, cause) {
    data class DatabaseError(override val cause: Throwable?) : AppError("Error de base de datos: ${cause?.message}")
    data object UnknownError : AppError("Error desconocido")
}