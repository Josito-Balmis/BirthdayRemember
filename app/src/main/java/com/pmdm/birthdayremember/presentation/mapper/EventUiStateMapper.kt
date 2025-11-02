package com.pmdm.birthdayremember.presentation.mapper

import com.pmdm.birthdayremember.domain.entity.Event
import com.pmdm.birthdayremember.presentation.model.EventDetails
import com.pmdm.birthdayremember.presentation.model.EventUiState

fun Event.toUi() = EventUiState(
    id = id,
    groupUiState = group.toUi(),
    eventDetails = EventDetails(
        age = eventDate.age(),
        zodiacName = zodiac.name.toString(),
        daysRemaining = eventDate.remainingDays()
    ),
    name = name,
    date = eventDate.localDate,
    hasYear = false,
    notes = notes,
    image = image
)

fun List<Event>.toListUi() = map {
    it.toUi()
}