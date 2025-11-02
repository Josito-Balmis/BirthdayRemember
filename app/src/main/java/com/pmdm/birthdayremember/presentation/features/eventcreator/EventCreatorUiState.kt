package com.pmdm.birthdayremember.presentation.features.eventcreator

import com.pmdm.birthdayremember.presentation.model.EventUiState
import com.pmdm.birthdayremember.presentation.model.GroupUiState

data class EventCreatorUiState(
    val listGroups: List<GroupUiState> = emptyList(),
    val listBirthdays: List<EventUiState> = mutableListOf(),
    val name: String = "",
    val birthdaySelected: EventUiState? = null,
    val groupSelected: GroupUiState? = null,
    val showBottomSheet: Boolean = false
)
