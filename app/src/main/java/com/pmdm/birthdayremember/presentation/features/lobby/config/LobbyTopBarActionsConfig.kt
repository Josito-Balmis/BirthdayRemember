package com.pmdm.birthdayremember.presentation.features.lobby.config

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.FilterAlt
import androidx.compose.material.icons.twotone.Search
import com.pmdm.birthdayremember.presentation.components.TopBar.TopBarAction
import com.pmdm.birthdayremember.presentation.features.lobby.LobbyEvent

fun lobbyTopBarActionsConfig(): List<TopBarAction<LobbyEvent>> =
    listOf(
        TopBarAction(
            icon = Icons.TwoTone.Search,
            description = "Birthday seeker",
            event = LobbyEvent.OnButtonSearch
        ),

        TopBarAction(
            icon = Icons.TwoTone.FilterAlt,
            description = "Birthday filter",
            event = LobbyEvent.OnButtonFilter
        ),
    )