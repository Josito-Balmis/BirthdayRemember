package com.pmdm.birthdayremember.presentation.navigation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.pmdm.birthdayremember.presentation.features.lobby.LobbyScreen
import com.pmdm.birthdayremember.presentation.features.lobby.LobbyVM
import com.pmdm.birthdayremember.presentation.features.lobby.event.LobbyNavigationEvent
import kotlinx.serialization.Serializable

@Serializable
data object LobbyRoute

fun NavGraphBuilder.displayLobbyDestination(
    onNavigate: (LobbyNavigationEvent) -> Unit
) {
    composable<LobbyRoute> {
        val vm = hiltViewModel<LobbyVM>()

        val lobbyUiState by vm.uiState.collectAsStateWithLifecycle()
        val listTopBarActions by vm.listTopBarActions.collectAsStateWithLifecycle()
        val listBottomBarActions by vm.listBottomBarAction.collectAsStateWithLifecycle()

        LobbyScreen(
            lobbyUiState = lobbyUiState,
            listTopBarActions = listTopBarActions,
            listBottomBarActions = listBottomBarActions,
            onLobbyEvent = vm::onLobbyEvent,
            onNavigate = onNavigate,
        )
    }
}