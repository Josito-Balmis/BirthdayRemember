package com.pmdm.birthdayremember.domain.error

sealed class EventError(message: String, cause: Throwable? = null) : Exception(message, cause) {
    data class NotFoundById(val id: Int) : EventError("Evento no encontrado con la id: $id")
    data class NotFoundByName(val name: String) :
        EventError("Evento no encontrado con el nombre: $name")
}