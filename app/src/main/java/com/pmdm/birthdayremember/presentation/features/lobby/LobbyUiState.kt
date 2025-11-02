package com.pmdm.birthdayremember.presentation.features.lobby

import com.pmdm.birthdayremember.presentation.model.EventUiState
import com.pmdm.birthdayremember.presentation.model.GroupUiState

data class LobbyUiState(
    val birthdaySelected: EventUiState? = null,
    val groupSelected: GroupUiState? = null,
    val listBirthdays: List<EventUiState> = emptyList(),
    val listGroups: List<GroupUiState> = emptyList(),
    val showBottomSheet: Boolean = false,
)