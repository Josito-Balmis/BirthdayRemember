package com.pmdm.birthdayremember.presentation.model

import com.pmdm.birthdayremember.domain.valueobject.Zodiac
import java.time.LocalDate
import java.time.format.DateTimeFormatter

// Constants
private val formatWithYear = DateTimeFormatter.ofPattern("dd/MM/yyyy")
private val formatWithoutYear = DateTimeFormatter.ofPattern("dd/MM")

//Main class
data class BirthdayUiState(
    val id: Int = 0,
    val groupUiState: GroupUiState = GroupUiState(),
    val zodiac: Zodiac = Zodiac(Zodiac.ZodiacName.Ninguno),
    val name: String = "",
    val date: LocalDate? = null,
    val hasYear: Boolean = true,
    val notes: String? = null,
    val image: String? = null
) {
    fun formattedDate(): String {
        if (date == null) return ""
        if (this.hasYear)
            return this.date.format(formatWithYear)

        return this.date.format(formatWithoutYear)
    }
}