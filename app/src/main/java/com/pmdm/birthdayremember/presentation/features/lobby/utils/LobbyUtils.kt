package com.pmdm.birthdayremember.presentation.features.lobby.utils

import com.pmdm.birthdayremember.presentation.features.lobby.model.BirthdayUiState
import java.time.format.DateTimeFormatter

fun BirthdayUiState.formattedDate(): String {
    val formatWithYear = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val formatWithoutYear = DateTimeFormatter.ofPattern("dd/MM")

    if (this.hasYear)
        return this.date.format(formatWithYear)

    return this.date.format(formatWithoutYear)
}