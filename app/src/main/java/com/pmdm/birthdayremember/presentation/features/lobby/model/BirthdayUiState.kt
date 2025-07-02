package com.pmdm.birthdayremember.presentation.features.lobby.model

import com.pmdm.birthdayremember.domain.valueobject.Zodiac
import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class BirthdayUiState(
    val id: Int = 0,
    val idGroup: Int = 0,
    val zodiac: Zodiac = Zodiac(Zodiac.ZodiacName.Ninguno),
    val name: String = "",
    val date: LocalDate = LocalDate.now(),
    val hasYear: Boolean = false,
    val notes: String? = null,
    val image: String? = null
) {
    fun formattedDate(): String {
        val formatWithYear = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val formatWithoutYear = DateTimeFormatter.ofPattern("dd/MM")

        if (this.hasYear)
            return this.date.format(formatWithYear)

        return this.date.format(formatWithoutYear)
    }
}
