package com.pmdm.birthdayremember.presentation.features.lobby.config

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.CalendarMonth
import androidx.compose.material.icons.twotone.Home
import com.pmdm.birthdayremember.presentation.components.bottombar.BottomBarAction
import com.pmdm.birthdayremember.presentation.features.lobby.LobbyEvent

fun lobbyBottomBarActionsConfig(): List<BottomBarAction<LobbyEvent>> =
    listOf(
        BottomBarAction(
            event = LobbyEvent.OnNavigateLobby,
            icon = Icons.TwoTone.Home,
            description = "List of Birthdays"
        ),
        BottomBarAction(
            event = LobbyEvent.OnNavigateCalendar,
            icon = Icons.TwoTone.CalendarMonth,
            description = "Calendar"
        ),
    )



