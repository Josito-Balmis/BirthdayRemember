package com.pmdm.birthdayremember.presentation.features.eventcreator

import com.pmdm.birthdayremember.presentation.features.lobby.model.BirthdayUiState
import java.time.LocalDate

sealed interface EventsCreatorEvent {
    data class OnShowBottomSheet(val isShow: Boolean = false) : EventsCreatorEvent
    data object OnDeleteEvent :
        EventsCreatorEvent // Su proposito es borrar un evento adjuntado a una persona, como un cumpleaños, aniversario, etc...
    data class OnSaveEvent(val birthdayUiState: BirthdayUiState) : EventsCreatorEvent

    data class OnNameChanged(val name: String) : EventsCreatorEvent
    data class OnDateChanged(val date : LocalDate) : EventsCreatorEvent
}