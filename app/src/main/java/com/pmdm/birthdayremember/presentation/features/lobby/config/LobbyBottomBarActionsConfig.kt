package com.pmdm.birthdayremember.presentation.features.lobby.config

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.CalendarMonth
import androidx.compose.material.icons.twotone.Home
import com.pmdm.birthdayremember.presentation.components.bottombar.BottomBarAction
import com.pmdm.birthdayremember.presentation.features.lobby.LobbyEvent
import com.pmdm.birthdayremember.presentation.features.lobby.LobbyNavigationEvent

fun lobbyBottomBarActionsConfig(): List<BottomBarAction<LobbyNavigationEvent>> =
    listOf(
        BottomBarAction(
            event = LobbyNavigationEvent.OnNavigateLobby,
            icon = Icons.TwoTone.Home,
            description = "List of Birthdays"
        ),
        BottomBarAction(
            event = LobbyNavigationEvent.OnNavigateCalendar,
            icon = Icons.TwoTone.CalendarMonth,
            description = "Calendar"
        ),
    )



