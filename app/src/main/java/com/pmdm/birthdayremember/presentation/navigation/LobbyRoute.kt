package com.pmdm.birthdayremember.presentation.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.pmdm.birthdayremember.presentation.features.lobby.LobbyScreen
import com.pmdm.birthdayremember.presentation.features.lobby.LobbyVM
import kotlinx.serialization.Serializable

@Serializable
data object LobbyRoute

fun NavGraphBuilder.displayLobbyDestination(
    vm: LobbyVM
) {
    composable<LobbyRoute> {
        val listGroups by vm.listGroups.collectAsState()
        val listBirthdays by vm.birthdays.collectAsState()
        val listTopBarActions by vm.listTopBarActions.collectAsState()
        val listBottomBarActions by vm.listBottomBarAction.collectAsState()
        val showBottomSheet by vm.showBottomSheet.collectAsState()

        LobbyScreen(
            listGroups = listGroups,
            listBirthdays = listBirthdays,
            listTopBarActions = listTopBarActions,
            listBottomBarActions = listBottomBarActions,
            onLobbyEvent = vm::onLobbyEvent,
            showBottomSheet = showBottomSheet,
        )
    }
}