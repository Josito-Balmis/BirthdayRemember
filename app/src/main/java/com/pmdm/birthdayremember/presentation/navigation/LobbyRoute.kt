package com.pmdm.birthdayremember.presentation.navigation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.pmdm.birthdayremember.presentation.features.lobby.LobbyNavigationEvent
import com.pmdm.birthdayremember.presentation.features.lobby.LobbyScreen
import com.pmdm.birthdayremember.presentation.features.lobby.LobbyVM
import kotlinx.serialization.Serializable

@Serializable
data object LobbyRoute

fun NavGraphBuilder.displayLobbyDestination(
    onNavigate: (LobbyNavigationEvent) -> Unit
) {
    composable<LobbyRoute> {
        val vm = hiltViewModel<LobbyVM>()

        val listGroups by vm.listGroups.collectAsStateWithLifecycle()
        val listBirthdays by vm.listBirthdays.collectAsStateWithLifecycle()
        val listTopBarActions by vm.listTopBarActions.collectAsStateWithLifecycle()
        val listBottomBarActions by vm.listBottomBarAction.collectAsStateWithLifecycle()
        val showBottomSheet by vm.showBottomSheet.collectAsStateWithLifecycle()

        LobbyScreen(
            listGroups = listGroups,
            listBirthdays = listBirthdays,
            listTopBarActions = listTopBarActions,
            listBottomBarActions = listBottomBarActions,
            onLobbyEvent = vm::onLobbyEvent,
            showBottomSheet = showBottomSheet,
            onNavigate = onNavigate,
        )
    }
}