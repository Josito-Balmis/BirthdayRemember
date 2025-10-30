package com.pmdm.birthdayremember.presentation.features.eventcreator

import com.pmdm.birthdayremember.presentation.model.BirthdayUiState
import com.pmdm.birthdayremember.presentation.model.GroupUiState

data class EventCreatorUiState(
    val listGroups: List<GroupUiState> = emptyList(),
    val name: String = "",
    val birthdaySelected: BirthdayUiState? = null,
    val groupSelected: GroupUiState? = null,
    val showBottomSheet: Boolean = false
)
