package com.pmdm.birthdayremember.presentation.features.lobby

import com.pmdm.birthdayremember.domain.entity.Birthday
import com.pmdm.birthdayremember.presentation.model.BirthdayUiState

fun Birthday.toUi() = BirthdayUiState(
    id,
    idGroup,
    zodiac,
    name,
    date,
    hasYear,
    notes,
    image
)

fun List<Birthday>.toListUi() = map {
    it.toUi()
}