package com.pmdm.birthdayremember.presentation.features.lobby

sealed interface LobbyEvent {
    data class OnSelectGroup(val groupId: Int) : LobbyEvent
}