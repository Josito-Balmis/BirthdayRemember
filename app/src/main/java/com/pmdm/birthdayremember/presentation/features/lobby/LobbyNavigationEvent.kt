package com.pmdm.birthdayremember.presentation.features.lobby

sealed interface LobbyNavigationEvent {
    data object OnNavigateLobby : LobbyNavigationEvent
    data object OnNavigateCalendar : LobbyNavigationEvent
    data object OnNavigateImportContacts : LobbyNavigationEvent
    data object OnNavigateAddEvent : LobbyNavigationEvent
    data object OnNavigateAddCategory : LobbyNavigationEvent
}