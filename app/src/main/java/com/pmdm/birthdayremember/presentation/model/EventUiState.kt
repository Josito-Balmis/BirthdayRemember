package com.pmdm.birthdayremember.presentation.model

import java.time.LocalDate
import java.time.format.DateTimeFormatter

// Constants
private val formatWithYear = DateTimeFormatter.ofPattern("dd/MM/yyyy")
private val formatWithoutYear = DateTimeFormatter.ofPattern("dd/MM")

//Main class
data class EventUiState(
    val id: Int = 0,
    val groupUiState: GroupUiState = GroupUiState(),
    val eventDetails: EventDetails = EventDetails(),
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