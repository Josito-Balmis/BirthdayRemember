package com.pmdm.birthdayremember.presentation.features.lobby.mapper

import com.pmdm.birthdayremember.domain.entity.Event
import com.pmdm.birthdayremember.presentation.model.EventUiState
import com.pmdm.birthdayremember.presentation.model.GroupUiState

fun Event.toUi() = EventUiState(
    id,
    groupUiState = GroupUiState(id = id),
    zodiac,
    name,
    eventDate,
    hasYear,
    notes,
    image
)

fun List<Event>.toListUi() = map {
    it.toUi()
}