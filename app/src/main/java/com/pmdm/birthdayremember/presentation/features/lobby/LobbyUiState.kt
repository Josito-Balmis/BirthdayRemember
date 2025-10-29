package com.pmdm.birthdayremember.presentation.features.lobby

import com.pmdm.birthdayremember.presentation.model.BirthdayUiState
import com.pmdm.birthdayremember.presentation.model.GroupUiState

data class LobbyUiState(
    val birthdaySelected: BirthdayUiState? = null,
    val groupSelected: GroupUiState? = null,
    val listBirthdays: List<BirthdayUiState> = emptyList(),
    val listGroups: List<GroupUiState> = emptyList(),
    val showBottomSheet: Boolean = false,
)