package com.pmdm.birthdayremember.domain.error

sealed class GroupError(message: String, cause : Throwable? = null) : Exception(message, cause) {
    data class NotFound(val id: Int) : GroupError("Grupo no encontrado con la id: $id")
}