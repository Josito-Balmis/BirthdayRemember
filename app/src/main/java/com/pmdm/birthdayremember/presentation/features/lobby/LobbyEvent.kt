package com.pmdm.birthdayremember.presentation.features.lobby

sealed interface LobbyEvent {
    data class OnSelectGroup(val groupId: Int) : LobbyEvent
    data class OnShowBottomSheet(val isShow: Boolean) : LobbyEvent
    data object OnButtonSearch : LobbyEvent
    data object OnButtonFilter : LobbyEvent
    data object OnNavigateLobby : LobbyEvent
    data object OnNavigateCalendar : LobbyEvent
    data class OnNavigateImportContacts(val isShow: Boolean = false) : LobbyEvent
    data class OnNavigateAddEvent(val isShow: Boolean = false) : LobbyEvent
    data class OnNavigateAddCategory(val isShow: Boolean = false) : LobbyEvent
}