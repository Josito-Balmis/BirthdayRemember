package com.pmdm.birthdayremember.presentation.features.lobby.mapper

import com.pmdm.birthdayremember.domain.entity.Birthday
import com.pmdm.birthdayremember.presentation.model.BirthdayUiState
import com.pmdm.birthdayremember.presentation.model.GroupUiState

fun Birthday.toUi() = BirthdayUiState(
    id,
    groupUiState = GroupUiState(id = id),
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