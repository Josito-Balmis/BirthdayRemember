package com.pmdm.birthdayremember.domain.entity

import com.pmdm.birthdayremember.domain.valueobject.Zodiac
import java.time.LocalDate

class Birthday(
    val id: Int,
    val idGroup: Int,
    val zodiac: Zodiac,
    val name: String,
    val date: LocalDate,
    val hasYear: Boolean,
    val notes: String?,
    val image: String?
) {
    init {
        require(idGroup != 0) {
            "Grupo no seleccionado."
        }
        require(name.isNotBlank()) {
            "El nombre no puede estar vacío."
        }
    }

}