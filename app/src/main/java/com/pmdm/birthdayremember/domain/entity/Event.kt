package com.pmdm.birthdayremember.domain.entity

import com.pmdm.birthdayremember.domain.valueobject.EventDate
import com.pmdm.birthdayremember.domain.valueobject.Zodiac

class Event(
    val id: Int,
    val group: Group,
    val name: String,
    val eventDate: EventDate,
    val notes: String?,
    val image: String?
) {
    val zodiac = Zodiac.fromDate(eventDate.localDate)

    init {
        require(group.id != 0) { "Grupo no seleccionado." }
        require(name.isNotBlank()) { "El nombre no puede estar vacío." }
    }
}