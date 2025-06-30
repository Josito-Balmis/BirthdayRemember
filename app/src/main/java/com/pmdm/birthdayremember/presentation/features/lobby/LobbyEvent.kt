package com.pmdm.birthdayremember.presentation.features.lobby

sealed interface LobbyEvent {
    data class OnSelectGroup(val groupId: Int) : LobbyEvent
    data object OnButtonSearch : LobbyEvent
    data object OnButtonFilter : LobbyEvent
}